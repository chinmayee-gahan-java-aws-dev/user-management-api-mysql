package com.chinmayee.rest.web.usermanagementapi.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource= messageSource;
	}
	
	@GetMapping(path= "/hello-world")
	public String helloWorld() {
		return "Hello welcome to my world"; 
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello to be a beautiful World"); 
	}

	// Path Parameters
		// /users/{id}/todos/{id}  => /users/2/todos/200
		// /hello-world/path-variable/{name}
		// /hello-world/path-variable/Ranga

		@GetMapping(path = "/hello-world/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World to be welcome, %s", name)); 
		}

		@GetMapping(path= "/hello-world-Internationalized")
		public String helloWorldInternationalized() {
		//	return "Hello welcome to my world dear"; 
			
			Locale locale = LocaleContextHolder.getLocale();
			return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
		}
	
}
