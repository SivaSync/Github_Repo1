package com.siva.model.from;

import java.time.LocalDate;

import org.hibernate.annotations.DialectOverride.SQLInsert;
import org.hibernate.annotations.DialectOverride.SQLInserts;
import org.hibernate.annotations.DialectOverride.SQLUpdate;
import org.hibernate.annotations.DialectOverride.SQLUpdates;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="EMP") //
@Data
public class EmployeeFrom
{
	@Id
//	@SequenceGenerator(name="gen1",sequenceName = "emp1_seq_gen",initialValue = 1000,allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer empno;
	@NonNull
	@Column(length=20)
	private String ename;
	@NonNull
	private Double sal;
	@NonNull
	@Column(length=20)
	private String job;
	@NonNull
	private Integer deptno;
	
    private LocalDate hiredata;
	
	private Float comm;
	
}
