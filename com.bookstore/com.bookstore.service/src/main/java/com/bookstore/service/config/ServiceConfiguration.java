package com.bookstore.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bookstore.repository.config.RepositoryConfiguration;


@Configuration
@ComponentScan(basePackages={"com.bookstore.service"})
@Import(value={RepositoryConfiguration.class})
public class ServiceConfiguration {

}