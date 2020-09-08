package com.antra.config;

import com.antra.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.antra")
public class WebConfig implements WebMvcConfigurer {

    //constants
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/"; //prefix is the folder path
    public static final String RESOLVER_SUFFIX = ".jsp"; //the file extension

    @Bean
    public ViewResolver viewResolve(){
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //save line space for Controller and set the view as "/"
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }
}
