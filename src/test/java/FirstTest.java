import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

//1) Зайти на сайт https://www.google.by/
//2) Осуществить поиск по любому запросу (например: selenium webdriver)
//3) Проверить, что результатов поиска > 0
//4) Проверить, что результаты поиска консистентны запросу из шага 2
//5)Код "положить" в GitHub



public class FirstTest {


  private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\Work\\QA\\Automation\\googletask\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void googleTest() {
        WebElement results = driver.findElement(By.id("result-stats"));
        Assert.assertNotNull(results);
    }
   @Test
    public void googleTestTwo(){
       List<String> stText = new ArrayList<>();
       List<WebElement> text= driver.findElements(By.xpath("//body[@id='gsr']/div[@id='main']/div[@id='cnt']/div[@class='mw']/div[@id='rcnt']/div[@class='col']/div[@id='center_col']/div[@id='res']/div[@id='search']/div/div[@id='rso']/div[@class='g']//div[@class='rc']//div[@class='s']//div//span[@class='st']"));
       for (int i = 0; i < text.size(); i++) {
           stText.add(text.get(i).getText().toLowerCase());
           System.out.println(i); //вывод элемента i
           System.out.println(text.get(i).getText()); //вывод текста из результатов поиска
           System.out.println(text.get(i).getText().toLowerCase().contains("Selenium".toLowerCase()) || text.get(i).getText().toLowerCase().contains("Webdriver".toLowerCase())); //вывод true/false на экран
           assertTrue(text.get(i).getText().toLowerCase().contains("Selenium".toLowerCase()) || text.get(i).getText().toLowerCase().contains("Webdriver".toLowerCase())); //сама проверка

       }

   }



    //  WebElement search =driver.findElement(By.className("st"));
      // System.out.println(search);


      /* List<String> a = new ArrayList<String>();
        List<WebElement> text = driver.findElements(By.className("st"));
        for (int i = 0; i < text.size(); i++) {
            a.add(text.get(i).getText());
            System.out.println(text.get(i).getText());
            System.out.println("");
            //assertTrue(text.contains("Selenium"));
        }
        assertTrue(text.contains("Selenium"));*/
      //  assertTrue(driver.findElement(By.className("st")).getText().contains("Selenium"));
    //}

}
