package com.todos.tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.todos.pages.TodoPage;
import com.todos.utils.Setup;

public class AddTodoTest extends Setup {

	public AddTodoTest() throws IOException {
		super();

	}
	TodoPage todopage;
	@Test
	public void iCanAddTodo() throws IOException {
		todopage = new TodoPage();
		boolean elementText = todopage.isElementDisplayed(TodoPage.inpuText);
		Assert.assertTrue(elementText);
		todopage.submitTodo(prop.getProperty("todo1"));
		String element = todopage.checkElementContains(TodoPage.elementTodo);
		Assert.assertTrue(element.contains(prop.getProperty("todo1")));
		boolean boxCheck = todopage.isCheckBoxSelected(TodoPage.checkBox);
		Assert.assertFalse(boxCheck);
	} 
	public String checkTextIsRemoved(WebElement element) {

		String pageSource = driver.getPageSource();
		return pageSource;
		}
}
