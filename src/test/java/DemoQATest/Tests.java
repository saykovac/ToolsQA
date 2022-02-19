package DemoQATest;

import DemoQABase.BasePage;
import DemoQABase.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BasePage {

    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to(HomeURL);
    }

    @Test(priority = 10)
    public void testMainPage(){
        //waitVisibility(mainPage.bannerImg);
        Assert.assertEquals(HomeURL, driver.getCurrentUrl());
        Assert.assertTrue(mainPage.bannerImg.isDisplayed());


    }

    public void goToElementsPage(){
        // Elements je prvi u meniju tj listi kojа је napravilјена sto je zapravo index 0
        mainPage.selectCardMenu(0);
    }

    @Test(priority = 20)
    public void userEnterDataInTextboxMenu() throws InterruptedException {
        goToElementsPage();
        //wdwait.until(ExpectedConditions.urlToBe("https://demoqa.com/elements"));
        Thread.sleep(1500);
        elementsPage.textBoxMenu.click();
        //wdwait.until(ExpectedConditions.urlToBe("https://demoqa.com/text-box"));
        Thread.sleep(1500);
        // iscitavanje iz excela
        String expectedURL = excelReader.getStringData("URL", 3, 1);
        String userNameSurname = excelReader.getStringData("Elements.TextBox", 1, 0);
        String userEmail = excelReader.getStringData("Elements.TextBox", 1, 1);
        String userCrntAddrss = excelReader.getStringData("Elements.TextBox", 1, 2);
        String userPermntAddrss = excelReader.getStringData("Elements.TextBox", 1, 3);
        // string koji se nadovezuje na iscitani iz excela da bismo ga uporedili sa porukom koja se pojavljuje u polju nakon submita
        String fullNameMsg = "Name:" + userNameSurname;
        String emailMsg = "Email:" + userEmail;
        // ova nova polja imaju isti id kao polja iznad
        //String currentAddressMsg = "Current Address :" + userCrntAddrss;
        //String permanentAddressMsg = "Permananet Address :" + userPermntAddrss; // Na sajtu greskom pise Permananet umesto permanent
        // prosledjivanje stringa iz excela poljima
        elementsPage.usernameField(userNameSurname);
        elementsPage.userEmailField(userEmail);
        elementsPage.userCurrentAddress(userCrntAddrss);
        elementsPage.userPermanentAddress(userPermntAddrss);
        //Thread.sleep(2000);
        elementsPage.submitBttnTextBox.click();
        Thread.sleep(1500);
//        waitVisibility(elementsPage.fullNameFieldMsg);
//        waitVisibility(elementsPage.emailFieldMsg);

        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(elementsPage.submitBttnTextBox.isDisplayed());
        // asertovi za vidljivost sad nisu bitni jer svakako moraju postojati cim im trazimo text u polju
        //Assert.assertTrue(elementsPage.currentAddrss.isDisplayed());
        //Assert.assertTrue(elementsPage.permanentAddrss.isDisplayed());
        Assert.assertEquals(fullNameMsg, elementsPage.fullNameFieldMsg.getText());
        Assert.assertEquals(emailMsg, elementsPage.emailFieldMsg.getText());




    }

    @Test (priority = 30)
    public void selectYesRadioBttn() throws InterruptedException {
        goToElementsPage();
        String expectedURL = excelReader.getStringData("URL", 7, 1);
        String radioYesMsg = "You have selected Yes";
        Thread.sleep(1500);
        elementsPage.radioButtonMenu.click();
        Thread.sleep(1500);
        click(elementsPage.yesRadioSlct);
        Thread.sleep(1500);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(elementsPage.radioBttnMsg.isDisplayed());
        Assert.assertTrue(elementsPage.yesRadioSlct.isSelected());
        Assert.assertEquals(radioYesMsg, elementsPage.radioBttnMsg.getText());

    }

    @Test (priority = 40)
    public void selectImpressiveRadioBttn() throws InterruptedException {
        goToElementsPage();
        String expectedURL = excelReader.getStringData("URL", 7, 1);
        String radioNoMsg = "You have selected Impressive";
        Thread.sleep(1500);
        elementsPage.radioButtonMenu.click();
        Thread.sleep(1500);
        click(elementsPage.impressiveRadioSlct);
        Thread.sleep(1500);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(elementsPage.radioBttnMsg.isDisplayed());
        Assert.assertTrue(elementsPage.impressiveRadioSlct.isSelected());
        Assert.assertEquals(radioNoMsg, elementsPage.radioBttnMsg.getText());

    }

    @Test (priority = 50)
    public void cantSelectNoRadioBttn() throws InterruptedException {
        goToElementsPage();
        String expectedURL = excelReader.getStringData("URL", 7, 1);
        Thread.sleep(1500);
        elementsPage.radioButtonMenu.click();
        Thread.sleep(1500);
        click(elementsPage.noRadioSlct);
        Thread.sleep(1500);
        Assert.assertEquals(expectedURL,driver.getCurrentUrl());
        // False jer je forica pa se NO ne moze selektovati
        Assert.assertFalse(elementsPage.noRadioSlct.isSelected());
    }

    @Test (priority = 60)
    public void doubleButtonClick() throws InterruptedException {
        goToElementsPage();
        String expectedURL = excelReader.getStringData("URL", 11, 1);
        String dblMsgTxt = "You have done a double click";

        Thread.sleep(1500);
        elementsPage.buttonsMenu.click();
        Thread.sleep(1500);
        // Ubaceno Actions (action ga krstih) iz koje vucemo predefinisane metode, hvala Seleniumu
        action.doubleClick(elementsPage.dblBttnClick).perform();
        //actions.contextClick(getRightClick()).perform();
        Thread.sleep(1500);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(elementsPage.dblClickMsg.isDisplayed());
        Assert.assertEquals(dblMsgTxt,elementsPage.dblClickMsg.getText());


    }

    @Test (priority = 70)
    public void rightButtonClick() throws InterruptedException {
        goToElementsPage();
        String expectedURL = excelReader.getStringData("URL", 11, 1);
        String rghtMsgTxt = "You have done a right click";
        Thread.sleep(1500);
        elementsPage.buttonsMenu.click();
        Thread.sleep(1500);
        action.contextClick(elementsPage.rghtBttnClick).perform();
        Thread.sleep(1500);
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(elementsPage.rghClickMsg.isDisplayed());
        Assert.assertEquals(rghtMsgTxt,elementsPage.rghClickMsg.getText());

    }

    @Test (priority = 80)
    public void singleButtonClick() throws InterruptedException {
        goToElementsPage();
        String expectedURL = excelReader.getStringData("URL", 11, 1);
        String snglMsgTxt = "You have done a dynamic click";
        Thread.sleep(1500);
        elementsPage.buttonsMenu.click();
        Thread.sleep(1500);
        elementsPage.snglBttnClick.click();
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
        Assert.assertTrue(elementsPage.snglClickMsg.isDisplayed());
        Assert.assertEquals(snglMsgTxt,elementsPage.snglClickMsg.getText());

    }

    // test zakomentarisan zbog upload path bug
