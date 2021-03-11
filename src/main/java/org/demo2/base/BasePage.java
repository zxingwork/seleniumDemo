package org.demo2.base;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class BasePage {
    private Logger logger = Logger.getLogger(this.getClass().getName());
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
        logger.debug("["+this.getTitle()+"]"+"获取元素"+by);
        return driver.element(by);
    }

    /**
     * Click
     * @param element
     */
    public void click(WebElement element){
        if (element != null){
            element.click();
            logger.debug("["+this.getTitle()+"]"+"点击元素："+element);
        }else {
            logger.error("["+this.getTitle()+"]"+ElementError.ElementNotExist);
        }
    }

    /**
     * sendKeys 向指定元素输入值
     * @param element 页面元素
     * @param context 输入值
     */
    public void sendKey(WebElement element, String context){
        if (element != null){
            element.clear();
            element.sendKeys(context);
            logger.debug("["+this.getTitle()+"]"+"输入值："+context);
        }else {
            logger.error("["+this.getTitle()+"]"+"输入的元素不存在");
        }
    }
    public String getTitle(){
        return this.driver.getDriver().getTitle();
    }

    public Set<String> getWindowHandles(){
        try{
            Set<String> handles = this.driver.getDriver().getWindowHandles();
            logger.debug("获取标签页句柄："+handles);
            return handles;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("获取标签页句柄失败");
            return null;
        }
    }

    public String getWindowHandle(){
        try{
            String handle = this.driver.getDriver().getWindowHandle();
            logger.debug("获取当前页面句柄："+handle);
            return handle;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error("获取当前页面句柄失败");
            return null;
        }
    }

    /**
     * 跳转到新打开的页面句柄
     * 功能不够完善，后续需要更新
     */
    public void switchToNewWindow(){
        try {
            String parentHandle = this.getWindowHandle();
            Set<String> handles = this.getWindowHandles();
            for (String handle : handles) {
                if (!handle.equals(parentHandle)){
                    this.driver.getDriver().switchTo().window(handle);
                    logger.debug("切换句柄至："+handle);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
