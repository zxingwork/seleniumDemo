package org.demo2.handle;

import org.apache.log4j.Logger;
import org.demo2.base.DriverBase;
import org.demo2.base.HandleBase;
import org.demo2.enums.PlatForm;
import org.demo2.pages.MDPHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class MDPHomePageHandle extends HandleBase {
    private Logger logger = Logger.getLogger(MDPHomePageHandle.class.getName());
    private final MDPHomePage mdpHomePage;
    private WebDriver driver;
    public MDPHomePageHandle(DriverBase driver) {
        mdpHomePage = new MDPHomePage(driver);
        this.driver = driver.getDriver();
    }
    public boolean onPage(){
        return "移动开发平台".equalsIgnoreCase(this.driver.getTitle());
    }
    public WebDriver getDriver(){
        return this.driver;
    }
    public void ClickMDPProjectList(){
        mdpHomePage.click(mdpHomePage.MDPProjectList());
    }
    public void ClickCreateProjectButton(){
        mdpHomePage.createProjectButton().click();
    }

    public void inputProjectName(String projectName){
        mdpHomePage.sendKey(mdpHomePage.createProjectName(), projectName);
    }
    public void inputProjectCode(String projectCode){
        mdpHomePage.sendKey(mdpHomePage.createProjectCode(), projectCode);
    }
    public void clickProjectTypeSelect(){
        mdpHomePage.click(mdpHomePage.protectTypeSelect());
    }

    /**
     * 选择项目类型
     * @param index 1：HTML5应用；2：混合应用
     */
    public void selectAProjectType(int index){
        if (index==1){
            // 选择HTML5应用
            mdpHomePage.click(mdpHomePage.protectTypeSelectHtml5());
        }
        else if (index==2){
            // 选择混合应用
            mdpHomePage.click(mdpHomePage.projectTypeSelectMix());
        }
        else {
            logger.error("请输入正确的项目编号");
        }
    }

    /**
     * 选择平台:单选
     * @param platForm 平台名：[Android,iOS]
     */
    public void selectPlotForm(String platForm){
        if ("Android".equalsIgnoreCase(platForm)){
            mdpHomePage.click(mdpHomePage.platformAndroid());
        }else if ("iOS".equalsIgnoreCase(platForm)){
            mdpHomePage.click(mdpHomePage.platformIOS());
        }
    }

    /**
     * 选择平台：多选
     * @param platForm1：
     * @param platForm2：
     */
    public void selectPlotForm(String platForm1, String platForm2){
        if (platForm1.equalsIgnoreCase("Android") && platForm2.equalsIgnoreCase("iOS")){
            mdpHomePage.click(mdpHomePage.platformIOS());
            mdpHomePage.click(mdpHomePage.platformAndroid());
        }
    }

    /**
     * 选择模式
     * @param index 1：离线模式 2：在线模式
     */
    public void selectMode(int index){
        if (index == 1){
            mdpHomePage.click(mdpHomePage.modeOffLine());
        }
        else if (index == 2){
            mdpHomePage.click(mdpHomePage.modeOnline());
        }
        else {
            logger.error("选择模式失败");
        }
    }

    /**
     * 点击安卓证书输入框
     */
    public void clickAndroidSignInput(){
        mdpHomePage.click(mdpHomePage.androidSignInput());
    }

    public void clickIOSSignInput(){
        mdpHomePage.click(mdpHomePage.iOSSignInput());
    }

    /**
     * 选择安卓证书
     * @param signName 证书名
     */
    public void selectAndroidSign(String signName){
        mdpHomePage.click(mdpHomePage.signAndroid(signName));
    }

    /**
     * 选择iOS证书
     * @param signName 证书名
     */
    public void selectIOSSign(String signName){
        mdpHomePage.click(mdpHomePage.signIOS(signName));
    }

    public void clickUploadButton(){
        mdpHomePage.click(mdpHomePage.uploadButton());
    }

    /**
     * 上传iOS描述文件
     * @param path 描述文件路径
     * @throws AWTException error
     * @throws InterruptedException error
     */
    public void uploadIOSPackagingCertificate(String path) throws AWTException, InterruptedException {
        StringSelection selection = new StringSelection(path);
        // 把图片路径复制到剪切板
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * 输入iOSBundleId
     * @param ID ID
     */
    public void InputIOSBundleID(String ID){
        mdpHomePage.sendKey(mdpHomePage.iOSBundleIDInput(), ID);
    }

    public void inputServerAddr(String domain, String context){
        mdpHomePage.sendKey(mdpHomePage.ServerDomainInput(),domain);
        mdpHomePage.sendKey(mdpHomePage.SererContextInput(), context);
    }
}
