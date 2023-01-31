package de.projet.First.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	
	@Bean
	public ModelMapper getMoelMapper() {
		return new ModelMapper();
	}

}
