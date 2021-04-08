package com.org.ashish.financeservices.controller;

import com.org.ashish.financeservices.exception.ResourceNotFoundException;
import com.org.ashish.financeservices.model.FinanceComponent;
import com.org.ashish.financeservices.model.FixedDeposit;
import com.org.ashish.financeservices.repository.FixedDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
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


    @GetMapping("/fixedDeposits/{id}")
    public ResponseEntity<FixedDeposit> getFixedDepositById(@PathVariable(value="id") Long fixedDepositId) throws ResourceNotFoundException
    {
        FixedDeposit fixedDeposit=fixedDepositRepository.findById(fixedDepositId)
                .orElseThrow(()->new ResourceNotFoundException("Fixed Deposit does not exist for this id : " +fixedDepositId));

        return ResponseEntity.ok(fixedDeposit);
    }
    @PutMapping("/fixedDeposits/{id}")
    public ResponseEntity<FixedDeposit> updateFixedDeposit(@PathVariable(value = "id") Long fixedDepositId, @RequestBody FixedDeposit fixedDepositDetails) throws ResourceNotFoundException {
        FixedDeposit fixedDeposit = fixedDepositRepository.findById(fixedDepositId)
                .orElseThrow(() -> new ResourceNotFoundException("Fixed Deposit not found for this id :: " + fixedDepositId));
        fixedDeposit.setBankName(fixedDepositDetails.getBankName());
        fixedDeposit.setDepositDate(fixedDepositDetails.getDepositDate());
        fixedDeposit.setDepositAmount(fixedDepositDetails.getDepositAmount());
        fixedDeposit.setMaturityAmount(fixedDepositDetails.getMaturityAmount());
        fixedDeposit.setMaturityDate(fixedDepositDetails.getMaturityDate());
        final FixedDeposit updatedFixedDeposit = fixedDepositRepository.save(fixedDeposit);
        return ResponseEntity.ok(updatedFixedDeposit);
    }


    @DeleteMapping("/fixedDeposits/{id}")
    public Map<String, Boolean> deleteFixedDeposit(@PathVariable(value = "id") Long fixedDepositId)
            throws ResourceNotFoundException {
        FixedDeposit fixedDeposit = fixedDepositRepository.findById(fixedDepositId)
                .orElseThrow(() -> new ResourceNotFoundException("Fixed Deposit not found for this id :: " + fixedDepositId));

        fixedDepositRepository.delete(fixedDeposit);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
