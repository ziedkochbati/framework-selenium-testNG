package com.todos.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static Properties prop;

	public BasePage() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/com/todos/configs/config.properties");
		prop.load(fis);
	}

	public static void initialization(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("firefox"));
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		driver = e_driver;
	}

	// Click Methodby usingJAVA Generic
	public <T> void click(T elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			driver.findElement((By) elementAttr).click();
		} else {
			((WebElement) elementAttr).click();
		}
	}

	// Write Text by using JAVA Generic
	public <T> void writeText(T elementAttr, String text) {
		if (elementAttr.getClass().getName().contains("By")) {
			driver.findElement((By) elementAttr).sendKeys(text);
		} else {
			((WebElement) elementAttr).sendKeys(text);
		}
	}

	// Read Text by using JAVA Generic
	public <T> String readText(T elementAttr) {
		if (elementAttr.getClass().getName().contains("By")) {
			return driver.findElement((By) elementAttr).getText();
		} else {
			return ((WebElement) elementAttr).getText();
		}
	}
}
