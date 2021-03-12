package org.demo2.handle;

import org.apache.log4j.Logger;
import org.demo2.base.DriverBase;
import org.demo2.base.HandleBase;
import org.demo2.enums.PlatForm;
import org.demo2.pages.MDPHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.UUID;

public class MDPHomePageHandle extends HandleBase {
    private Logger logger = Logger.getLogger(MDPHomePageHandle.class.getName());
    private final MDPHomePage mdpHomePage;
    private WebDriver driver;
    public MDPHomePageHandle(DriverBase driver) {
        super(driver);
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
        try {
            mdpHomePage.click(mdpHomePage.MDPProjectList());
        }
        catch (Exception e){
            mdpHomePage.click(mdpHomePage.element(By.xpath("//div[@class='el-dialog__wrapper' and @data-v-be1f71c6]")));
        }
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
//        StringSelection selection = new StringSelection(path);
//        // 把图片路径复制到剪切板
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//        Robot robot = new Robot();
//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
        this.uploadFile(path);
    }

    /**
     * 输入iOSBundleId
     * @param ID ID
     */
    public void InputIOSBundleID(String ID){
        mdpHomePage.sendKey(mdpHomePage.iOSBundleIDInput(), ID);
    }

    /**
     * 输入服务地址
     * @param domain 域名
     * @param context 上下文
     */
    public void inputServerAddr(String domain, String context){
        mdpHomePage.sendKey(mdpHomePage.ServerDomainInput(),domain);
        mdpHomePage.sendKey(mdpHomePage.SererContextInput(), context);
    }

    /**
     * 点击确定新建项目
     */
    public void clickConfirmCreateAProject(){
        mdpHomePage.click(mdpHomePage.ConfirmCreateAProject());
    }

    /**
     * 创建项目是否成功
     * @return 是否成功
     */
    public boolean assertAfterCreateProject(){
        try {
            mdpHomePage.alertAfterCreateAProject();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 点击安装工程依赖
     */
    public void clickInstallProjectDependencies(){
        mdpHomePage.click(mdpHomePage.installProjectDependencies());
    }

    /**
     * 点击返回工作区
     */
    public void clickBackWorkSpaceButton(){
        mdpHomePage.click(mdpHomePage.backWorkSpaceButton());
    }

    /**
     * 点击添加新也页面
     */
    public void clickAddNewPage(){
        mdpHomePage.click(mdpHomePage.addPageButton());
    }

    /**
     * 点击添加资源文件按钮
     */
    public void clickAddResourceFileButton(){
        mdpHomePage.click(mdpHomePage.addResourceFileButton());
    }

    /**
     * 点击新增自定义组件按钮
     */
    public void clickAddCustomComponentButton(){
        mdpHomePage.click(mdpHomePage.addCustomComponentsButton());
    }

    /**
     * 点击新增依赖
     */
    public void clickAddNewDependenciesButton(){
        mdpHomePage.click(mdpHomePage.addNewDependenciesButton());
    }

    /**
     * 新增Cordova插件
     */
    public void clickAddCordovaPlugin(){
        mdpHomePage.click(mdpHomePage.addCordovaPlugin());
    }

    /**
     * 输入新页面的名称
     * @param pageName 页面名称
     */
    public void inputPageName(String pageName){
        mdpHomePage.sendKey(mdpHomePage.pageNameInput(),"auto"+pageName);
    }

    /**
     * 输入新页面名称
     */
    public void inputPageName(){
        String pageName = "auto"+UUID.randomUUID().toString().replace("-", "");
        mdpHomePage.sendKey(mdpHomePage.pageNameInput(), pageName);
    }

    /**
     * 输入页面标题
     * @param pageTitle 页面标题
     */
    public void inputPageTitle(String pageTitle){
        mdpHomePage.sendKey(mdpHomePage.pageTitleInput(), pageTitle);
    }

    /**
     * 输入页面标题
     */
    public void inputPageTitle(){
        String pageTitle = UUID.randomUUID().toString().replace("-", "");
        mdpHomePage.sendKey(mdpHomePage.pageTitleInput(), pageTitle);
    }


    /**
     * 输入保存文件夹名称
     * @param folderName 保存文件夹名
     */
    public void inputPageSaveFolder(String folderName){
        mdpHomePage.sendKey(mdpHomePage.saveFolderInput(), folderName);
    }

    /**
     * 点击保存页面按钮
     */
    public void clickSaveNewPageButton(){
        mdpHomePage.click(mdpHomePage.saveNewPageButton());
    }

    /**
     * 店家上传资源文件按钮
     */
    public void clickUploadResourceFileButton(){
        mdpHomePage.click(mdpHomePage.uploadResourceFileButton());
    }

    /**
     * @param absolutePath 资源文件绝对路径
     * @throws InterruptedException error
     * @throws AWTException error
     */
    public void uploadResourceFile(String absolutePath) throws InterruptedException, AWTException {
        this.uploadFile(absolutePath);
    }

    /**
     * 点击确定添加资源文件按钮
     */
    public void clickConfirmAddResourceFileButton(){
        mdpHomePage.click(mdpHomePage.confirmAddResourceFileButton());
    }

    /**
     * 点击上传自定义组件按钮
     */
    public void clickUploadCustomComponentButton(){
        mdpHomePage.click(mdpHomePage.uploadCustomComponentButton());
    }

    /**
     * 上传自定义组件文件
     * @param absolutPath 文件绝对路径
     * @throws InterruptedException error
     * @throws AWTException error
     */
    public void uploadCustomComponent(String absolutPath) throws InterruptedException, AWTException {
        this.uploadFile(absolutPath);
    }

    /**
     * 点击确认上传自定义组件按钮
     */
    public void clickConfirmAddCustomComponentButton(){
        mdpHomePage.click(mdpHomePage.confirmAddCustomComponentButton());
    }
}
