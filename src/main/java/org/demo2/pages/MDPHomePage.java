package org.demo2.pages;

import org.apache.log4j.Logger;
import org.demo2.base.BasePage;
import org.demo2.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MDPHomePage extends BasePage {
    public MDPHomePage(DriverBase driver) {
        super(driver);
    }
    private Logger logger = Logger.getLogger(MDPHomePage.class.getName());
    public WebElement MDPProjectList(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[1]"));
    }

    public WebElement createProjectButton(){
//        return element(By.cssSelector("//span[text()='创建项目']/parent/parent::*"));
        return element(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/button/span"));
    }

    public WebElement createProjectName(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[1]/div/div/input"));
    }

    public WebElement createProjectCode(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[2]/div/div/input"));
    }

    public WebElement protectTypeSelect(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[3]/div/div/div/input"));
    }

    /**
     * 获取HTML5应用选项
     * @return WebElement
     */
    public WebElement protectTypeSelectHtml5(){
        return element(By.xpath("//span[text()='HTML5应用']/parent::*"));
    }

    /**
     * 获取混合应用选项
     * @return WebElement
     */
    public WebElement projectTypeSelectMix(){
        return element(By.xpath("//span[text()='混合应用']/parent::*"));
    }

    /**
     * 创建项目时获Android平台的元素
     * @return 元素
     */
    public WebElement platformAndroid(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[4]/div/div/label[1]/span[2]"));
    }

    /**
     * 创建项目时获取iOS平台的元素
     * @return 元素
     */
    public WebElement platformIOS(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[4]/div/div/label[2]/span[2]"));
    }

    /**
     * 离线模式
     * @return 元素
     */
    public WebElement modeOffLine(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[5]/div/label[1]/span[2]"));
    }

    /**
     * 在线模式
     * @return 元素
     */
    public WebElement modeOnline(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[5]/div/label[2]/span[2]"));
    }

    /**
     * 安卓证书下拉框
     * @return 元素
     */
    public WebElement androidSignInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[6]/div/div/div/input"));
    }

    /**
     * ios证书下拉框
     * @return 元素
     */
    public WebElement iOSSignInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[7]/div/div/div/input"));
    }

    /**
     * 获取android签名证书
     * @param signName 证书名称
     * @return 元素
     */
    public WebElement signAndroid(String signName){
        try {
            WebElement element = element(By.xpath("/html/body/div/div[1]/div[1]/ul/li/span[text()='"+signName+"']/parent::*"));
            logger.debug("定位Android证书成功："+signName);
            return element;
        }catch (Exception e){
            logger.error("定位Android证书失败："+signName);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取iOS签名证书
     * @param signName 证书名称
     * @return 元素
     */
    public WebElement signIOS(String signName){
        try {
            WebElement element = element(By.xpath("/html/body/div/div[1]/div[1]/ul/li/span[text()='"+signName+"']/parent::*"));
            logger.debug("选择iOS证书成功："+signName);
            return element;
        }catch (Exception e){
            logger.error("选择iOS证书失败："+signName);
            return null;
        }
    }

    /**
     * 上传iOS描述文件按钮
     * @return 元素
     */
    public WebElement uploadButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[8]/div/div/button"));
    }

    /**
     * iOS bundle ID输入框
     * @return 元素
     */
    public WebElement iOSBundleIDInput(){
        return element(By.xpath("//input[@placeholder='请输入Bundle ID，如：com.comtop.test']"));
    }

    /**
     * 服务域名输入框
     * @return 元素
     */
    public WebElement ServerDomainInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[11]/div/div[1]/div/div/div[1]/input"));
    }

    /**
     * 服务地址上下文输入框
     * @return 元素
     */
    public WebElement SererContextInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[11]/div/div[2]/div/div/div[1]/input"));
    }

    /**
     * 确定新建项目按钮
     * @return 元素
     */
    public WebElement ConfirmCreateAProject(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[3]/div/button[2]"));
    }
}
