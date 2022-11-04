package com.example.myProject.controllers;

import com.example.myProject.models.Cell;
import com.example.myProject.repos.CellRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String homeGreeting(Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }


    @GetMapping("/about")
    public String about(Model model) {
        List<Cell> cellList = new CellRepository().findAll();

        model.addAttribute("cellList", cellList);
        return "about";
    }

    @GetMapping("/addCells")
    public String addCells(Model model) {
        return "addCells";
    }

    @PostMapping("/addCells")
    public String addCellsPost(@RequestParam short health, @RequestParam short max_health,
                               @RequestParam short radius, @RequestParam short regen, Model model) {

        CellRepository cellRepository = new CellRepository();
        cellRepository.insert(new Cell(health, max_health, radius, regen));
        return "redirect:/about";
    }
}