package com.org.ashish.financeservices.controller;


import com.org.ashish.financeservices.exception.ResourceNotFoundException;
import com.org.ashish.financeservices.model.FinanceComponent;
import com.org.ashish.financeservices.repository.FinanceComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/v1")
public class FinanceComponentController {

    @Autowired
    private FinanceComponentRepository financeComponentRepository;

    @GetMapping("/financeComponents")
    public List<FinanceComponent> getAllFinanceComponents()
    {
        return financeComponentRepository.findAll();
    }

    @PostMapping("/financeComponents")
    public FinanceComponent createFinanceComponent(@RequestBody FinanceComponent financeComponent)
    {
        return  financeComponentRepository.save(financeComponent);
    }

    @GetMapping("/financeComponents/{id}")
    public ResponseEntity<FinanceComponent> getFinanceComponentById(@PathVariable(value="id") Long financeComponentId) throws ResourceNotFoundException
    {
       FinanceComponent financeComponent=financeComponentRepository.findById(financeComponentId)
               .orElseThrow(()->new ResourceNotFoundException("Finance Component does not exist for this id : " +financeComponentId));

               return ResponseEntity.ok(financeComponent);
    }
    @PutMapping("/financeComponents/{id}")
    public ResponseEntity<FinanceComponent> updateEmployee(@PathVariable(value = "id") Long financeComponentId, @RequestBody FinanceComponent financeComponentDetails) throws ResourceNotFoundException {
        FinanceComponent financeComponent = financeComponentRepository.findById(financeComponentId)
                .orElseThrow(() -> new ResourceNotFoundException("Finance Component not found for this id :: " + financeComponentId));
        financeComponent.setName(financeComponentDetails.getName());

        final FinanceComponent updatedFinanceComponent = financeComponentRepository.save(financeComponent);
        return ResponseEntity.ok(updatedFinanceComponent);
    }


    @DeleteMapping("/financeComponents/{id}")
    public Map<String, Boolean> deleteFinanceComponent(@PathVariable(value = "id") Long financeComponentId)
            throws ResourceNotFoundException {
        FinanceComponent financeComponent = financeComponentRepository.findById(financeComponentId)
                .orElseThrow(() -> new ResourceNotFoundException("Finance Component not found for this id :: " + financeComponentId));

        financeComponentRepository.delete(financeComponent);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
