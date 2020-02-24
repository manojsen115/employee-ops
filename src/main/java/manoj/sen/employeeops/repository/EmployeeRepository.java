package manoj.sen.employeeops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import manoj.sen.employeeops.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}
