package com.example.monitoreo.repository;

import com.example.monitoreo.model.Monitoreo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MonitoreoRepository extends JpaRepository<Monitoreo, Integer> {

}
