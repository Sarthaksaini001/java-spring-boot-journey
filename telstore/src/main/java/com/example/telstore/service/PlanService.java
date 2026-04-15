package com.example.telstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.telstore.exception.PlanNotFoundException;
import com.example.telstore.model.Plan;
import com.example.telstore.repository.PlanRepository;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Plan getPlanById(Long id) {
        return planRepository.findById(id).orElseThrow( () -> new PlanNotFoundException(id) );
    }

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan updatePlan(Plan updatedPlan, Long id) {
        Plan existingPlan = getPlanById(id);

            existingPlan.setName(updatedPlan.getName());
            existingPlan.setPlanType(updatedPlan.getPlanType());
            existingPlan.setMonthlyPrice(updatedPlan.getMonthlyPrice());
            existingPlan.setDataLimit(updatedPlan.getDataLimit());
            existingPlan.setCallsIncluded(updatedPlan.getCallsIncluded());
            existingPlan.setSmsIncluded(updatedPlan.getSmsIncluded());
            existingPlan.setDescription(updatedPlan.getDescription());

            return planRepository.save(existingPlan);
    }

    public String deletePlan(Long id) {
        Plan existingPlan = getPlanById(id);
        planRepository.delete(existingPlan);
        return " Plan Deleted Successfully";
}
}