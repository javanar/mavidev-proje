package com.javanar;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {ContextLoaderListener.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
	    return new Filter[] { new HiddenHttpMethodFilter(), 
	                            new CharacterEncodingFilter("UTF-8", true) };
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

	      FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8", true));
	      filterRegistration.addMappingForUrlPatterns(null, false, "/*");

	      filterRegistration = servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter() );
	      filterRegistration.addMappingForUrlPatterns(null, false, "/*");

	    super.onStartup(servletContext);
	}

}
