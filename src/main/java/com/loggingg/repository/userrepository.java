package com.loggingg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loggingg.entity.userentity;


public interface userrepository extends JpaRepository<userentity, Long>{

	Optional <userentity> findByUsername(String username);
	
}
