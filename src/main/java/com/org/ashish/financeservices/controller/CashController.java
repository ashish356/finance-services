package com.org.ashish.financeservices.controller;

import com.org.ashish.financeservices.exception.ResourceNotFoundException;
import com.org.ashish.financeservices.model.Cash;
import com.org.ashish.financeservices.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class CashController {

    @Autowired
    private CashRepository cashRepository;

    @GetMapping("/cashDeposits")
    public List<Cash> getAllCashDeposits()
    {
        return cashRepository.findAll();
    }

    @PostMapping("/cashDeposits")
    public Cash createFixedDeposit(@RequestBody Cash cash)
    {
        return  cashRepository.save(cash);
    }


    @GetMapping("/cashDeposits/{id}")
    public ResponseEntity<Cash> getCashById(@PathVariable(value="id") Long cashId) throws ResourceNotFoundException
    {
        Cash cash=cashRepository.findById(cashId)
                .orElseThrow(()->new ResourceNotFoundException("Cash does not exist for this id : " +cashId));

        return ResponseEntity.ok(cash);
    }
    @PutMapping("/cashDeposits/{id}")
    public ResponseEntity<Cash> updateCashDeposit(@PathVariable(value = "id") Long cashId, @RequestBody Cash cashDetails) throws ResourceNotFoundException {
        Cash cash = cashRepository.findById(cashId)
                .orElseThrow(() -> new ResourceNotFoundException("Cash not found for this id :: " + cashId));
        cash.setAmount(cashDetails.getAmount());
        cash.setCurrencyCode(cashDetails.getCurrencyCode());
        cash.setBank(cashDetails.getBank());

        final Cash updateCashDetails = cashRepository.save(cash);
        return ResponseEntity.ok(updateCashDetails);
    }


    @DeleteMapping("/cashDeposits/{id}")
    public Map<String, Boolean> deleteCashDeposit(@PathVariable(value = "id") Long cashId)
            throws ResourceNotFoundException {
        Cash cash = cashRepository.findById(cashId)
                .orElseThrow(() -> new ResourceNotFoundException("Cash not found for this id :: " + cashId));

        cashRepository.delete(cash);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
