import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Links_Extract {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		
		for(int i=0 ; i< allLinks.size();i++){
			System.out.println(allLinks.get(i).getText());
		}
		System.out.println("**************************************************");
		
		WebElement footer = driver.findElement(By.xpath("//*[@id='footer']"));
		
		List<WebElement> footer_links = footer.findElements(By.tagName("a"));
		
		for(int i=0 ; i< footer_links.size();i++){
			System.out.println(footer_links.get(i).getText());
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("c:\\google.jpg"));

		
		
		
	}

}
