package com.ems.starter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
        Path path = Paths.get("employee-images");
        String upload_path = path.toFile().getAbsolutePath();
        registry.addResourceHandler("/employee-images/**").addResourceLocations("file:/" + upload_path + "/");
        System.out.println(registry.addResourceHandler("/employee-images/**").addResourceLocations("file:/" + upload_path + "/"));


    }

}
