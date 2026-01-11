package com.JobPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JobPortal.Entinty.Job;


public interface jobRepository extends JpaRepository<Job, Long> {
	
	

}
