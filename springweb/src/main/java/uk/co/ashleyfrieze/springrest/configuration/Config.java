package uk.co.ashleyfrieze.springrest.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "uk.co.ashleyfrieze.springrest.controller")
public class Config {
}
