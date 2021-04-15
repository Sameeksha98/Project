package com.cts.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("first-service")
@Data
public class Configuration {
 private String message;
}
