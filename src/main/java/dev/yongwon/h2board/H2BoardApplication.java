package dev.yongwon.h2board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 


@SpringBootApplication 
public class H2BoardApplication {

	public static void main(String[] args) {
		System.out.println("h2 connection tutorial");	
		SpringApplication.run(H2BoardApplication.class, args);  //for h2 console

	}
}