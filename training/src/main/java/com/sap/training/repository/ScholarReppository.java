package com.sap.training.repository;

import com.sap.training.model.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarReppository extends JpaRepository<Scholar, Long> {

    List<Scholar> findByBatch(String batch);

}
