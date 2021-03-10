package org.demo2.handle;

import org.demo2.base.DriverBase;
import org.demo2.base.HandleBase;
import org.demo2.pages.CapHomePage;
import org.openqa.selenium.WebDriver;

public class CapHomePageHandle extends HandleBase {
    private CapHomePage capHomePage;
    private WebDriver driver;

    public CapHomePageHandle(DriverBase driver) {
        capHomePage = new CapHomePage(driver);
        this.driver = driver.getDriver();
    }
    public void clickFindCapProject(){
        capHomePage.click(capHomePage.findCapProject());
    }
    public void CloseConfig(){
        capHomePage.findConfigClose().click();
    }
    public void proSwitch(String projectName){
        capHomePage.click(capHomePage.findProject(projectName));
    }

    public void ClickProjectModeling(){
        capHomePage.click(capHomePage.findProjectModeling());
    }

    public void ClickMDProject(){
        capHomePage.click(capHomePage.MDPProject());
    }

    public WebDriver getDriver() {
        return driver;
    }
    public void switchToNewHandle(){
        capHomePage.switchToNewWindow();
    }

}
