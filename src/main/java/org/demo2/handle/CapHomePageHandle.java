package org.demo2.handle;

import org.demo2.base.DriverBase;
import org.demo2.base.HandleBase;
import org.demo2.pages.CapHomePage;

public class CapHomePageHandle extends HandleBase {
    private CapHomePage capHomePage;

    public CapHomePageHandle(DriverBase driver) {
        capHomePage = new CapHomePage(driver);
    }
    public void clickFindCapProject(){
        capHomePage.findCapProject().click();
    }
    public void CloseConfig(){
        capHomePage.findConfigClose().click();
    }
    public void proSwitch(String projectName){
        capHomePage.findProject(projectName).click();
    }

    public void ClickProjectModeling(){
        capHomePage.findProjectModeling().click();
    }

    public void ClickMDProject(){
        System.out.println("ClickMDProject");
        capHomePage.MDPProject().click();
    }
}
