package org.demo2.handle;

import org.demo2.base.DriverBase;
import org.demo2.base.HandleBase;
import org.demo2.pages.MDPHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MDPHomePageHandle extends HandleBase {
    private final MDPHomePage mdpHomePage;
    private WebDriver driver;
    public MDPHomePageHandle(DriverBase driver) {
        mdpHomePage = new MDPHomePage(driver);
        this.driver = driver.getDriver();
    }
    public boolean onPage(){
        return "移动开发平台".equalsIgnoreCase(this.driver.getTitle());
    }
    public WebDriver getDriver(){
        return this.driver;
    }
    public void ClickMDPProjectList(){
        mdpHomePage.click(mdpHomePage.MDPProjectList());
    }
    public void ClickCreateProjectButton(){
        mdpHomePage.createProjectButton().click();
    }

    public void inputProjectName(String projectName){
        mdpHomePage.sendKey(mdpHomePage.createProjectName(), projectName);
    }
    public void inputProjectCode(String projectCode){
        mdpHomePage.sendKey(mdpHomePage.createProjectCode(), projectCode);
    }
}
