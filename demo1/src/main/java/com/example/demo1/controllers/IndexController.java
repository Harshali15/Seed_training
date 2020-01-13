package com.example.demo1.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

	@GetMapping({"/","/index"})
	public String index() {
		return "HelloWorld";
	}
	
	@GetMapping("/welcome/{name}")
	public String Welcome(@PathVariable String name)
	{
		return "Welcome "+name;
	}
	
	/*@GetMapping("/add/{num1}/{num2}")
	public String add(@PathVariable int num1, @PathVariable int num2)
	{
		return "Addition : "+ (num1+num2);
		
	}
	
	@GetMapping("/subtract/{num1}/{num2}")
	public String subtract(@PathVariable int num1, @PathVariable int num2)
	{
		return "Subtraction : "+ (num1-num2);
		
	}
	
	@GetMapping("/multiply/{num1}/{num2}")
	public String multiply(@PathVariable int num1, @PathVariable int num2)
	{
		return "Multiplication : "+ (num1*num2);
		
	}
	
	@GetMapping("/divide/{num1}/{num2}")
	public String divide(@PathVariable int num1, @PathVariable int num2)
	{
		return "Division : "+ (num1/num2);
		
	}
	
	@GetMapping("/compare/{str1}/{str2}")
	public String compare(@PathVariable String str1, @PathVariable String str2)
	{
		if(str1.compareToIgnoreCase(str2)==0)
			return "The strings are equal "+ str1 +" "+str2;
		if(str1.compareTo(str2)>0)
			return "String1 is greater "+ str1 ;
		
		else return "String2 is greater "+ str2 ;
		
		
	}
	
	@GetMapping("/names/{arr1}/{arr2}/{arr3}")
	public ArrayList<String> names(@PathVariable String arr1, @PathVariable String arr2,@PathVariable String arr3)
	{
		ArrayList<String> list=new ArrayList<String>();
		list.add(arr1);
		list.add(arr2);
		list.add(arr3);
		return list;
		
	}
	
	@GetMapping("/users")
	public ArrayList<User> users(Model model)
	{
		User user1=new User(1,"Aman","amank@gmail.com");
		User user2=new User(2,"Abdul","abdul.codes@gmail.com");
		ArrayList<User> users=new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		model.addAttribute("users", users);
		return users;
		
	}*/
	
	
	
	
}
