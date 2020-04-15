package ru.stqa.pft.webtests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class NotificationsTests {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod ()
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void test() {
    driver.get("http://stc-stage1.fos.transas.com/#/overview");
    driver.findElement(By.id("dropdown-menu")).click();
    driver.findElement(By.xpath("//article/button")).click();
    driver.findElement(By.xpath("//a[@id='ngb-tab-20']/span")).click();
    driver.findElement(By.xpath("//input[@type='number']")).click();
    driver.findElement(By.xpath("//input[@type='number']")).clear();
    driver.findElement(By.xpath("//input[@type='number']")).sendKeys("30");
    driver.findElement(By.xpath("//div[@id='ngb-tab-20-panel']/div/section/article/notification-tab/form/article[2]")).click();
    driver.findElement(By.xpath("//div[@id='ngb-tab-20-panel']/div/section/article/notification-tab/form/article[2]/app-checkbox/label")).click();
    driver.findElement(By.xpath("//div[@id='ngb-tab-20-panel']/div/section/article/notification-tab/form/article[2]/app-checkbox/label")).click();
    driver.findElement(By.xpath("//div[@id='ngb-tab-20-panel']/div/section/article/notification-tab/form/article[3]/app-checkbox/label")).click();
    driver.findElement(By.xpath("//div[@id='ngb-tab-20-panel']/div/section/article/notification-tab/form/article[3]/app-checkbox/label")).click();
    driver.findElement(By.xpath("(//input[@type='number'])[2]")).click();
    driver.findElement(By.xpath("(//input[@type='number'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("30");
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.id("dropdown-menu")).click();
    driver.findElement(By.xpath("//article/button")).click();
    driver.findElement(By.id("ngb-tab-23")).click();
  }

  @AfterMethod ()
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
