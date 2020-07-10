package com.luigi.cocktails.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/") // dev url: http://localhost:8080/LuigiCocktails/
	public void index(HttpServletRequest request, HttpServletResponse response) {

		StringBuffer link = request.getRequestURL();
		
		try {
			response.sendRedirect(link + "ingredients");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}