package com.siva.repo.to;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.model.to.EmployeeTo;

public interface IEmployeeMySqlToRepository extends JpaRepository<EmployeeTo, Integer>
{


}
