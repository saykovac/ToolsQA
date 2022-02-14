package DemoQAPages;

import DemoQABase.BasePage;
import com.google.gson.annotations.Until;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    // Text Box Submenu
    public @FindBy (id = "item-0")
    WebElement textBoxMenu;

    public @FindBy (id = "userName")
    WebElement usernameField;

    public @FindBy (id = "userEmail")
    WebElement userEmail;

    public @FindBy (id = "currentAddress")
    WebElement currentAddrss;

    public @FindBy (id = "permanentAddress")
    WebElement permanentAddrss;

    public @FindBy (id = "submit")
    WebElement submitBttnTextBox;

    // polja koja se pojavljuju posle klika na submit bttn

    public @FindBy (id = "name")
    WebElement fullNameFieldMsg;

    public  @FindBy (id = "email")
    WebElement emailFieldMsg;

//    public  @FindBy (id = "currentAddress")
//    WebElement currentAddressFieldMsg;
//
//    public @FindBy (id = "permanentAddress")
//    WebElement permanentAddressFieldMsg;

//    public @FindBy (id = "output")
//    List<WebElement> textBoxMsg;


    // Check Box Submenu
    public @FindBy(id = "item-1")
    WebElement checkBoxMenu;


    // Radio Button Submenu
    public @FindBy (id = "item-2")
    WebElement radioButtonMenu;

    public @FindBy(id = "yesRadio")
    WebElement yesRadioSlct;

    public @FindBy(id = "impressiveRadio")
    WebElement impressiveRadioSlct;

    public @FindBy(id = "noRadio")
    WebElement noRadioSlct;

    public @FindBy (className = "mt-3")
    WebElement radioBttnMsg;


    //Web Tables Submenu
    public @FindBy (id = "item-3")
    WebElement webTablesMenu;


    //Buttons Submenu
    public @FindBy (id = "item-4")
    WebElement buttonsMenu;

    public @FindBy (id = "doubleClickBtn")
    WebElement dblBttnClick;

    public @FindBy (id = "rightClickBtn")
    WebElement rghtBttnClick;

    // dinamicki id pa ga menjamo u xpath
    public @FindBy (xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button")
    WebElement snglBttnClick;

    public @FindBy (id = "doubleClickMessage")
    WebElement dblClickMsg;

    public @FindBy (id = "rightClickMessage")
    WebElement rghClickMsg;

    public @FindBy (id = "dynamicClickMessage")
    WebElement snglClickMsg;


    // Upload and Download
    public @FindBy (id = "item-7")
    WebElement uploadDownloadMenu;

    public @FindBy (id = "uploadFile")
    WebElement uploadFileBttn;

    public @FindBy (id = "downloadButton")
    WebElement donwloadBttn;

    public @FindBy(id = "uploadedFilePath")
    WebElement upldFilePath;


    // Dinamyc Properties
    public @FindBy (id = "item-8")
    WebElement dinamycPropertiesMenu;

    public @FindBy (id = "enableAfter")
    WebElement enableAfterBttn;

    public @FindBy (id = "colorChange")
    WebElement colorChangeBttn;

    public @FindBy (className = ".mt-4.btn.btn-primary")
    WebElement firstColorChangeBttnClass;

    public @FindBy(className = ".mt-4.text-danger.btn.btn-primary")
    WebElement secondColorChangeBttnClass;

    public @FindBy (id = "visibleAfter")
    WebElement visibleAfterBttn;

    //------------------------------------------------

//    public void clickTextBoxMenu(){
//        this.textBoxMenu.click();
//    }

    public void usernameField(String user){
        this.usernameField.click();
        this.usernameField.clear();
        this.usernameField.sendKeys(user);

    }

    public void userEmailField(String email){
        this.userEmail.click();
        this.userEmail.clear();
        this.userEmail.sendKeys(email);
    }

    public void userCurrentAddress(String crntAddress){
        this.currentAddrss.click();
        this.currentAddrss.clear();
        this.currentAddrss.sendKeys(crntAddress);

    }

    public void userPermanentAddress(String prmntAddress){
        this.permanentAddrss.click();
        this.permanentAddrss.clear();
        this.permanentAddrss.sendKeys(prmntAddress);
    }


//    public void fullNameFieldMsgText(){
//        this.fullNameFieldMsg.getText();
//    }
//
//    public void emailFieldMsgText(){
//        this.emailFieldMsg.getText();
//    }
//
//    public void currentAddressFieldMsgText(){
//        this.currentAddressFieldMsg.getText();
//    }
//
//    public void permanentAddressFieldMsg(){
//        this.permanentAddressFieldMsg.getText();
//    }

//    public void selectTextBoxMsgField(int n){
//        textBoxMsg.get(n).getText();
//    }

    public void doubleblBttnClick(){
        this.dblBttnClick.click();
    }

    public void rightBttnClick(){
        this.rghtBttnClick.click();
    }
}
