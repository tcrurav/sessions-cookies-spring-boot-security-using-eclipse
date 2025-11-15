package com.tiburcio.bicycles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tiburcio.bicycles.entity.models.AppUser;
import com.tiburcio.bicycles.entity.services.IAppUserService;

@Controller
public class AuthController {

	@Autowired
    private IAppUserService appUserService;
		
	@GetMapping("/")
	public String home() {
		return "redirect:/bicycles";
	}
	
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
    
    @GetMapping("/register")
    public String showRegisterForm() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username,
                                  @RequestParam String password) {
    	appUserService.register(new AppUser(username, password));
        return "redirect:/login?registered";
    }
}
