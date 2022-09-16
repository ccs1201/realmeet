package com.ccs.realmeet.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolExecutorConfig {


    @Bean("threadPool")
    public Executor controllersExecutor(
            @Value("${realmeet.threadpoolexecutorconfig.corePoolSize:10}") int corePoolSize,
            @Value("${realmeet.threadpoolexecutorconfig.maxPoolSize:20}") int maxPoolSize,
            @Value("${realmeet.threadpoolexecutorconfig.queueCapacity:50}") int queueCapacity,
            @Value("${realmeet.threadpoolexecutorconfig.keepAliveSeconds:60}") int keepAliveSeconds) {

        return ForkJoinPool.commonPool();
//        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueCapacity, true));
    }
}