package org.demo2.cases;

import org.demo2.base.BasePage;
import org.demo2.base.DriverBase;
import org.demo2.handle.LoginCapPageHandle;
import org.demo2.pages.LoginCapPage;

public class LoginCap {
    DriverBase driverBase;
    LoginCapPageHandle loginCapPageHandle;
    public LoginCap(DriverBase driverBase){
        this.driverBase = driverBase;
        loginCapPageHandle = new LoginCapPageHandle(driverBase);
    }

    public void login(){
        loginCapPageHandle.inputUsername("CapSuperAdmin");
        loginCapPageHandle.inputPassword("hello");
        loginCapPageHandle.selectRememberMe(true);
        loginCapPageHandle.clickLogin();
    }
}
