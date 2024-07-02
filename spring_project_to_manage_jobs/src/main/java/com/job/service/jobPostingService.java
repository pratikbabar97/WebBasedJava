package com.job.service;

import java.util.List;

import com.job.dtos.ApiResponse;
import com.job.dtos.jobDto;
import com.job.entities.JobPosting;

public interface jobPostingService {

	List<JobPosting> getAllPostings();

	JobPosting postingNewjob(JobPosting jobposting);

	ApiResponse updatejob(Long id, jobDto job);

	ApiResponse deletingJob(Long id);

}
