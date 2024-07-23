package com.AdsApp.AdsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdsApp.AdsApp.entity.Production;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
	
}
