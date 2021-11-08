package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mynthra {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();

ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.myntra.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
Actions builder = new Actions(driver);
WebElement findElement = driver.findElement(By.xpath("//a[@class='desktop-main']"));
builder.moveToElement(findElement).perform();
driver.findElement(By.xpath("//a[@data-reactid='40']")).click();
String text1 = driver.findElement(By.xpath("//span[@class='title-count']")).getText().replaceAll("[\\D]", "");
System.out.println(text1);
Integer jacketCount = Integer.parseInt(text1);

String text2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText().replaceAll("[\\D]", "");
Integer jackets =Integer.parseInt(text2);
String text3 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText().replaceAll("[\\D]", "");
Integer rainJackets = Integer.parseInt(text3);
Integer sum = jackets + rainJackets;
if (sum.equals(jacketCount)) {
	System.out.println("the sum matches ");
}else {
	System.out.println("not matches");
}

driver.findElement(By.className("brand-more")).click();
driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']/input")).sendKeys("duke");
Thread.sleep(5000);
driver.findElement(By.xpath("//label[@class = ' common-customCheckbox']")).click();




	}

}
