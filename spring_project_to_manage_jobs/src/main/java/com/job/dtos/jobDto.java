package com.job.dtos;

import java.time.LocalDate;

import com.job.entities.JobTitle;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class jobDto {
	
	private JobTitle jobTitle;
	private String Location;
	private LocalDate resolutionDate;

}
