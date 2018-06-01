import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginInAdminPanel {
    public static void main (String[] args) {
        WebDriver chromeDriver = initChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get(" http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement login = chromeDriver.findElement(By.name("email"));
        WebElement password = chromeDriver.findElement(By.id("passwd"));
        WebElement entranceButton = chromeDriver.findElement(By.name("submitLogin"));
        login.sendKeys("webinar.test@gmail.com");
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        entranceButton.click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id ='header_logo']")));
        WebElement pictograph = chromeDriver.findElement(By.xpath("//a[@id ='header_logo']"));
        pictograph.click();
        WebElement entranceTab = chromeDriver.findElement(By.id("header_logout"));
        entranceTab.click();
        chromeDriver.quit();
    }
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", LoginInAdminPanel.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
