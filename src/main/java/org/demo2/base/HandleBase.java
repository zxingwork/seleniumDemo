package org.demo2.base;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.demo2.pages.LoginCapPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;


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

    /**
     * 页面窗口最大化
     */
    public void maxWindow(){
        this.driver.manage().window().maximize();
    }

    /**
     * @param AbsolutePath 上传文件的绝对路径
     */
    public void uploadFile(String AbsolutePath) throws AWTException, InterruptedException {
        StringSelection selection = new StringSelection(AbsolutePath);
        // 把图片路径复制到剪切板
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }
}
