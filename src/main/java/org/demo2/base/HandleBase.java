package org.demo2.base;

import org.apache.log4j.Logger;
import org.demo2.pages.LoginCapPage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class HandleBase {
    private static Logger logger = Logger.getLogger(HandleBase.class.getName());
    BasePage basePage;
    private WebDriver driver;
    public HandleBase(){}
    public HandleBase(DriverBase driver){
        this.driver = driver.getDriver();
    }
//    public void switchToNewWindow(){
//        logger.debug("切换至最新的标签页");
//        String parentHandle = this.getDriver().getWindowHandle();
//        Set<String> handles = this.getDriver().getWindowHandles();
//        for (String handle : handles) {
//            System.out.println(handle);
//            if (!handle.equals(parentHandle)){
//                this.driver.switchTo().window(handle);
//                logger.debug("切换页面至："+handle);
//            }
//        }
//    }

//    public WebDriver getDriver() {
//        return this.driver;
//    }
}
