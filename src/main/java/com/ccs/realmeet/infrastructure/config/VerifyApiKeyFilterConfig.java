package com.ccs.realmeet.infrastructure.config;

import com.ccs.realmeet.domain.repository.UserRepository;
import com.ccs.realmeet.infrastructure.security.VerifyApiKeyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@Configuration
public class VerifyApiKeyFilterConfig {

    private final UserRepository repository;

    public VerifyApiKeyFilterConfig(UserRepository repository) {
        this.repository = repository;
    }

    @Bean
    public FilterRegistrationBean<VerifyApiKeyFilter> verifyApiKeyFilter() {

        var filter = new FilterRegistrationBean<VerifyApiKeyFilter>();
        filter.setFilter(new VerifyApiKeyFilter(repository));
        filter.addUrlPatterns("/rooms/*", "/allocations/*");

        return filter;
    }
}
