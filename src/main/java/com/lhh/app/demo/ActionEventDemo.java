package com.lhh.app.demo;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
//import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ActionEventDemo implements ActionListener{
    ActionEventDemo(){
        System.setProperty("java.awt.headless", "false");
        JFrame frame=new JFrame();
        JButton button=new JButton("Run");
        prepareGUI(frame);
        buttonProperties(frame, button);
        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
 
    public void prepareGUI(JFrame frame){
        frame.setTitle("My Window");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(200,200,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void buttonProperties(JFrame frame, JButton button){
        button.setBounds(130,200,100,40);
        frame.add(button);
        button.addActionListener(this);
    }

    public void sincronize_wait(WebDriver driver) throws InterruptedException{
        // sincronize driver for setting wait state
		synchronized(driver){
			try{
				// wait 10 seconds
				int time_secs = 10;
				driver.wait(time_secs * 1000); 
			} catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Changing Background Color
        //frame.getContentPane().setBackground(Color.pink);

        //print hello world
		System.out.println("Hello, World!");

		// setup chrome driver environment path
		System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");

		// create chrome driver object
        ChromeOptions option = new ChromeOptions();
		WebDriver driver = new ChromeDriver(option);
		
		// get google page
		driver.get("https://www.google.it");
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("L2AGLb")).click();

        try {
            sincronize_wait(driver);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

		// close chrome driver
		driver.close(); 
		// quit chrome driver
		//driver.quit();

        System.out.println("ChromeDriver was stopped successfully.");

		// remove all chromedriver processes left active if present
/* 		if(System.getProperty("os.name").contains("Windows")) {
            try {
                Process process;
                process = Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
                process.destroy();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
*/

    }
}
 

