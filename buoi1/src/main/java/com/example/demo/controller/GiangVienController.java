package com.example.demo.controller;

import com.example.demo.entity.GiangVien;
import com.example.demo.services.GiangVienServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/giang-vien/hien-thi")
public class GiangVienController {

    @Autowired
    private GiangVienServices giangVienServices;

    @GetMapping()
    public String getAll(Model model) {
        List<GiangVien> list = giangVienServices.getAll();
        model.addAttribute("giangvien", list);
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        GiangVien giangVien = this.giangVienServices.getOne(id);
        model.addAttribute("gv", giangVien);
        return "detail";
    }

    @GetMapping("/add")
    public String pageAdd() {
        return "add";
    }

    @GetMapping("/search")
    public String search(@RequestParam String ten, Model model) {
        List<GiangVien> list = giangVienServices.search(ten);
        model.addAttribute("giangvien",list);
        return "index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        this.giangVienServices.delete(id);
        return "redirect:/giang-vien/hien-thi";
    }

    @PostMapping()
    public String add(@RequestParam String ma,
                      @RequestParam String ten,
                      @RequestParam String diaChi,
                      @RequestParam int tuoi,
                      @RequestParam boolean gioiTinh) {
        Random random = new Random();
        char id = (char) random.nextInt(100);

        GiangVien giangVien = new GiangVien(String.valueOf(id), ma, ten, tuoi, gioiTinh, diaChi);
        this.giangVienServices.add(giangVien);
        return "redirect:/giang-vien/hien-thi";

    }

    @GetMapping("/update/{id}")
    public String pageUpdate(@PathVariable String id,Model model) {
        GiangVien giangVien = this.giangVienServices.getOne(id);
        model.addAttribute("gv", giangVien);
        return "update";
    }

    @PostMapping("{id}")
    public String update(@RequestParam String ma,
                         @RequestParam String ten,
                         @RequestParam String diaChi,
                         @RequestParam int tuoi,
                         @RequestParam boolean gioiTinh, @PathVariable String id) {

        GiangVien giangVien = new GiangVien(String.valueOf(id), ma, ten, tuoi, gioiTinh, diaChi);
        this.giangVienServices.update(giangVien, id);
        return "redirect:/giang-vien/hien-thi";
    }

}
