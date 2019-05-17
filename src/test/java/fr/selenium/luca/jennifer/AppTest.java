package fr.selenium.luca.jennifer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static final String URL = "http://www.fr.jal.co.jp/frl/en/";
	private static final String PATH_CHROME_DRIVER = "C:\\chromedriver.exe";
	public static WebDriver driver;

	public static void firstTest() {
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);// System.setProperty(key, value)

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pausa(3);

		// driver.findElement(By.linkText("/world/common_rn/img/btn_continue_en.gif"));.click()
		// driver.findElement(By.tagName("continue")).click()
		// List<WebElement> elements = driver.findElements(By.partialLinkTest("btn_cont

		driver.findElement(By.className("JS_ciBox_submit")).click();

		String villeDepart = " ";
		villeDepart = " ";
		String VilleArrivee = " ";
		String FlightNb, Horaire, Prix;

		Select s = new Select(driver.findElement(By.id("mdlDepLocation1")));
		s.selectByValue("NCE");

		// départ//
		Select s1 = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
		s1.selectByValue("6");

		Select s2 = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_DAY")));
		s2.selectByValue("18");
		// retour//
		Select s3 = new Select(driver.findElement(By.id("DEPARTURE_DATE_2_DAY")));
		s3.selectByValue("22");

		Select s4 = new Select(driver.findElement(By.id("DEPARTURE_DATE_2_MONTH")));
		s4.selectByValue("6");
		// travel class//
		Select s5 = new Select(driver.findElement(By.id("CFF_1")));
		s5.selectByValue("1JE");
		// adults//
		Select s6 = new Select(driver.findElement(By.id("mdlNbAdt")));
		s6.selectByValue("1");

		// children//
		Select s7 = new Select(driver.findElement(By.id("mdlNbChd")));
		s7.selectByValue("0");

		// Infants//
		Select s8 = new Select(driver.findElement(By.id("mdlNbInf")));
		s8.selectByValue("0");

		// Valeur variable//

		// search//
		driver.findElement(By.id("mdlFormSubmit")).click();
		/*
		 * Ici on est a la page de disponibilite des vols
		 */
		System.out.println("**********Flight reservations**********");

		// Continue //
		driver.findElement(By.id("mdlNbInf")).click();

		/*
		 * Recuperer le numero de vol
		 */
		try {
			System.out.println(LocalDateTime.now());
		WebDriverWait wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		} catch (TimeoutException e) {
			System.out.println ("J'ai pas trouvé ton WebElement et maintenant il est : "+ LocalDateTime.now());
			
			
		}
				if (driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()) {
			System.out.println("Le flight number s'affiche");
		} else {
			System.out.println("le flight number ne s'affiche pas. On clique pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();

		}
		WebElement element = driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"));
		String flightNumberAVAI = element.getText();
		System.out.println("Flight Number: " + flightNumberAVAI);

		
		try {
			System.out.println(LocalDateTime.now());
		WebDriverWait wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		} catch (TimeoutException e) {
			System.out.println ("J'ai pas trouvé ton WebElement et maintenant il est : "+ LocalDateTime.now());
			
			
		}
		
		// recuperer ville depart
		String villeDepart1 = "NCE";
		villeDepart1 = driver.findElement(By.id("bound-departure-0")).getText();
		System.out.println("Ma ville de départ est : " + villeDepart1);

		String villeArrivee1 = " ";
		villeArrivee1 = driver.findElement(By.id("bound-arrival-0")).getText();
		System.out.println("Ma ville d'arrivée est : " + villeArrivee1);

		// Continue//
		driver.findElement(By.id("continueButton")).click();

		// Title //
		Select s9 = new Select(driver.findElement(By.id("0-title")));
		s9.selectByValue("MRS");

		// Last name//
		driver.findElement(By.id("0-last-name")).sendKeys("LUCA");

		// First name//
		driver.findElement(By.id("0-first-name")).sendKeys("Jennifer");

		// Gender//
		Select s10 = new Select(driver.findElement(By.id("0-gender")));
		s10.selectByValue("string:FEMALE");

		// Date of birth//
		Select s11 = new Select(driver.findElement(By.id("0-birth-date-day")));
		s11.selectByValue("string:27");

		Select s12 = new Select(driver.findElement(By.id("0-birth-date-month")));
		s12.selectByValue("string:09");

		// AAAA//
		Select s13 = new Select(driver.findElement(By.id("0-birth-date-year")));
		s13.selectByValue("string:1984");

		// Nationality//

		Select s14 = new Select(driver.findElement(By.id("0-nationality")));
		s14.selectByValue("string:FR");

		// Phone//
		Select s15 = new Select(driver.findElement(By.id("phone1-phone-type-0")));
		s15.selectByValue("string:APH");

		Select s16 = new Select(driver.findElement(By.id("phone1-phone-country-0")));
		s16.selectByValue("FRA");

		driver.findElement(By.id("phone1-phone-number-0")).sendKeys("0493625210");

		// email//
		driver.findElement(By.id("email-guest-address")).sendKeys("luca.jennifer1@gmail.com");
		driver.findElement(By.id("email-confirm-new")).sendKeys("luca.jennifer1@gmail.com");

		// Continue//
		driver.findElement(By.id("continueButton")).click();
		// Confirm//
		driver.findElement(By.id("continueButton-PCOF")).click();
		// Seat continue//
		driver.findElement(By.id("seatContinue")).click();

		// Go to payment //
		driver.findElement(By.id("purchaseButton")).click();

		// Credit card number//
		driver.findElement(By.id("CCnb")).sendKeys("4012888888881881");

		// Expiry date//
		Select s17 = new Select(driver.findElement(By.id("expiration-month-id")));
		s17.selectByValue("number:6");

		Select s18 = new Select(driver.findElement(By.id("expiration-year-id")));
		s18.selectByValue("number:2022");

		Select s19 = new Select(driver.findElement(By.id("CCname")));
		s19.selectByValue("object:151");

		driver.findElement(By.id("sec-code")).sendKeys("123");

		System.out.println("**********Payment page**********");
		
		
		String villeDepart2 = "NCE";
//		villeDepart2 = driver.findElement(By.id("bound-departure-0")).getText();
		List<WebElement> departureElements = driver.findElements(By.cssSelector(".departure"));
		villeDepart2 = departureElements.get(0).getText();

		System.out.println("Ma ville de départ est : " + villeDepart2);

		String villeArrivee2 = " ";
		villeArrivee2 = departureElements.get(3).getText();

		System.out.println("Ma ville d'arrivée est : " + villeArrivee2);

		WebElement element0 = driver.findElement(By.id("continueButton"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element0).click().build().perform();
		
		try {
			System.out.println(LocalDateTime.now());
		WebDriverWait wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		} catch (TimeoutException e) {
			System.out.println ("J'ai pas trouvé ton WebElement et maintenant il est : "+ LocalDateTime.now());
			
			
		}
				if (driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()) {
			System.out.println("Le flight number s'affiche");
		} else {
			System.out.println("le flight number ne s'affiche pas. On clique pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();

		}
		WebElement element1 = driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"));
		String flightNumberAVAI1 = element1.getText();
		System.out.println("Flight Number: " + flightNumberAVAI1);

		
		try {
			System.out.println(LocalDateTime.now());
		WebDriverWait wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		} catch (TimeoutException e) {
			System.out.println ("J'ai pas trouvé ton WebElement et maintenant il est : "+ LocalDateTime.now());
			
			
		}

		/* ---------------------------Asserts----------------------*/
		System.out.println("Vérifications avec ASSERT");
		
		villeDepart-final= Nice Cote D'Azur Terminal 2;
		villeDepart-initial= Nice; 
		assert True (villeDepart-final.contains(villeDepart-initial);
	
	}

	private static void pausa(int seconds) { 
		try {
			Thread.sleep(seconds * 1000);

		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
