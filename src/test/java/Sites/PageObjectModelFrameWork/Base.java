package Sites.PageObjectModelFrameWork;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

public class Base {
	public WebDriver driver;
  
	@Parameters({"browser","url"})
	  @BeforeClass
	  public  void browser(String browser,String url) throws InterruptedException {
			if(browser.equalsIgnoreCase("Chrome")) {
				String userdirectoriespth=System.getProperty("user.dir");
				System.out.println(userdirectoriespth);
				System.setProperty("webdriver.chrome.driver", userdirectoriespth+"\\Drivers\\chromedriver.exe");
		        driver=new ChromeDriver();
				driver.navigate().to(url);
		        driver.manage().window().maximize();//how to maximize
		 } else if(browser.equalsIgnoreCase("Firefox")){
			 String userdirectoriespth=System.getProperty("user.dir");
			 System.out.println(userdirectoriespth);
			 System.setProperty("webdriver.gecko.driver", userdirectoriespth+"\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.navigate().to(url);
			 driver.manage().window().maximize();//how to maximize
			  }else {
				  System.out.println("Wrong browser name");
			  }
			
		}

  @AfterClass
  public void afterClass() throws IOException, InterruptedException {
	  screenshots();
	  Thread.sleep(8000);
	  driver.quit();
	  
  }
  
public void screenshots() throws IOException {
	String userdirectoriespth=System.getProperty("user.dir");
	Date dt=new Date();
	String ut=dt.toString().replace(" ", "_").replace(":", "_")+".jpg";
	File Captureofshots=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileHandler.copy(Captureofshots, new File(userdirectoriespth+"\\Photosd\\"+ut));
	 }
public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
    iTestContext.setAttribute("driver", driver);

    return iTestContext;
}
}

