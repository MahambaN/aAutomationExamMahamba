package baseTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AppointmentMakePage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    protected HomePage homePage;

    //protected AppointmentMakePage appointmentMakePage;

    String BASEURL ="https://katalon-demo-cura.herokuapp.com/";
    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);

        homePage = new HomePage(driver);
        homePage.clickOnBtnMakeAppointment();
        homePage.usernameSet();
        homePage.passwordSet();
        //homePage.clickOnBtnLogin();
        //AppointmentMakePage appointmentMakePage = homePage.clickOnBtnLogin();

        //System.out.println("The screen title is " +appointmentMakePage.getTextOnScreen());

    }

}
