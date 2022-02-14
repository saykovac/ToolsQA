package DemoQAPages;

import DemoQABase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        //super();
        PageFactory.initElements(driver, this);
    }

    /*
    * Actions act = new Actions(driver);
        act.doubleClick(doubleClickButton()).perform();
        *
        *
        * ArrayList<String> listaTabova = new ArrayList<>
            driver.switchTo().window(listaTabova.get(1));
            Za prelazak na novootvoreni tab koristiš 1, za povratak na početni 0.
            * Driver moraš uvek manuelno da prebaciš na koji tab hoćeš da ti radi, neće automatski čak i ako se zatvori prozor.
            *
            *
            *
            *
            *
            * wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#linkResponse")));


*/

    // cssSelector "[imeAtributa='']"   ---> recimo za <a> tag src trazimo cssSelector "[src='']"





    public @FindBy (className = "banner-image")
    WebElement bannerImg;

//    // glavni meni ima nema nijedan jedinstven selektor, uzmemo jedan zajednicki
//    public @FindBy (css = ".category-cards")
//    WebElement cardsMenu;

    // napravimo listu i nakon toga uzimamo jedan koji hocemo
    public @FindBy (css = ".card-up")
    List<WebElement> menuList;












    //-----------------------------------------------------------


    public void selectCardMenu(int n){
        menuList.get(n).click();
    }

}
