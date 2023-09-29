package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.reponsitory.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/hien-thi")
    public String getAll(Model model){
        List<Category> list = service.getAll();
        model.addAttribute("list",list);
        return "index";
    }

    @GetMapping("/view-add")
    public String viewAdd(){
        return "viewAdd";
    }



    @GetMapping("/view-update/{id}")
    public String viewUpadte(@PathVariable Long id,Model model){
        Category category = service.getone(id);
        model.addAttribute("ca",category);
        return "viewUpadte";
    }

    @PostMapping()
    public String Add(@RequestParam String code, @RequestParam String name){
        Category category = Category.builder().code(code).name(name).build();
        service.add(category);
        return "redirect:/category/hien-thi";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @RequestParam String code,
                         @RequestParam String name){
        Category category = Category.builder().code(code).name(name).build();
        service.update(id,category);
        return "redirect:/category/hien-thi";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/category/hien-thi";
    }

}
