package com.example.telstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.telstore.model.Plan;
import com.example.telstore.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable Long id) {
        return planService.getPlanById(id);
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

    @PutMapping("/{id}")
    public Plan updatePlan(@RequestBody Plan plan, @PathVariable Long id) {
        return planService.updatePlan(plan, id);
    }

    @DeleteMapping("/{id}")
    public String deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return "Deleted with full Success ahhhh";
    }
}