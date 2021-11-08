package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://jqueryui.com/resizable/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebElement findElement = driver.findElement(By.className("demo-frame"));
driver.switchTo().frame(findElement);
WebElement findElement2 = driver.findElement(By.xpath("//h3[text()='Resizable']"));
Actions builder = new Actions(driver);
int x = findElement2.getLocation().getX();
int y = findElement2.getLocation().getY();
System.out.println(x);
System.out.println(y);
builder.dragAndDropBy(findElement2, 100, 100);
	}

}
