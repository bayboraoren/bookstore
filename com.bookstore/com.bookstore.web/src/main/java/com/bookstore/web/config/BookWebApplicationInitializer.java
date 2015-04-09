package com.bookstore.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.bookstore.repository.config.RepositoryConfiguration;
import com.bookstore.service.config.ServiceConfiguration;

public class BookWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebMvcContextConfiguration.class);
		
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		servletContext.addListener(new RequestContextListener());		
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");		
		
		
		
		
	}
	
}
