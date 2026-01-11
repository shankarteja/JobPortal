package com.JobPortal.service;

import java.util.List;

import com.JobPortal.Entinty.Job;

public interface JobService {

	Job createNewjob(Job job);
	
	Job getJobId(Long jobId);
	
	List<Job>getAllJobs();
	
	Job updateJobs(Long jobId,Job job);
	
	void deleteId(Long jobId);

}
