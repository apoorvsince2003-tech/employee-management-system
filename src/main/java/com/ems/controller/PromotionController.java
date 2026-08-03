package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.Promotion;
import com.ems.service.PromotionService;

@RestController
@RequestMapping("/api/promotions")
@CrossOrigin(origins = "*")
public class PromotionController {

    @Autowired
    private PromotionService service;

    // Add Promotion
    @PostMapping
    public Promotion addPromotion(@RequestBody Promotion promotion) {
        return service.promoteEmployee(promotion);
    }

    // Get All Promotions
    @GetMapping
    public List<Promotion> getAllPromotions() {
        return service.getAllPromotions();
    }

    // Get Promotion By ID
    @GetMapping("/{id}")
    public Optional<Promotion> getPromotionById(@PathVariable int id) {
        return service.getPromotionById(id);
    }

    // Update Promotion
    @PutMapping("/{id}")
    public Promotion updatePromotion(@PathVariable int id,
                                     @RequestBody Promotion promotion) {
        return service.updatePromotion(id, promotion);
    }

    // Delete Promotion
    @DeleteMapping("/{id}")
    public String deletePromotion(@PathVariable int id) {
        service.deletePromotion(id);
        return "Promotion Deleted Successfully";
    }
}