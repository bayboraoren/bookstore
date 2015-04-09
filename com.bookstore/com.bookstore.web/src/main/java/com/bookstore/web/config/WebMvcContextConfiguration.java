package com.bookstore.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

import com.bookstore.repository.config.RepositoryConfiguration;
import com.bookstore.service.config.ServiceConfiguration;
import com.bookstore.web.interceptor.CommonDataHandlerInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.bookstore.web" })
@Import(value={ServiceConfiguration.class,RepositoryConfiguration.class})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver tilesViewResolver() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setOrder(1);
		urlBasedViewResolver.setViewClass(TilesView.class);
		return urlBasedViewResolver;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setViewClass(JstlView.class);
		return internalResourceViewResolver;
	}	

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer
				.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-configuration.xml" });
		return tilesConfigurer;
	}

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**/*").addResourceLocations("classpath:/META-INF/web-resources/");
	}
	
	//{LOCALE
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(commonDataHandlerInterceptor());
	}
	
	@Bean
	public CommonDataHandlerInterceptor commonDataHandlerInterceptor() {
		return new CommonDataHandlerInterceptor();
	}	
	
	
	//}LOCALE
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}	
	
	
}
