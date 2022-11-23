package com.lhh.app.demo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(DemoApplication.class, args);
		
		//print hello world
		System.out.println("Hello, World!");

		// setup chrome driver environment path
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");

		// create chrome driver object
		WebDriver driver = new ChromeDriver();
		
		// get google page
		driver.get("https://www.google.it");


		synchronized(driver){
			try{
				// wait 10 seconds
				int time_secs = 10;
				driver.wait(time_secs * 1000); 
			} catch (InterruptedException e) {
                e.printStackTrace();
            }
		}

		// close chrome driver
		driver.close(); 
		// quit chrome driver
		driver.quit();

		// remove all chromedriver processes left active if present
		if(System.getProperty("os.name").contains("Windows")) {
            Process process = Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            process.destroy();
		}
    }

}
