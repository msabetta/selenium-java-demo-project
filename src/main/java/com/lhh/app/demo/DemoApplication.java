package com.lhh.app.demo;

import com.lhh.app.demo.ActionEventDemo;

import java.io.IOException;
import java.awt.HeadlessException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException, IOException, HeadlessException {
		SpringApplication.run(DemoApplication.class, args);
		new ActionEventDemo();
    }

}
