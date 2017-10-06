package org.baeldung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class UiWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    	viewResolver.setViewClass(JstlView.class);
    	viewResolver.setPrefix("/WEB-INF/");
    	viewResolver.setSuffix(".jsp");
    	return viewResolver;
    }
    
    @Bean
    public ResourceBundleMessageSource messageSource(){
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    	messageSource.setBasenames(new String[]{"validation"});
    	return messageSource;
    }

/*    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("forward:/index");
        registry.addViewController("/index");
        registry.addViewController("/securedPage");
    }*/

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
    }

}