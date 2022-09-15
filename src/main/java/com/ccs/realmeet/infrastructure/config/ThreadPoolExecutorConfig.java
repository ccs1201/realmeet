package com.ccs.realmeet.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolExecutorConfig {

    @Bean("pool")
    public Executor controllersExecutor(
            @Value("${realmeet.threadpoolexecutorconfig.corePoolSize:10}") int corePoolSize,
            @Value("${realmeet.threadpoolexecutorconfig.maxPoolSize:20}") int maxPoolSize,
            @Value("${realmeet.threadpoolexecutorconfig.queueCapacity:50}") int queueCapacity,
            @Value("${realmeet.threadpoolexecutorconfig.keepAliveSeconds:60}") int keepAliveSeconds) {

        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueCapacity, true));
    }
}
