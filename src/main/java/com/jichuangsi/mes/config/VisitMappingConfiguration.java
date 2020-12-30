package com.jichuangsi.mes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class VisitMappingConfiguration implements WebMvcConfigurer {
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Value("${file.imagePath}")
    private String imagePath;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("*").maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder+imagePath);

//        加上这段就能访问到swagger-ui.html了
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }
}
