package com.picpaydesafiobackend.repositories;

import com.picpaydesafiobackend.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{

}
