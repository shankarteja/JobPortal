package com.JobPortal.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JobPortal.Entinty.Job;
import com.JobPortal.Impl.jobServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/jobs")
public class JobController {

	public jobServiceImpl jobServiceImpl;

	@PostMapping
	public ResponseEntity<Job> addNewJob(@RequestBody Job job) {
		Job savedNewJob = jobServiceImpl.createNewjob(job);
		return new ResponseEntity<Job>(savedNewJob, HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<Job> getJobId(@PathVariable("id") Long jobId) {
		Job savedNewGetJobId = jobServiceImpl.getJobId(jobId);
		return new ResponseEntity<Job>(savedNewGetJobId, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Job>> getAllJobs() {
		List<Job> getAllJobs = jobServiceImpl.getAllJobs();
		return new ResponseEntity<List<Job>>(getAllJobs, HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<Job> updatJobs(@PathVariable("id") Long jobId, @RequestBody Job job) {
		Job savedNewGetJobId = jobServiceImpl.updateJobs(jobId, job);
		return new ResponseEntity<Job>(savedNewGetJobId, HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteJob(@PathVariable("id") Long jobId) {
		jobServiceImpl.deleteId(jobId);
		return ResponseEntity.ok("deleted job Id successfully..........!" + jobId);

	}

}
