package com.axel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { 
        PersistenceConfig.class,
        RepositoryConfig.class,
        ServiceConfig.class,
} )
@ComponentScan(basePackages = {"com.axel"})
public class AppConfig {


}
