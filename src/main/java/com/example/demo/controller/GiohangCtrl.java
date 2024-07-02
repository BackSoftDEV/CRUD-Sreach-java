package com.example.demo.controller;


import com.example.demo.enity.Giohang;
import com.example.demo.enity.Khachhang;
import com.example.demo.repository.GiohangRepo;
import com.example.demo.repository.KhachHangRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("gio-hang")
public class GiohangCtrl {
    @Autowired
    GiohangRepo giohangRepo;
    @Autowired
    KhachHangRepo khachHangRepo;

    @ModelAttribute("listKH")
    public List<Khachhang> kh() {
        return khachHangRepo.findAll();
    }

    @GetMapping("/hien-thi")
    public String index(Model model) {
        model.addAttribute("list", giohangRepo.findAll());
        model.addAttribute("giohang", new Giohang());
        return "index";
    }

   @GetMapping("/add")
   public String viewAdd(Model model) {
       model.addAttribute("a", new Giohang());
       model.addAttribute("listKH", khachHangRepo.findAll());
       return "form";
   }

   @PostMapping("/add")
   public String add(@Valid @ModelAttribute("a") Giohang giohang, BindingResult result ) {
       if (result.hasErrors()){
           return"form";
       }else {
           giohangRepo.save(giohang);
           return "redirect:/gio-hang/hien-thi";
       }
   }

    @GetMapping("/edit/{id}")
    public String viewedit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("giohang", giohangRepo.findAll());
        model.addAttribute("a", giohangRepo.findById(id));
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid @ModelAttribute("a") Giohang giohang) {
        giohangRepo.save(giohang);
        return "redirect:/gio-hang/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        giohangRepo.deleteById(id);
        return "redirect:/gio-hang/hien-thi";
    }
    @GetMapping("/search")
    public String search(
            Model model,
            @RequestParam String keyword
        ) {
        List<Giohang> products = giohangRepo.findByTen("%" + keyword + "%");
        model.addAttribute("list", products);
        return "index";
    }

}
