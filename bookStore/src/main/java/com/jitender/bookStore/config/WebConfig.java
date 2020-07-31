package com.jitender.bookStore.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.ViewFactoryCreator;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages=("com.jitender.bookStore.controller"))
public class WebConfig extends AbstractFlowConfiguration implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
     }
	@Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/assets/");
	    }
//	 @Override
//	    public void addViewControllers(ViewControllerRegistry registry) {
//	        registry.addViewController("/about").setViewName("about");
//	    }
	
	@Bean
	public ViewResolver viewrResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	@Bean
	public FlowDefinitionRegistry flowRegistry() {
	    
	    return getFlowDefinitionRegistryBuilder()
	            .addFlowLocationPattern("/**/*-flow.xml")
	            .build();
	}
	
    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry()).build();
    }
	
	@Bean
	public FlowBuilderServices flowBuilderServices() {
	    return getFlowBuilderServicesBuilder()
	    		.setViewFactoryCreator(mvcViewFactoryCreator())
	    		.build();
	}
	private ViewFactoryCreator mvcViewFactoryCreator() {
	     MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
	        factoryCreator.setViewResolvers(
	          Collections.singletonList(this.viewrResolver()));
	        factoryCreator.setUseSpringBeanBinding(true);
	        return factoryCreator;
	}
	
	
	
}
