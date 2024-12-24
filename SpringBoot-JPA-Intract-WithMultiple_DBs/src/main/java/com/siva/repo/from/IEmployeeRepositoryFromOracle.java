package com.siva.repo.from;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.siva.model.from.EmployeeFrom;

import jakarta.persistence.LockModeType;

public interface IEmployeeRepositoryFromOracle extends JpaRepository<EmployeeFrom, Integer>
{
	 @Lock(LockModeType.PESSIMISTIC_READ)  // Optional: If you want to lock while reading
	    List<EmployeeFrom> findAll();

}
