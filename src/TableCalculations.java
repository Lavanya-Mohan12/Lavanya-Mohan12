import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableCalculations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anith\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Scroll down the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,600)");

		// Retrieves the Row counts and displays the 2nd row text.

		WebElement table = driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());

		// Assertions to validate the size of rows.
		Assert.assertEquals(11, table.findElements(By.tagName("tr")).size());
		Assert.assertTrue(true);

		// Retrieves the Row count and displays the total sum of the Amount

		WebElement table1 = driver.findElement(By.cssSelector(".tableFixHead"));
		System.out.println(table1.findElements(By.tagName("tr")).size());

		List<WebElement> values = table1.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;

		for (int i = 0; i < values.size(); i++) {

			sum = sum + Integer.parseInt(values.get(i).getText());

		}
		System.out.println(sum);
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(296, total);

	}

}
