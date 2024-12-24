package com.siva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.siva.entity.Employee;

import jakarta.transaction.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from emp1 where status='InActive'",nativeQuery = true)
	public List<Employee> inActiveEmployeeData();
	
	@Transactional
	@Modifying
	@Query(value="update emp1 set status='active' where empno=:empno",nativeQuery = true)
	public void updateInActiveToActve(int empno);
	
	@Transactional
	@Modifying
	@Query(value="delete from emp1 where empno = ?",nativeQuery =true)
	public void deletePermnentEmployyeById(int empno);
	
	@Query(value="from Employee where job like :job ")
	public List<Employee> findByJobLike(@Param("job") String job);
	
	@Query(value="from Employee where ename like :c")
	public List<Employee> LikeOpreatorEname(@Param("c") String c);
	
	@Query(value="from Employee where ename like :ename and job like :job")
	public List<Employee> ShowEmployeeLikeJodAndEname(@Param("ename") String ename,
			                                          @Param("job")  String job);
	
	//select * from emp1 where sal>=3000 and sal<=5000;
	@Query("from Employee where sal >= :start and sal <= :end")
	public List<Employee> getSalaryBetweenEmployeeData(@Param("start") Double start, @Param("end") Double end);
	
	/*//select * from emp1 where
	   ename like 'C%' or 
	   job like 'J%' or
       deptno like '20' or
	   sal like '800'
	*/@Query("from Employee where ename like :ename or job like :job or deptno=:deptno or sal = :sal ")
	public List<Employee> getAllFieldsOfLikeOperator(@Param("ename") String ename,
			                                         @Param("job") String job,
			                                         @Param("deptno") Integer deptno,
			                                         @Param("sal") Double sal);
	
}
