package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entities.JobPosting;

public interface jobRepository extends JpaRepository<JobPosting, Long> {

}
