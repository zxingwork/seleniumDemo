package org.demo2.pages;


import org.apache.log4j.Logger;
import org.demo2.base.BasePage;
import org.demo2.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CapHomePage extends BasePage {
    private static Logger logger = Logger.getLogger(CapHomePage.class.getName());
    public CapHomePage(DriverBase driver) {
        super(driver);
    }

    public WebElement findCapProject(){
        return element(By.xpath("/html/body/div[1]/ul[2]/li[1]/a"));
    }

    public WebElement findConfigClose(){
        return  element(By.xpath("/html/body/div[5]/a"));
    }

    public WebElement findProjectList(){
        return element(By.id("proSwitch"));
    }

    public WebElement findProject(String projectName){
        return element(By.cssSelector("[title="+projectName+"]>a"));
    }

    public WebElement findProjectModeling(){
        return element(By.xpath("/html/body/div[1]/ul[1]/li[2]/a"));
    }

    public WebElement MDPProject(){
        return element(By.xpath("//span[text()='移动管理']/parent::*"));
    }

}
