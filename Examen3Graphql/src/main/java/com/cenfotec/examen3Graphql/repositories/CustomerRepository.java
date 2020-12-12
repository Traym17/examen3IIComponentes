package com.cenfotec.examen3Graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen3Graphql.entities.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

