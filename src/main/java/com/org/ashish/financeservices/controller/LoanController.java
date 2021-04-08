package com.org.ashish.financeservices.controller;

import com.org.ashish.financeservices.exception.ResourceNotFoundException;
import com.org.ashish.financeservices.model.Loan;
import com.org.ashish.financeservices.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loans")
    public List<Loan> getAllLoans()
    {
        return loanRepository.findAll();
    }

    @PostMapping("/loans")
    public Loan createLoans(@RequestBody Loan loan)
    {
        return  loanRepository.save(loan);
    }

    @GetMapping("/loans/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable(value="id") Long loanId) throws ResourceNotFoundException
    {
        Loan loan=loanRepository.findById(loanId)
                .orElseThrow(()->new ResourceNotFoundException("Loan does not exist for this id : " +loanId));

        return ResponseEntity.ok(loan);
    }
    @PutMapping("/loans/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") Long loanId, @RequestBody Loan loanDetails) throws ResourceNotFoundException {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id :: " + loanId));
        loan.setBankName(loanDetails.getBankName());
        loan.setAmount(loanDetails.getAmount());
        final Loan updatedLoan = loanRepository.save(loan);
        return ResponseEntity.ok(updatedLoan);
    }


    @DeleteMapping("/loans/{id}")
    public Map<String, Boolean> deleteLoan(@PathVariable(value = "id") Long loanId)
            throws ResourceNotFoundException {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found for this id :: " + loanId));

        loanRepository.delete(loan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
