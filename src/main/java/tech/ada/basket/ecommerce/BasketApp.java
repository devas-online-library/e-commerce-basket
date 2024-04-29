package tech.ada.basket.ecommerce;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tech.ada.basket.ecommerce.formatter.BasketFormatter;
import tech.ada.basket.ecommerce.formatter.BasketToJson;


@SpringBootApplication
public class BasketApp {

	public static void main(String[] args) {
		SpringApplication.run(BasketApp.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public BasketFormatter<String> basketFormatter() {
		return new BasketToJson();
	}
}
