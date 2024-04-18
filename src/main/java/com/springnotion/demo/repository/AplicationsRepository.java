package com.springnotion.demo.repository;

import com.springnotion.demo.model.Aplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicationsRepository extends JpaRepository<Aplications, Long> {
}
