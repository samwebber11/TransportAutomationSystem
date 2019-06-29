package org.sambhav.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"org.sambhav.transport"})
public class AutomatedTransport extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AutomatedTransport.class);
    }
	
	public static void main(String args[]) throws Exception
	{
		SpringApplication.run(AutomatedTransport.class,args);
	}
}
