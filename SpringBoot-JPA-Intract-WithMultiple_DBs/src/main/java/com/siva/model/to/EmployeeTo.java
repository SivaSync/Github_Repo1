package com.siva.model.to;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@Entity
//@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="EMP")
@Data
public class EmployeeTo
{
	public EmployeeTo
	(int i, String string, String string2, int j, int k, String string3, int l) {
		
	}
	
	public EmployeeTo(int i, String string, String string2, int j, int k, LocalDate now, int l) {
		// TODO Auto-generated constructor stub
	}

	@Id
//	@SequenceGenerator(name="gen1",sequenceName = "emp_seq_gen",initialValue = 1000,allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer empno;
	
	@Column(length=20)
	private String ename;
	
	private Double sal;
	
	@Column(length=20)
	private String job;
	//@NonNull
	private Integer deptno;
	
	private LocalDate hiredata;
	
	private Float comm;

	
	
	
}
