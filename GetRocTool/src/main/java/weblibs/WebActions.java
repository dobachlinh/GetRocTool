package weblibs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions
{
	public static String driver_name = null;
  public static String driver_location = null;
  public static WebDriver driver;
  public static WebDriverWait wait;
  
	 public static void Init(String configPath) {
     try {
         //GetRocsConfiguration(configPath);
         System.setProperty(driver_name, driver_location);

         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         wait = new WebDriverWait(driver, 80);

     } catch (Exception e) {
         // TODO Auto-generated catch block
         System.out.println(e.getCause());
         System.out.println(e.getMessage());
         e.printStackTrace();
     }
 }

}
