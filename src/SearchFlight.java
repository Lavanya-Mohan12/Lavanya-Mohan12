import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SearchFlight {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anith\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");// This set the
																										// values
																										// globally
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}

		}

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // This is the xpath using index value.

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// assertions for disabled calender
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// Adult dropdown

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 0; i < 1; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		for (int i = 0; i < 2; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}

		// Assertion for adult dropdown
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "2 Adult, 2 Child");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();

		WebElement staticdropdowns = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdowns = new Select(staticdropdowns);
		dropdowns.selectByVisibleText("INR");
		// System.out.println(dropdowns.getFirstSelectedOption().getText());

		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
