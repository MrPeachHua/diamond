package com.fd.diamond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author share2
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DiamondApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiamondApplication.class, args);
	}

}
