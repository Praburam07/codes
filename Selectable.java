package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://jqueryui.com/selectable/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebElement findElement = driver.findElement(By.className("demo-frame"));
driver.switchTo().frame(findElement);
WebElement findElement2 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[2]"));
WebElement findElement3 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[3]"));
WebElement findElement4 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[4]"));
Actions builder = new Actions(driver);
builder.keyDown(Keys.CONTROL).click(findElement2).click(findElement3).click(findElement4).keyUp(Keys.CONTROL).perform();

	}

}
