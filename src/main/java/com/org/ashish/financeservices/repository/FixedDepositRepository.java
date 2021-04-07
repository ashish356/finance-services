package com.org.ashish.financeservices.repository;

import com.org.ashish.financeservices.model.FinanceComponent;
import com.org.ashish.financeservices.model.FixedDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedDepositRepository extends JpaRepository<FixedDeposit,Long>
{
}
