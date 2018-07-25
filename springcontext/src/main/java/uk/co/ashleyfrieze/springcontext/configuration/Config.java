package uk.co.ashleyfrieze.springcontext.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "uk.co.ashleyfrieze.springcontext.service")
public class Config {
}
