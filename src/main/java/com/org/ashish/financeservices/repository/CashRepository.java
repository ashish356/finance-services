package com.org.ashish.financeservices.repository;

import com.org.ashish.financeservices.model.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepository extends JpaRepository<Cash,Long> {
}
