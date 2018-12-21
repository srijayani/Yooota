import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.yooota.MightyRecruiter;

public class Corp2Corp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	 	MightyRecruiter mg = new MightyRecruiter();
		try {
			mg.PostJob();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
String data = null,data2 = null, data3 = null, data4 = null;
		
		for(int i = 1; i<=1; i++) {

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
		driver.get("http://corp2corp.jobs/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys("hr@yooota.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome_17");
		driver.findElement(By.xpath("//input[@src='/images/btnSub1.jpg']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//a[@href='/project/add']")).click();
		

		
		driver.findElement(By.xpath("//input[@name='pname']")).sendKeys(data);
		driver.findElement(By.xpath("//input[@name='candidates']")).sendKeys("1");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(data2);
		
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		Select select = new Select(driver.findElement(By.id("country")));
		select.selectByVisibleText("United States");
		
		driver.findElement(By.xpath("//input[@name='location']")).sendKeys(data3);
		
		driver.findElement(By.xpath("//textarea[@name='skillset']")).sendKeys(data4);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		if(i==5) {
			break;
			
		}
		
	}



	
}


 	
 	

	}


