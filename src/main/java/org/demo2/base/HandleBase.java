package org.demo2.base;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.demo2.pages.LoginCapPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class HandleBase {
    private static Logger logger = Logger.getLogger(HandleBase.class.getName());
    private WebDriver driver;
    public HandleBase(){}
    public HandleBase(DriverBase driver){

        this.driver = driver.getDriver();
    }

    /**
     * 截图
     * @param jpgName 图片名
     */
    public void screenShot(String jpgName){
        File srcFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        try{
            File img = new File("screenshot\\"+jpgName+".jpg");
            FileUtils.copyFile(srcFile, img);
            logger.debug("截图成功："+img.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void maxWindow(){
        this.driver.manage().window().maximize();
    }
}
