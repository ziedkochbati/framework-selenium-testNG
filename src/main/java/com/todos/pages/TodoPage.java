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

	/*@FindBy*/
	//@FindBy(id = INPUT_TEXT)
	//private WebElement inputText;
	@FindBy(how = How.XPATH, using = INPUT_TEXT)
	public static WebElement inpuText;

	/*Methods*/
	public void submitTodo(String todo) {
		writeText(inpuText,todo);
		inpuText.sendKeys(Keys.ENTER);
	}
	
}
