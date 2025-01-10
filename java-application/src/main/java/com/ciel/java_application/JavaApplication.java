package com.ciel.java_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ciel.kotlin_library.ExampleStringProducer;

@SpringBootApplication(scanBasePackages = "com.ciel")
@RestController
public class JavaApplication {
	private final ExampleStringProducer exampleProducer;

	public JavaApplication(ExampleStringProducer stringProducer) {
		this.exampleProducer = stringProducer;
	}
		@PostMapping("/test")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void home(@RequestBody RequestBodyDto requestBody) {
				String message = requestBody.message;
				exampleProducer.sendStringMessage(message);
		}
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

}
class RequestBodyDto {
		public String message;
}