//    @Test(priority = 90)
//    public void uploadAdnDownloadPicture() throws InterruptedException {
//        goToElementsPage();
//        String expectedURL = excelReader.getStringData("URL", 17, 1);
//        String pathFileMsg = "C:\\fakepath\\itbootcamp.png";
//        Thread.sleep(1500);
//        scroll(elementsPage.uploadDownloadMenu);
//        elementsPage.uploadDownloadMenu.click();
//        Thread.sleep(1500);
//        scroll(elementsPage.uploadFileBttn);
//        // iz nekog razloga Selenium ovde ne radi lepo upload pic sem sa apsolutnom putanjom i test onda pada ukoliko se slika ne nalazi na C: , tako da bi trebalo fotografiju kopirati na C: da bi test prosao
//        // ne moze se odraditi upload pic ni iz root projekta "itbootcamp.png"
//        elementsPage.uploadFileBttn.sendKeys("C:\\itbootcamp.png");/*https://itbootcamp.rs/wp-content/uploads/2019/08/logo_itbootcamp_400x400.png*/
//        Thread.sleep(1500);
//        elementsPage.donwloadBttn.click();
//
//        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
//        Assert.assertTrue(elementsPage.upldFilePath.isDisplayed());
//        Assert.assertEquals(pathFileMsg, elementsPage.upldFilePath.getText());
//    }


    @Test(priority = 100)
    public void dynamicProperties(){
        goToElementsPage();
        String expectedURL = excelReader.getStringData("URL", 19, 1);

    }





//    @AfterMethod



}
