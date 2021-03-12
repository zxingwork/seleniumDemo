package org.demo2.base;



import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;

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
//        old version↓
//        return driver.element(by);

        WebDriverWait wait = new WebDriverWait(this.driver.getDriver(),10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        logger.debug("["+this.getTitle()+"]"+"获取元素"+by);
        return element;



    }

    /**
     * Click 点击
     * @param element 元素
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

    /**
     * 获取当前页面的title
     * @return title
     */
    public String getTitle(){
        return this.driver.getDriver().getTitle();
    }

    /**
     * 获取所有的标签页句柄
     * @return 句柄集合
     */
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

    /**
     * 获取当前的句柄
     * @return 句柄
     */
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

    /**
     * 窗口最大化
     */
    public void maxWindow(){
        this.driver.getDriver().manage().window().maximize();
    }

    /**
     * 截图
     */
    public void screenShot(){
        String jpgName = UUID.randomUUID().toString().replace("-","");
        File srcfile = ((TakesScreenshot) this.driver.getDriver()).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcfile, new File("screenshot\\"+jpgName+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
