package com.ccs.realmeet.infrastructure.security;

import com.ccs.realmeet.domain.entity.User;
import com.ccs.realmeet.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class VerifyApiKeyFilter extends GenericFilterBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyApiKeyFilter.class);

    private static final String HEADER_API_KEY = "apiKey";
    private final UserRepository repository;

    public VerifyApiKeyFilter(UserRepository repository) {
        this.repository = repository;
    }



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) servletRequest;
        var httpResponse = (HttpServletResponse) servletResponse;

        var apikey = httpRequest.getHeader(HEADER_API_KEY);

        if (isNotBlank(apikey) && validateApiKey(apikey)) {

            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            sendUnauthorizedError(httpResponse, apikey);
        }
    }

    private Boolean validateApiKey(String apikey) {

        return repository.findById(apikey)
                .filter(User::getActive)
                .stream()
                .peek(user -> LOGGER.trace("Valid Api Key received: {} User Description ({})", user.getApi_key(), user.getDescription()))
                .findFirst()
                .isPresent();
    }

    private void sendUnauthorizedError(HttpServletResponse response, String apikey) throws IOException {

        var errorMessage = isBlank(apikey) ? "Api Key ausente." : "Api Key inválida.";
        LOGGER.error(errorMessage);

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setCharacterEncoding("UTF-8");

        try (Writer out = response.getWriter()) {
            out.write(errorMessage);
        }
    }
}
