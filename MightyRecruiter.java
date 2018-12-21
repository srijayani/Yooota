import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MightyRecruiter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
String data = null,data2 = null, data3 = null, data4 = null;
		
		for(int i = 1; i<=12; i++) {

		try { 
		
			  // Specify the path of file
			  File src=new File("C:\\Users\\Devi_qa\\Desktop\\job_req_1.xlsx");
			 
			   // load file
			   FileInputStream fis=new FileInputStream(src);
			 
			   // Load workbook
			   XSSFWorkbook wb = new XSSFWorkbook(fis);
			   
			   // Load sheet- Here we are loading first sheet only
			      XSSFSheet sh1= wb.getSheetAt(0);
			 
			  // getRow() specify which row we want to read.
			 
			  // and getCell() specify which column to read.
			  // getStringCellValue() specify that we are reading String data.
			 
			 
			   data = sh1.getRow(i).getCell(0).getStringCellValue();//job title
			 
			  data2 = sh1.getRow(i).getCell(1).getStringCellValue(); //description
			  
			  data3 = sh1.getRow(i).getCell(2).getStringCellValue(); //location
			  
			  data4 = sh1.getRow(i).getCell(3).getStringCellValue();  //skill
			 System.out.println(data);
			 System.out.println(data2);
			 System.out.println(data3);
			 System.out.println(data4);
	
			 
		}catch (Exception e) {
			 
			   System.out.println(e.getMessage());
			 
			  }
		
						
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumTraining\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver myWebDriver = new FirefoxDriver();
		driver.get("https://recruiter.mightyrecruiter.com/accounts?ReturnUrl=%2F");
		driver.manage().window().maximize();
					
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("hr@yooota.com");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Welcome_18");
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[contains(text(),'CREATE JOB')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='Title']")).sendKeys(data);
		//driver.findElement(By.xpath("//input[@id='autocomplete']")).click();
		//driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("McKinney, TX 75070, USA");
		//driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.TAB);
		WebElement myWebElement = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		myWebElement.sendKeys(data3);
		Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		Actions myActions = new Actions(driver);
		myActions.moveToElement(myWebElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//*[contains(text(),'Add your job description')]")).sendKeys(data2);
		
		driver.findElement(By.xpath("//input[@id='SalaryFrom']")).sendKeys("40");
		driver.findElement(By.xpath("//input[@id='SalaryTo']")).sendKeys("60");
		
		WebElement myWebElement1 =  driver.findElement(By.xpath("//button[@title='Select']"));
		Actions myActions1 = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		myActions1.click(myWebElement1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

		
		WebElement myWebElement2 =  driver.findElement(By.xpath("//button[@title='Select Employment Type']"));
		Actions myActions2 = new Actions(driver);		
		myActions2.click(myWebElement2).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//*[contains(text(),'Save and Post Now')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='btnSaveContinue']")).click();
		
		Thread.sleep(2000);
		driver.close();
		if(i==5) {
			break;
			
		}
		
	}

 } 
	
}
