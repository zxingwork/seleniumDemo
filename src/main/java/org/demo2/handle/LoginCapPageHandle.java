package org.demo2.handle;

import org.demo2.base.DriverBase;
import org.demo2.pages.LoginCapPage;

public class LoginCapPageHandle {
    private LoginCapPage loginCapPage;

    public LoginCapPageHandle(DriverBase driver){
        loginCapPage = new LoginCapPage(driver);
    }

    public void inputUsername(String username){
        loginCapPage.sendKey(loginCapPage.findUsernameInput(), username);
    }
    public void inputPassword(String password){
        loginCapPage.sendKey(loginCapPage.findPasswordInput(), password);
    }

    public void selectRememberMe(boolean select){
        if (select){
            loginCapPage.click(loginCapPage.findRememberMeBox());
        }
    }
    public void clickLogin(){
        loginCapPage.click(loginCapPage.findLoginButton());
    }
    public void clickConfirmButton(){
        loginCapPage.click(loginCapPage.findConfirmButton());
    }
}
