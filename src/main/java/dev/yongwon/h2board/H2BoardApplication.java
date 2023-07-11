package dev.yongwon.h2board;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication 
public class H2BoardApplication {

	public static void main(String[] args) {
		System.out.println("bug fixing");	
		SpringApplication.run(H2BoardApplication.class, args); 
	}
}