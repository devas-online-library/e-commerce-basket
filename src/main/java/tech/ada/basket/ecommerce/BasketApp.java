package tech.ada.basket.ecommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients(basePackages = "tech.ada.basket.ecommerce")
public class BasketApp {

	public static void main(String[] args) {
		SpringApplication.run(BasketApp.class, args);
	}

}
