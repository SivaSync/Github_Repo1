package com.siva.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("deprecation")
@NoArgsConstructor
@Entity
@Table(name="EMP1")
@Data
@SQLDelete(sql="update emp1 set status='InActive' where empno=?")
@Where(clause = "status <> 'InActive'")
public class Employee 
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_seq_gen",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer empno;
	//@NonNull
	@Column(length=20)
	private String ename;
	//@NonNull
	private Double sal;
	//@NonNull
	@Column(length=20)
	private String job;
	//@NonNull
	private Integer deptno = 40;
	
	@Column(length=15)
	private String status;
}
