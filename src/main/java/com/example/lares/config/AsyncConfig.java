package com.example.lares.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync  // Enables async method execution in the application
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);  // Initial number of threads in the pool
        executor.setMaxPoolSize(10);  // Maximum number of threads
        executor.setQueueCapacity(25);  // Queue size before new threads are created
        executor.setThreadNamePrefix("Async-Thread-");
        executor.initialize();
        return executor;
    }
}
