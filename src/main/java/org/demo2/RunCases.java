package org.demo2;


import org.apache.log4j.Logger;
import org.demo2.base.DriverBase;
import org.demo2.handle.CapHomePageHandle;
import org.demo2.handle.LoginCapPageHandle;
import org.demo2.handle.MDPHomePageHandle;
import org.demo2.pages.CapHomePage;

public class RunCases {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getLogger(RunCases.class.getName());
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
        capHomePageHandle.switchToNewHandle();

        Thread.sleep(5000);
        MDPHomePageHandle mdpHomePageHandle = new MDPHomePageHandle(driverBase);
        if (mdpHomePageHandle.onPage()){
            System.out.println("打开页面成功");
        }else {
            logger.error("打开页面失败，当前页面是："+mdpHomePageHandle.getDriver().getTitle());
        }
        mdpHomePageHandle.ClickMDPProjectList();
        mdpHomePageHandle.ClickCreateProjectButton();
        mdpHomePageHandle.inputProjectName("zxingzcs");
        mdpHomePageHandle.inputProjectCode("zxingzcs");
    }
}
