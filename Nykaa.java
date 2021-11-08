package assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.nykaa.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
Actions builder = new Actions(driver);
builder.moveToElement(brands).perform();
driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
driver.findElement(By.xpath("//div[@class='css-ov2o3v']//a")).click();
WebElement text = driver.findElement(By.xpath("//h1[@class='css-zwh66v']"));
String title = driver.getTitle();
System.out.println(title);
driver.findElement(By.className("sort-name")).click();
driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//span[text()='Category']")).click();
driver.findElement(By.xpath("//span[text()='Hair']")).click();
driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
driver.findElement(By.xpath("//span[@class='title']")).click();
driver.findElement(By.xpath("//span[text()='Concern']")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> winList = new ArrayList<String>(windowHandles);
driver.switchTo().window(winList.get(1));
WebElement findElement = driver.findElement(By.xpath("//select[@title='SIZE']"));
Select dropDown = new Select(findElement);
dropDown.selectByVisibleText("175ml");
String findElement2 = driver.findElement(By.className("css-12x6n3h")).getText();
System.out.println("the mrp is:" + findElement2);
driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
driver.findElement(By.className("cart-count")).click();
Thread.sleep(2000);
WebElement findElement4 = driver.findElement(By.tagName("iframe"));
driver.switchTo().frame(findElement4);

String text2 = driver.findElement(By.xpath("//div[@class='table-row ']//div[2]")).getText();
System.out.println("Grand total : " + text2);

driver.findElement(By.xpath("//span[text()='Proceed']")).click();
driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

String text3 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
if (text2.equals(text3)) {
	System.out.println("Grand total is same");
} else {
	System.out.println("Grand total is diff");
}
//button[text()='CONTINUE AS GUEST']
driver.quit();
	}

}
