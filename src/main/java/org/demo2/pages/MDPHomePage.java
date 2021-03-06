package org.demo2.pages;

import org.apache.log4j.Logger;
import org.demo2.base.BasePage;
import org.demo2.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MDPHomePage extends BasePage {
    public MDPHomePage(DriverBase driver) {
        super(driver);
    }
    private Logger logger = Logger.getLogger(MDPHomePage.class.getName());
    public WebElement MDPProjectList(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[1]"));
    }

    public WebElement createProjectButton(){
//        return element(By.cssSelector("//span[text()='创建项目']/parent/parent::*"));
        return element(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/button/span"));
    }

    public WebElement createProjectName(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[1]/div/div/input"));
    }

    public WebElement createProjectCode(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[2]/div/div/input"));
    }

    public WebElement protectTypeSelect(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[3]/div/div/div/input"));
    }

    /**
     * 获取HTML5应用选项
     * @return WebElement
     */
    public WebElement protectTypeSelectHtml5(){
        return element(By.xpath("//span[text()='HTML5应用']/parent::*"));
    }

    /**
     * 获取混合应用选项
     * @return WebElement
     */
    public WebElement projectTypeSelectMix(){
        return element(By.xpath("//span[text()='混合应用']/parent::*"));
    }

    /**
     * 创建项目时获Android平台的元素
     * @return 元素
     */
    public WebElement platformAndroid(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[4]/div/div/label[1]/span[2]"));
    }

    /**
     * 创建项目时获取iOS平台的元素
     * @return 元素
     */
    public WebElement platformIOS(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[4]/div/div/label[2]/span[2]"));
    }

    /**
     * 离线模式
     * @return 元素
     */
    public WebElement modeOffLine(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[5]/div/label[1]/span[2]"));
    }

    /**
     * 在线模式
     * @return 元素
     */
    public WebElement modeOnline(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[5]/div/label[2]/span[2]"));
    }

    /**
     * 安卓证书下拉框
     * @return 元素
     */
    public WebElement androidSignInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[6]/div/div/div/input"));
    }

    /**
     * ios证书下拉框
     * @return 元素
     */
    public WebElement iOSSignInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[7]/div/div/div/input"));
    }

    /**
     * 获取android签名证书
     * @param signName 证书名称
     * @return 元素
     */
    public WebElement signAndroid(String signName){
        try {
            WebElement element = element(By.xpath("/html/body/div/div[1]/div[1]/ul/li/span[text()='"+signName+"']/parent::*"));
            logger.debug("定位Android证书成功："+signName);
            return element;
        }catch (Exception e){
            logger.error("定位Android证书失败："+signName);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取iOS签名证书
     * @param signName 证书名称
     * @return 元素
     */
    public WebElement signIOS(String signName){
        try {
            WebElement element = element(By.xpath("/html/body/div/div[1]/div[1]/ul/li/span[text()='"+signName+"']/parent::*"));
            logger.debug("选择iOS证书成功："+signName);
            return element;
        }catch (Exception e){
            logger.error("选择iOS证书失败："+signName);
            return null;
        }
    }

    /**
     * 上传iOS描述文件按钮
     * @return 元素
     */
    public WebElement uploadButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[8]/div/div/button"));
    }

    /**
     * iOS bundle ID输入框
     * @return 元素
     */
    public WebElement iOSBundleIDInput(){
        return element(By.xpath("//input[@placeholder='请输入Bundle ID，如：com.comtop.test']"));
    }

    /**
     * 服务域名输入框
     * @return 元素
     */
    public WebElement ServerDomainInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[11]/div/div[1]/div/div/div[1]/input"));
    }

    /**
     * 服务地址上下文输入框
     * @return 元素
     */
    public WebElement SererContextInput(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[2]/form/div[11]/div/div[2]/div/div/div[1]/input"));
    }

    /**
     * 确定新建项目按钮
     * @return 元素
     */
    public WebElement ConfirmCreateAProject(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div[3]/div/button[2]"));
    }

    /**
     * 创建成功后提示框
     * @return 元素
     */
    public WebElement alertAfterCreateAProject(){
        return element(By.xpath("//div[@class='el-message el-message--success']"));
    }

    /**
     * 安装公共依赖按钮
     * @return 元素
     */
    public WebElement installProjectDependencies(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/ul/li[1]/div/span[1]"));
    }

    /**
     * 返回工作区按钮
     * @return 元素
     */
    public WebElement backWorkSpaceButton(){
        return element(By.xpath("//div[@class='back-workspace']"));
    }

    /**
     * 添加页面按钮
     * @return 元素
     */
    public WebElement addPageButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[1]/div/span[2]"));
    }

    /**
     * 添加资源文件按钮
     * @return 元素
     */
    public WebElement addResourceFileButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/div/span[2]"));
    }

    /**
     * 添加自定义组件的按钮
     * @return 元素
     */
    public WebElement addCustomComponentsButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div[1]/div/span[2]"));
    }

    /**
     * 新增依赖
     * @return 元素
     */
    public WebElement addNewDependenciesButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[2]/div[4]/div[1]/div/span[2]"));
    }

    /**
     * 添加Cordova插件
     * @return 元素
     */
    public WebElement addCordovaPlugin(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[2]/div[5]/div[1]/div/span[2]"));
    }
    /* 新增页面 的元素*/
    /**
     * 新增页面的名称
     * @return 元素
     */
    public WebElement pageNameInput(){
        return element(By.xpath("//input[@placeholder='请输入页面文件名，如：login']"));
    }

    /**
     * 新增页面的标题
     * @return 元素
     */
    public WebElement pageTitleInput(){
        return element(By.xpath("//input[@placeholder='请输入页面标题，如：登陆']"));
    }

    /**
     * 新增页面的存放目录
     * @return 元素
     */
    public WebElement saveFolderInput(){
        return element(By.xpath("//input[@placeholder='请输入页面存放目录，如：dir1或dir1/dir2']"));
    }

    /**
     * 新增页面的确认按钮
     * @return 元素
     */
    public WebElement saveNewPageButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[5]/div/div[3]/div/button[2]"));
    }

    /**
     * 点击上传按钮
     * @return 元素
     */
    public WebElement uploadResourceFileButton(){
        return element(By.xpath("/html/body/div/div/div/form/div/div/div/div/button"));
    }

    /**
     * 确认添加资源文件按钮
     * @return 元素
     */
    public WebElement confirmAddResourceFileButton(){
        return element(By.xpath("/html/body/div[7]/div/div[3]/div/button[2]"));
    }

    /**
     * 上传自定义组件按钮
     * @return 元素
     */
    public WebElement uploadCustomComponentButton(){
        return element(By.xpath("/html/body/div/div/div/form/div/div/div/div/button"));
    }

    /**
     * 上传自定义组件确定按钮
     * @return 元素
     */
    public WebElement confirmAddCustomComponentButton(){
        return element(By.xpath("/html/body/div/div/div/div/button/span[text()='确定']"));
    }

    /**
     * 添加依赖的名称
     * @return 元素
     */
    public WebElement newDependenceNameInput(){
        return element(By.xpath("//input[@placeholder='请输入依赖名称，如：jquery']"));
    }

    /**
     * 添加依赖的版本号
     * @return 元素
     */
    public WebElement newDependenceVersionInput(){
        return element(By.xpath("//input[@placeholder='请输入依赖版本，如：3.1.1']"));
    }

    /**确定添加依赖按钮
     * @return 元素
     */
    public WebElement confirmAddNewDependenceButton(){
        return element(By.xpath("/html/body/div[1]/div[2]/div[6]/div/div[3]/div/button[2]"));
    }
}
