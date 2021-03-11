package org.demo2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase {
    private WebDriver driver;
    public WebDriver getDriver(){
        return this.driver;
    }

    /**
     * 创建对象时实例化driver
     * @param browserName 浏览器名
     */
    public DriverBase(String browserName){
        SelectDriver selectDriver = new SelectDriver();
        this.driver = selectDriver.driverName(browserName);
    }

    /**
     * 封装Element方法
     * @param by
     * @return
     */
    public WebElement element(By by){
        return driver.findElement(by);
    }

    /**
     * 封装Get对象
     */
    public void getUrl(String url){
        driver.get(url);
    }
    public void maxWindow(){
        this.driver.manage().window().maximize();
    }

}
