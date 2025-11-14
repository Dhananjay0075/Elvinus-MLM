package com.elvinus.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.concurrent.Executor;


@Configuration
@EnableAsync
@EnableScheduling
@EnableWebMvc
@ComponentScan(basePackages = "com.elvinus")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	/*@Autowired
	RoleToUserProfileConverter roleToUserProfileConverter;*/
	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	/*
	 * 
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
       // registry.addResourceHandler("/adminResource/**").addResourceLocations("/adminResource/");
    }
    
    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }*/
	
    @Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
    
    @Bean(name="multipartResolver") 
    public CommonsMultipartResolver getResolver() throws IOException{
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
         
        //Set the maximum allowed size (in bytes) for each individual file.
        //resolver.setMaxUploadSizePerFile(12582912);//12MB
       
        resolver.setMaxUploadSizePerFile(1006632960);//49MB
        resolver.setMaxUploadSize(1006632960); // 49MB
       
        //You may also set other available properties.
         
        return resolver;
    }
    
    
  
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
    
    
  
    
   /* @Bean
    public EmailSentJob sentUserMail(){
    	
    	return new EmailSentJob();
    }*/
    
}

