package org.demo2.pages;

import org.demo2.base.BasePage;
import org.demo2.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginCapPage extends BasePage {

    public LoginCapPage(DriverBase driver) {
        super(driver);
    }

    public WebElement findUsernameInput(){
        return element(By.id("userName"));
    }

    public WebElement findPasswordInput(){
        return element(By.id("passWord"));
    }

    public WebElement findRememberMeBox(){
        return element(By.id("rememberMe"));
    }

    public WebElement findLoginButton(){
        return element(By.id("loginBtn"));
    }
    public WebElement findConfirmButton(){
        return element(By.id("confirmBtn"));
    }
}
