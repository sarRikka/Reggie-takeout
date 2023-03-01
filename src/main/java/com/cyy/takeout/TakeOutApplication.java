package com.cyy.takeout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TakeOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeOutApplication.class, args);
    }

}
