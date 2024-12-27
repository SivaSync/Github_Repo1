package com.siva;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import com.siva.model.from.EmployeeFrom;
import com.siva.model.to.EmployeeTo;
import com.siva.repo.from.IEmployeeRepositoryFromOracle;
import com.siva.repo.to.IEmployeeMySqlToRepository;
import com.siva.service.EmployeeServiceMultiDBsImpl;

public class EmployeeServiceMultiDBsImplTest {

    @Mock
    private IEmployeeRepositoryFromOracle fromRepo;

    @Mock
    private IEmployeeMySqlToRepository toRepo;

    @InjectMocks
    private EmployeeServiceMultiDBsImpl employeeService;

    @BeforeEach
    void setUp() {
            
    }
     public EmployeeServiceMultiDBsImplTest() {
		// TODO Auto-generated constructor stub
    	 MockitoAnnotations.openMocks(this);
	}
	@Test
	void testGetAllEmployeesOracle() {
	    // Arrange
	    EmployeeFrom emp1 = new EmployeeFrom(1, "John", "Manager", 5000, 10, null, 1000);
	    EmployeeFrom emp2 = new EmployeeFrom(2, "Jane", "Developer", 4000, 20, null, 2000);
	
	    List<EmployeeFrom> employeeList = Arrays.asList(emp1, emp2);
	    when(fromRepo.findAll()).thenReturn(employeeList);
	
	    // Act
	    List<EmployeeFrom> result = employeeService.getAllEmployeesOracle();
	
	    // Assert
	    //assertNotNull(result);
	    assertEquals(2, result.size());
	   // assertEquals("John", result.get(0).getEname());
	    verify(fromRepo, times(1)).findAll();  // Ensure the method was called once
	}
	
	@Test
	@Transactional
	void testTransferEmployeeData() throws InterruptedException {
	    // Arrange
	    EmployeeFrom emp1 = new EmployeeFrom(1, "John", "Manager", 5000, 10, "2022-01-01", 1000);
	    EmployeeFrom emp2 = new EmployeeFrom(2, "Jane", "Developer", 4000, 20, "2023-02-01", 2000);
	
	    List<EmployeeFrom> employeeList = Arrays.asList(emp1, emp2);
	    when(fromRepo.findAll()).thenReturn(employeeList);
	
	    // Act
	    employeeService.transferEmployeeData();
	
	    // Assert
	    verify(fromRepo, times(1)).findAll();  // Verify that the source repo's findAll was called
	    verify(toRepo, times(2)).save(any(EmployeeTo.class));  // Verify that two employees were saved to MySQL
	}
	
		@Test
		void testInsertMultipleEmployeeInMySQL() {
		    // Arrange
		    EmployeeTo emp1 = new EmployeeTo(1, "John", "Manager", 5000, 10, LocalDate.now(), 1000);
		    EmployeeTo emp2 = new EmployeeTo(2, "John", "Manager", 5000, 10, LocalDate.now(), 1000);
		  	
		    List<EmployeeTo> employeeList = Arrays.asList(emp1, emp2);
		    when(toRepo.saveAll(employeeList)).thenReturn(employeeList);
		
		    // Act
		    String result = employeeService.insertEmployeeToInMySQl(employeeList);
		
		    // Assert
		    assertTrue(result.contains("Successfully"));
		    assertTrue(result.contains("Empno"));
		    verify(toRepo, times(1)).saveAll(employeeList);  // Verify saveAll is called once
		}
		
	@Test
	void testRegisterEmployeeOracle() {
	    // Arrange
		EmployeeFrom emp = new EmployeeFrom(1, "John", "Manager", 5000, 10, LocalDate.now(), 1000);
	    EmployeeFrom emp1 = new EmployeeFrom("John", 5000.0, "Manager", 10);
	    when(fromRepo.save(emp1)).thenReturn(emp);
	
	    // Act
	    String result = employeeService.registerEmployeeOracle(emp);
	
	    // Assert
	    assertTrue(result.contains("Successfully register"));
	    //assertTrue(result.contains("Empno"));
	    verify(fromRepo, times(1)).save(emp);  // Verify that save was called on Oracle repo
	}
	
//	@Test
//	void testRegisterEmployeeMysql() {
//	    // Arrange
//	    EmployeeTo emp = new EmployeeTo(1, "John", "Manager", 5000, 10, "2022-01-01", 1000);
//	    when(toRepo.save(emp)).thenReturn(emp);
//	
//	    // Act
//	    String result = employeeService.RegisterEmployeeMysql(emp);
//	
//	    // Assert
//	    assertTrue(result.contains("Find and Register Successfully"));
//	    assertTrue(result.contains("Empnos"));
//	    verify(toRepo, times(1)).save(emp);  // Verify that save was called on MySQL repo
//	}
}
