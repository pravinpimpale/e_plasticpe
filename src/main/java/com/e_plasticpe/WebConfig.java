package com.e_plasticpe;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**") 
	                .allowedOrigins("http://34.133.47.122/:8080") 
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                .allowedHeaders("*") 
	                .allowCredentials(true); 
	    }
}
