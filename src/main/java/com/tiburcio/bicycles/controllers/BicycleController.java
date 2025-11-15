package com.tiburcio.bicycles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tiburcio.bicycles.entity.models.Bicycle;
import com.tiburcio.bicycles.entity.services.IBicycleService;

@Controller
public class BicycleController {
	
	@Autowired
    private IBicycleService bicycleService;

    @GetMapping("/bicycles")
    public String index(Model model) {
        model.addAttribute("bicycles", bicycleService.getAll());
        return "bicycles/bicycle-list";
    }

    @GetMapping("/bicycles/create")
    public String create(Model model) {
        Bicycle bicycle = new Bicycle();
        model.addAttribute("bicycle", bicycle);
        return "bicycles/bicycle-create";
    }

    @PostMapping("/bicycles")
    public String store(@ModelAttribute("bicycle") Bicycle bicycle) {
    	bicycleService.save(bicycle);
        return "redirect:/bicycles";
    }

    @GetMapping("/bicycles/{id}/edit")
    public String edit(@PathVariable(value = "id") long id, Model model) {
        Bicycle bicycle = bicycleService.get(id);
        model.addAttribute("bicycle", bicycle);
        return "bicycles/bicycle-update";
    }
    
    @PostMapping("/bicycles/{id}")
    public String update(@ModelAttribute("bicycle") Bicycle bicycle, @PathVariable(value = "id") long id) {
    	bicycleService.save(bicycle);
        return "redirect:/bicycles";
    }

    @GetMapping("/bicycles/{id}/destroy")
    public String destroy(@PathVariable(value = "id") long id) {
    	bicycleService.destroy(id);
        return "redirect:/bicycles";

    }
}
