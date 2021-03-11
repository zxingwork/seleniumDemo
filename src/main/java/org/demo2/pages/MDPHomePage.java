package org.demo2.pages;

import org.demo2.base.BasePage;
import org.demo2.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MDPHomePage extends BasePage {
    public MDPHomePage(DriverBase driver) {
        super(driver);
    }

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
        return element(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[1]"));
    }

    /**
     * 获取混合应用选项
     * @return WebElement
     */
    public WebElement projectTypeSelectMix(){
        return element(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[2]"));
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

}
