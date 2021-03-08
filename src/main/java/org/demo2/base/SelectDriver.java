package org.demo2.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SelectDriver {
    /**
     * 根据用户输入选择不同的浏览器
     */
    public WebDriver driverName(String browserName){
        System.setProperty("webdriver.chrome.driver", "E:\\14Gitlib\\seleniumDemo\\dirver\\chromedriver.exe");
        if (browserName.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();
        }else {
            return new ChromeDriver();
        }
    }
}
