/**
 * Created by Allen on 2016/7/15.
 */
package com.jusbilee.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiMain {
	
    public static void main(String[] args) {
        SpringApplication.run(ApiMain.class, args);
    }
}
