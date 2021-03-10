package org.demo2.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SelectDriver {
    /**
     * 根据用户输入选择不同的浏览器
     */

    private Logger logger = Logger.getLogger(SelectDriver.class.getName());
    public WebDriver driverName(String browserName){
        System.setProperty("webdriver.chrome.driver", "E:\\14Gitlib\\seleniumDemo\\dirver\\chromedriver.exe");
        if (browserName.equalsIgnoreCase("firefox")){
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            logger.debug("选择浏览器：FireFox");
            return new FirefoxDriver();
        }else {
            ChromeDriver chromeDriver = new ChromeDriver();
            logger.debug("选择浏览器：Chrome");
            return chromeDriver;
        }
    }
}
