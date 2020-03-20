package config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"service",
		"dao",
		"main",
		"domain"
})
public class MyConfig {
	
	
}
