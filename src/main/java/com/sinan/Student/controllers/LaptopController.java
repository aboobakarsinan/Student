package com.sinan.Student.controllers;

import com.sinan.Student.models.Laptop;
import com.sinan.Student.repositories.LaptopRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptops")
public class LaptopController {

    @Autowired
    private LaptopRepository laptopRepository;

    @GetMapping
    public List<Laptop> list () {
        return laptopRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Laptop get(@PathVariable Long id) {
        return laptopRepository.getOne(id);
    }

    @PostMapping
    public Laptop create (@RequestBody Laptop laptop) {
        return laptopRepository.saveAndFlush(laptop);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        laptopRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Laptop update (@PathVariable Long id, @RequestBody Laptop laptop) {
        Laptop existingLaptop = laptopRepository.getOne(id);
        BeanUtils.copyProperties(laptop,existingLaptop,"laptopId");
        return laptopRepository.saveAndFlush(existingLaptop);
    }

}
