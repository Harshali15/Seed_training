package com.example.demo1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class Controller1 {

	/*@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name, Model model) {
		model.addAttribute("user1", name);
		return "hello";
	}
	*/
	@GetMapping("/add/{num1}/{num2}")
	public String add(@PathVariable int num1, @PathVariable int num2,Model model)
	{
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		return "add";
		
	}
	ArrayList<User> users=new ArrayList<User>();
	static int id=1;

	@GetMapping("/users")
	public String users(Model model)
	{
		/*User user1=new User(1,"Aman","among@gmail.com");
		User user2=new User(2,"Abdul","abdul.codes@gmail.com");
		users.add(user1);
		users.add(user2);*/
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		
		model.addAttribute("sid",id);
		id++;
		return "users";
		
	}
	
	@PostMapping("/users")
	public String addUser(User user) {
		users.add(user);
		return "redirect:/users";
	}
}
