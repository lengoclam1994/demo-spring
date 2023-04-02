package com.example.demo.config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.IOException;

public class DevConfig {
    public DevConfig(final TemplateEngine templateEngine) throws IOException {
        final FileTemplateResolver fileTemplateResolver = new FileTemplateResolver();
        // ...
        templateEngine.setTemplateResolver(fileTemplateResolver);
    }
}
