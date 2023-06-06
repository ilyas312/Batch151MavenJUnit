package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasına gidelim
        driver.get("https://www.amazon.com/");

        //arama kutusun locate edelim
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //"Samsung headphones"    ile arama yapalım
        aramakutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuç sayısınız yazdıralım
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String [] sonucSayisi=sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi =" +sonucSayisi[2]);

        //ilk ürünü tıklayalım
        WebElement ilkUrun=driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        //Sayfadaki tüm başlıkları yazdıralım
        List<WebElement> sayfaBasliklari=driver.findElements(By.xpath("//h1 | //h2"));
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));
    }
}
