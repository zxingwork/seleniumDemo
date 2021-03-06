package org.demo2;


import org.apache.log4j.Logger;
import org.demo2.base.DriverBase;
import org.demo2.handle.CapHomePageHandle;
import org.demo2.handle.LoginCapPageHandle;
import org.demo2.handle.MDPHomePageHandle;
import org.demo2.pages.CapHomePage;

import java.awt.*;
import java.util.UUID;


/**
 * 执行案例主程序
 */
public class RunCases {

    public static void main(String[] args) throws InterruptedException, AWTException {
        Logger logger = Logger.getLogger(RunCases.class.getName());
        DriverBase driverBase = new DriverBase("Chrome");
        driverBase.getDriver().manage().window().maximize();
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


        MDPHomePageHandle mdpHomePageHandle = new MDPHomePageHandle(driverBase);
        if (mdpHomePageHandle.onPage()){
            System.out.println("打开页面成功");
        }else {
            logger.error("打开页面失败，当前页面是："+mdpHomePageHandle.getDriver().getTitle());
        }
        String projectName = UUID.randomUUID().toString().replace("-","");
        mdpHomePageHandle.ClickMDPProjectList();
        mdpHomePageHandle.ClickCreateProjectButton();
        mdpHomePageHandle.inputProjectName("auto"+projectName);
        mdpHomePageHandle.inputProjectCode("auto"+projectName);
        mdpHomePageHandle.clickProjectTypeSelect();
        mdpHomePageHandle.selectAProjectType(2);
        mdpHomePageHandle.selectPlotForm("Android", "iOS");
        mdpHomePageHandle.selectMode(1);
        mdpHomePageHandle.clickAndroidSignInput();
        mdpHomePageHandle.selectAndroidSign("uu");
        mdpHomePageHandle.clickIOSSignInput();
        mdpHomePageHandle.selectIOSSign("zx");
        mdpHomePageHandle.clickUploadButton();
        mdpHomePageHandle.uploadIOSPackagingCertificate(System.getProperty("user.dir")+"\\static\\jjkz_20200617production.mobileprovision");
        mdpHomePageHandle.InputIOSBundleID("com.csgcomtop.CSGWhiteLIstNewEight");
        mdpHomePageHandle.inputServerAddr("127.0.0.1:8080","/api");
        mdpHomePageHandle.clickConfirmCreateAProject();
        if (mdpHomePageHandle.assertAfterCreateProject()){
            mdpHomePageHandle.screenShot("创建项目成功");
        }else {
            mdpHomePageHandle.screenShot("创建项目失败");
        }
        mdpHomePageHandle.ClickMDPProjectList();
        Thread.sleep(2000);
        mdpHomePageHandle.clickInstallProjectDependencies();
        mdpHomePageHandle.clickBackWorkSpaceButton();

        mdpHomePageHandle.clickAddNewPage();
        mdpHomePageHandle.inputPageName();
        mdpHomePageHandle.inputPageTitle();
        // 请输入数字或小写字母且每级目录只能以小写字母开头，如：dir1或dir1/dir2
        mdpHomePageHandle.inputPageSaveFolder("auto/d2");
        mdpHomePageHandle.clickSaveNewPageButton();
        mdpHomePageHandle.clickAddResourceFileButton();
        mdpHomePageHandle.clickUploadResourceFileButton();
        mdpHomePageHandle.uploadResourceFile(System.getProperty("user.dir")+"\\static\\mdpCompileComponentsBlocks.umd.min.js");
        mdpHomePageHandle.clickConfirmAddResourceFileButton();

        mdpHomePageHandle.clickAddCustomComponentButton();
        mdpHomePageHandle.clickUploadCustomComponentButton();
        mdpHomePageHandle.uploadFile(System.getProperty("user.dir")+"\\static\\mdpCompileComponentsBlocks.umd.min.js");
        mdpHomePageHandle.clickConfirmAddCustomComponentButton();

        mdpHomePageHandle.clickAddNewDependenciesButton();
        mdpHomePageHandle.inputNewDependenceName("jquery");
        mdpHomePageHandle.clickConfirmAddNewDependence();
    }
}

