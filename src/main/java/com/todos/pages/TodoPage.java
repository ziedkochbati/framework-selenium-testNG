package com.todos.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.todos.utils.BasePage;

public class TodoPage extends BasePage {

	public TodoPage() throws IOException {

		PageFactory.initElements(driver, this);
	}

	/*Locators*/
	final static String INPUT_TEXT = "//header/form[1]/input[1]";
	final static String ELEMENT_TODO = "//label[@class='ng-binding']";
	final static String CHECK_BOX = "//input[@type= 'checkbox']";

	/*@FindBy*/
	//@FindBy(id = INPUT_TEXT)
	//private WebElement inputText;
	@FindBy(how = How.XPATH, using = INPUT_TEXT)
	public static WebElement inpuText;
	@FindBy(how = How.XPATH, using = ELEMENT_TODO)
	public static WebElement elementTodo;
	@FindBy(how = How.XPATH, using = CHECK_BOX)
	public static WebElement checkBox;

	/*Methods*/
	public void submitTodo(String todo) {
		writeText(inpuText,todo);
		inpuText.sendKeys(Keys.ENTER);
	}
	
	// verifier element existent
	
	public Boolean isElementDisplayed(WebElement element) {
		Boolean isElementDisplayed = element.isDisplayed();
		return isElementDisplayed;
	}

	
	public String checkElementContains(WebElement element) {
		String elementTodo = element.getText();
		return elementTodo;
	}
	
	public Boolean isCheckBoxSelected(WebElement element) {
		Boolean isCheckBoxSelected = element.isSelected();
		return isCheckBoxSelected;
	}
	
}
