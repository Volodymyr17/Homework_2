import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckingTheMainMenuOfAdminPanel {
    public static void main(String[] args) {
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
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tab-AdminDashboard")));

        String[] tabID = {
                "//li[@data-submenu = '1']",
                "//li[@data-submenu = '3']",
                "//li[@data-submenu = '9']",
                "//li[@data-submenu = '23']",
                "//li[@data-submenu = '27']",
                "//li[@data-submenu = '31']",
                "//li[@data-submenu = '42']",
                "//li[@data-submenu = '46']",
                "//li[@data-submenu = '52']",
                "//li[@data-submenu = '55']",
                "//li[@data-submenu = '58']",
                "//li[@data-submenu = '73']",
                "//li[@data-submenu = '95']",
        };

        for (int i = 0; i < 13; i++) {
            chromeDriver.findElement(By.xpath(tabID[i])).click();
            String title = chromeDriver.findElement(By.tagName("h2")).getText();
            System.out.println(title);
            chromeDriver.navigate().refresh();
            if (!title.equals(chromeDriver.findElement(By.tagName("h2")).getText())) {
                System.out.println("Ошибка, не тот раздел!!!");
            }
        }
        chromeDriver.quit();
    }
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CheckingTheMainMenuOfAdminPanel.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}






