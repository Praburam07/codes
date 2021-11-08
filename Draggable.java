package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://jqueryui.com/draggable/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebElement findElement = driver.findElement(By.className("demo-frame"));

driver.switchTo().frame(findElement);
WebElement findElement2 = driver.findElement(By.id("draggable"));
Actions builder = new Actions(driver);
builder.dragAndDropBy(findElement2, 22, 034).perform();

	}

}
