package com.bionic.edu.proc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@Configuration
@ComponentScan(basePackages = "com.bionic.edu.web")
@EnableWebMvc
public class ApplicationContextConfig extends WebMvcConfigurationSupport {
	
	@Bean(name = "viewResolver")
    TilesViewResolver viewResolver(){
        TilesViewResolver viewResolver = new TilesViewResolver();
        return viewResolver;
    }
	
	@Bean(name = "tilesConfigurer")
	TilesConfigurer tilesConfigurer(){
	     TilesConfigurer tilesConfigurer = new TilesConfigurer();
	     tilesConfigurer.setDefinitions("/WEB-INF/view/**/views.xml");
	         
	     tilesConfigurer.setPreparerFactoryClass(
	     org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
	     return tilesConfigurer;    
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("\resources");
	}
}
