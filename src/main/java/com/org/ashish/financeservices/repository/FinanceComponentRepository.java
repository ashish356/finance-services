package com.org.ashish.financeservices.repository;


import com.org.ashish.financeservices.model.FinanceComponent;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FinanceComponentRepository extends JpaRepository<FinanceComponent,Long> {
}
