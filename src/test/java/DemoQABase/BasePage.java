package DemoQABase;

import DemoQAPages.ElementsPage;
import DemoQAPages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
* public void click (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
kopiraj u base page I samo pozovi u test metodi

* */

import javax.swing.*;
import java.io.IOException;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wdwait;
    public static Actions action;
    public static Select select;

    // dodavanje stranica koje smo napravili i koje su extendovane iz BasePage
    public MainPage mainPage;
    public ElementsPage elementsPage;


    public ExcelReader excelReader;
    public String HomeURL;



    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // ubaciti stranice koj su extendovane iz BasePage a koje smo inicijalizovali gore
        mainPage = new MainPage(driver);
        elementsPage = new ElementsPage(driver);




        excelReader = new ExcelReader("TestBook.xlsx");
        HomeURL = excelReader.getStringData("URL", 1, 0);
        action = new Actions(driver);


    }


    // metoda koja nam sluzi da element kojoj joj prosledimo saceka da se pojavi na stranici

    public void waitVisibility(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    // metoda koja nam sluzi da saceka da element koji joj prosledjujemo bude klikabilan
    public void waitClick(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // da bi skrolovali do elementa koji se ne vidi odmah
    public void scroll(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    // za kliktanje na element koji nije vidljiv u startu
    public void click (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
//    public void dblclick (WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].dblclick();", element);
//    }
    //dblclick


    @AfterClass
    public void tearDown(){
//        driver.close();
//        driver.quit();
    }


}
