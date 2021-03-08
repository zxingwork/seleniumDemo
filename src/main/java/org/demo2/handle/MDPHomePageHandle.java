package org.demo2.handle;

import org.demo2.base.DriverBase;
import org.demo2.base.HandleBase;
import org.demo2.pages.MDPHomePage;

public class MDPHomePageHandle extends HandleBase {
    private MDPHomePage mdpHomePage;
    public MDPHomePageHandle(DriverBase driver) {
        mdpHomePage = new MDPHomePage(driver);
    }
    public void ClickMDPProjectList(){
        mdpHomePage.MDPProjectList().click();
    }
}
