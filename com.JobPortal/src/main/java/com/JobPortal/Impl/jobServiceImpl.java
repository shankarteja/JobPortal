package com.JobPortal.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.JobPortal.Entinty.Job;
import com.JobPortal.Exception.ResouceNotFoundException;
import com.JobPortal.repo.jobRepository;
import com.JobPortal.service.JobService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class jobServiceImpl implements JobService {

	public jobRepository jobRepository;

	@Override
	public Job createNewjob(Job job) {
		Job savednewJob = jobRepository.save(job);
		return savednewJob;

	}

	@Override
	public Job getJobId(Long jobId) {
		Job getJobId = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResouceNotFoundException("job is does't exits" + jobId));
		return getJobId;
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> getallJob = jobRepository.findAll();
		return getallJob;

	}

	@Override
	public Job updateJobs(Long jobId, Job job) {
		Job getJobId = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResouceNotFoundException("job is does't exits" + jobId));
		getJobId.setTitle(job.getTitle());
		getJobId.setDescription(job.getDescription());
		getJobId.setMaxSalary(job.getMaxSalary());
		getJobId.setMinSalary(job.getMinSalary());
		getJobId.setGender(job.getGender());
		Job saveJob = jobRepository.save(getJobId);
		return saveJob;
	}

	@Override
	public void deleteId(Long jobId) {
		Job getJobId = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResouceNotFoundException("job is does't exits" + jobId));
		jobRepository.delete(getJobId);
		
	}

}
