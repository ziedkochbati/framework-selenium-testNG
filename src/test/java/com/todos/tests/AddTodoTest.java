package com.todos.tests;

import java.io.IOException;

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
		todopage.submitTodo(prop.getProperty("todo1"));
	} 

}
