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
}
