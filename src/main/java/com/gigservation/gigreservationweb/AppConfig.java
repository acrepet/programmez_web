/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gigservation.gigreservationweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author agnes007
 */
@Configuration
public class AppConfig {

	// Resolve logical view names to .jsp resources in the /WEB-INF/views directory
	@Bean
	ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}

