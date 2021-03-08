package org.demo2;

import org.demo2.base.DriverBase;
import org.demo2.handle.CapHomePageHandle;
import org.demo2.handle.LoginCapPageHandle;
import org.demo2.pages.CapHomePage;

public class RunCases {

    public static void main(String[] args) {
        DriverBase driverBase = new DriverBase("Chrome");
        driverBase.getUrl("http://10.10.10.109/web/cap/ptc/login/CapLogin.jsp");
        LoginCapPageHandle loginCapPageHandle = new LoginCapPageHandle(driverBase);
        loginCapPageHandle.inputUsername("CapSuperAdmin");
        loginCapPageHandle.inputPassword("hello");
        loginCapPageHandle.selectRememberMe(true);
        loginCapPageHandle.clickLogin();
        try{
            loginCapPageHandle.clickConfirmButton();
        }catch (Exception e){
            e.printStackTrace();
        }
        CapHomePageHandle capHomePageHandle = new CapHomePageHandle(driverBase);
        try{
            capHomePageHandle.CloseConfig();
        }catch (Exception e){
            e.printStackTrace();
        }
        capHomePageHandle.clickFindCapProject();
        capHomePageHandle.proSwitch("移动开发项目勿删");
        capHomePageHandle.ClickProjectModeling();
        capHomePageHandle.ClickMDProject();
    }
}
