package org.demo2.handle;

import org.demo2.base.DriverBase;
import org.demo2.pages.LoginCapPage;

public class LoginCapPageHandle {
    private LoginCapPage loginCapPage;

    public LoginCapPageHandle(DriverBase driver){
        loginCapPage = new LoginCapPage(driver);
    }

    public void inputUsername(String username){
        loginCapPage.findUsernameInput().sendKeys(username);
    }
    public void inputPassword(String password){
        loginCapPage.findPasswordInput().sendKeys(password);
    }

    public void selectRememberMe(boolean select){
        if (select){
            loginCapPage.findRememberMeBox().click();
        }
    }
    public void clickLogin(){
        loginCapPage.findLoginButton().click();
    }
    public void clickConfirmButton(){
        loginCapPage.findConfirmButton().click();
    }
}
