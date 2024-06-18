package com.pomclasses;

import com.baseclass.BaseClass;
import com.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class AdminPagePom extends BaseClass {

    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a/span[text()='Admin']")
    private WebElement adminPageLink;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement username;

    @FindBy(xpath = "(//div[contains(text(),'-- Select --')])[1]")
    private WebElement userroleselect;

    @FindBy(xpath = "//div[contains(@class,'oxd-autocomplete-text-input')]//input")
    private WebElement employeename;

    @FindBy(xpath = "(//div[contains(text(),'-- Select --')])[2]")
    private WebElement statusselect;

    @FindBy(xpath = "//button[text()=' Reset ']")
    private WebElement reset;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement search;

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement adduserpage;

    @FindBy(xpath = "(//div[contains(text(),'-- Select --')])[1]")
    private WebElement adduserrole;

    @FindBy(xpath = "//div[contains(@class,'oxd-autocomplete-text-input')]//input")
    private WebElement addemployeename;

    @FindBy(xpath = "(//div[contains(text(),'-- Select --')])[2]")
    private WebElement addstatus;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement addusername;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement addpassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement addconfirmpassword;

    @FindBy(xpath = "//button[text()=' Cancel ']")
    private WebElement addcancelbutton;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement addsavebutton;

    @FindBy(css = "div[role='option'] span")
    private List<WebElement> roleSelect;

    public void gotoAdminPage(){
        Utility.webelementClick(adminPageLink);
    }

    public void addUser(){
        Utility.webelementClick(adduserpage);
    }

    public void setUserRole(String role){
        Utility.getActionClass().clickAndHold(adduserrole)
                        .pause(Duration.ofSeconds(1))
                                .build()
                                        .perform();

        for ( WebElement selectRole : roleSelect){
            if (selectRole.getText().equalsIgnoreCase(role)){
                Utility.webelementClick(selectRole);
            }
        }
    }

    public void setEmployeename(String empName){
        Utility.setText(addemployeename,empName);
    }

    public void setUserStatus(String userStatus){
        Utility.getActionClass().clickAndHold(addstatus)
                .pause(Duration.ofSeconds(1))
                .build()
                .perform();

        for ( WebElement selectStatus : roleSelect){
            if (selectStatus.getText().equalsIgnoreCase(userStatus)){
                Utility.webelementClick(selectStatus);
            }
        }
    }

    public void setUserDetails(String username, String pass, String confPass){
        Utility.setText(addusername,username);
        Utility.setText(addpassword,pass);
        Utility.setText(addconfirmpassword,confPass);
    }


}
