package com.learning.springboot.web.springbootfirstwebapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learning.springboot.web.springbootfirstwebapplication.model.ToDo;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<>();
	private static int todoCount = 3;
	static {
		todos.add(new ToDo(1, "sathian", "learning spring boot", new Date(), false));
		todos.add(new ToDo(2, "saravana", "learning microservices", new Date(), false));
		todos.add(new ToDo(3, "sanjay", "learning hibernate", new Date(), false));

	}

	public List<ToDo> retrieveTodos(String user) {
		System.out.println(user);
		return todos.stream().filter(a -> a.getUser().equals(user)).collect(Collectors.toList());
	}
	
	public ToDo retrieveTodoById(int id) {
		return todos.stream().filter(a -> a.getId()==(id)).findAny().get();
	}
	
	public void updateTodo(ToDo todo) {
		todos.remove(todo);
		todos.add(todo);
		
	}

	public void addTodo(String user, String desc, Date targetDate, boolean isDone) {
		todos.add(new ToDo(++todoCount, user, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		Iterator<ToDo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			ToDo next = iterator.next();
			if (next.getId() == id) {
				iterator.remove();
				todoCount--;
			}

		}
	}

}
