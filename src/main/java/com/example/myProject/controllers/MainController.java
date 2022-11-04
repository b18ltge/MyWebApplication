package com.example.myProject.controllers;

import com.example.myProject.models.Cell;
import com.example.myProject.utils.DBClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Cell> cellList = new ArrayList<>();
        var rowSet = DBClass.getTemplate().queryForRowSet("select * from Cells");

        if (rowSet != null) {
            while(rowSet.next()) {
                short health = rowSet.getShort(1);
                short max_health = rowSet.getShort(2);
                short radius = rowSet.getShort(3);
                short regen = rowSet.getShort(4);

                cellList.add(new Cell(health, max_health, radius, regen));
            }
        }


        model.addAttribute("cellList", cellList);
        return "home";
    }
}