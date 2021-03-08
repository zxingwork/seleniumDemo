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
}
