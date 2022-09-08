package com.exam.spring.model;

import lombok.Data;

@Data
public class PointDTO {
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	private double avg;
	
}
