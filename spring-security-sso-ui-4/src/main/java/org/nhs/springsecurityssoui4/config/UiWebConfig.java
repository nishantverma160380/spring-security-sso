package org.nhs.springsecurityssoui4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class UiWebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	       registry.addResourceHandler("/resources/**")
           .addResourceLocations("/resources/");
	}
	
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
