package greg.wms.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(WmsApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOriginPatterns("*")
//						.allowedMethods("*")
//						.allowedHeaders("*")
//						.allowCredentials(false)
//						.maxAge(3600);
//			}
//		};
//	}
}

