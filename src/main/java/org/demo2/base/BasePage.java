package org.demo2.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private DriverBase driver;
    public BasePage(DriverBase driver){
        this.driver = driver;
    }

    /**
     * 封装Element
     * @param by
     * @return
     */
    public WebElement element(By by){
        return driver.element(by);
    }

    /**
     * Click
     * @param element
     */
    public void click(WebElement element){
        if (element != null){
            element.click();
        }else {
            System.out.println("你要点击元素不存在");
        }
    }

    /**
     * sendKeys
     * @param element
     * @param context
     */
    public void sendKey(WebElement element, String context){
        if (element != null){
            element.clear();
            element.sendKeys(context);
        }else {
            System.out.println("你要输入的元素不存在");
        }
    }

}
