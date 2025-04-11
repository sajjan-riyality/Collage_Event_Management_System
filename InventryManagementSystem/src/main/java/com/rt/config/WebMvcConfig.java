package com.rt.config;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Adjust path if your images are in project root under "uploads/images"
        registry.addResourceHandler("/uploads/images/**")
                .addResourceLocations("file:" + new File("uploads/images").getAbsolutePath() + "/");
    }
}

