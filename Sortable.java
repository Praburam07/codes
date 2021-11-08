package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement findElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(findElement);
		WebElement ele1 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		WebElement ele2 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[3]"));
		WebElement ele3 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		WebElement ele4 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		Actions builder = new Actions(driver);
		int x = ele2.getLocation().getX();
		int y = ele2.getLocation().getY();
		int x2 = ele3.getLocation().getX();
		int y2 = ele3.getLocation().getY();
		builder.clickAndHold(ele1).moveByOffset(x, y).release().perform();
		builder.clickAndHold(ele4).moveByOffset(x2, y2).release().perform();
		

	}

}
