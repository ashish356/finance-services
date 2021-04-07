package com.org.ashish.financeservices.controller;

import com.org.ashish.financeservices.model.FixedDeposit;
import com.org.ashish.financeservices.repository.FixedDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class FixedDepositController {

    @Autowired
    private FixedDepositRepository fixedDepositRepository;

    @GetMapping("/fixedDeposits")
    public List<FixedDeposit> getAllFixedDeposits()
    {
        return fixedDepositRepository.findAll();
    }

    @PostMapping("/fixedDeposits")
    public FixedDeposit createFixedDeposit(@RequestBody FixedDeposit fixedDeposit)
    {
        return  fixedDepositRepository.save(fixedDeposit);
    }




}
