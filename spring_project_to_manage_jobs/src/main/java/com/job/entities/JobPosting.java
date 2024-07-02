package com.job.entities;

import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "job_posting")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "job_title",length = 50)
	private JobTitle jobTitle;
	
	@Column(name = "company_name",length = 50)
	private String companyName;
	
	@Column(length = 50)
	private String Location;
	
	@Column(length = 50)
	private String description;
	
	private Double requirements;
	
	@Column(name="emp_salary")
	private Double salary;
	
	@UpdateTimestamp
	@Column(name="posting_date")
	private LocalDate postingDate;
	
	private LocalDate resolutionDate;
	

}
