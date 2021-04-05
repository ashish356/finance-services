package com.org.ashish.financeservices.controller;


import com.org.ashish.financeservices.model.FinanceComponent;
import com.org.ashish.financeservices.repository.FinanceComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
}
