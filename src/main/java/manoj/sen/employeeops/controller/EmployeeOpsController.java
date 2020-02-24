package manoj.sen.employeeops.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import manoj.sen.employeeops.repository.EmployeeRepository;
import manoj.sen.employeeops.model.*;

@CrossOrigin//(origins="http://localhost:4200/*")
@RestController
public class EmployeeOpsController {
	@Autowired
	private EmployeeRepository employeeRepository;
	{System.out.println("this is inside controller");}
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@GetMapping("/getAllEmployeesByIds/{ids}")
	public List<Employee> getAllEmployeesByIds(@PathVariable(value="ids") String ids) {
		String temp[]=ids.split(",");
		List<Long> myIds=new ArrayList<Long>();
		//Long l=temp[0];
		for(String t:temp) {
			myIds.add(Long.parseLong(t));
		}
		System.out.println(employeeRepository.findAllById(myIds));
		return employeeRepository.findAllById(myIds);
	}
	@GetMapping("/getEmployeeById/{id}")
	public Optional<Employee> getEmployeeByIdold(@PathVariable(value="id") Long id) 
	throws Exception {
		System.out.println("Inside getEmployeeById"+id);
		System.out.println(employeeRepository.getOne(id));
		return employeeRepository.findById(id);
	}
	@GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws Exception {
        Employee employee = employeeRepository.findById(employeeId)
          .orElseThrow(() -> new Exception("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		return employeeRepository.save(employee);
	}
	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable(value="id") Long id,@RequestBody Employee updated_Employee) throws Exception
	{
		Employee e= employeeRepository.findById(id).orElseThrow(()->new Exception("id not found"));
		e.setEmail(updated_Employee.getEmail());
		e.setAddress(updated_Employee.getAddress());
		e.setDate(updated_Employee.getDate());
		e.setFirst_name(updated_Employee.getFirst_name());
		e.setLast_name(updated_Employee.getLast_name());
		e.setMid_name(updated_Employee.getMid_name());
		return employeeRepository.save(e);
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id") Long id) throws Exception {
		 employeeRepository.findById(id).orElseThrow(()->new Exception("employee not found"));
		 employeeRepository.deleteById(id);
		 return id+" id employee has been deleted";
	}
	@DeleteMapping("/deleteAllByIds/{ids}")
	public String deleteAllByIds(@PathVariable(value="ids") String ids) {
		String temp[]=ids.split(",");
		List<Long> myIds=new ArrayList<Long>();
		for(String t:temp) {
			myIds.add(Long.parseLong(t));
		}
		System.out.println(employeeRepository.findAllById(myIds));
		employeeRepository.deleteInBatch(employeeRepository.findAllById(myIds));
		return "deleted all ids";
	}
	@DeleteMapping("/deleteAllEmployees")
	public String deleteAllEmployees(){
		employeeRepository.deleteAll();
		return "All Employees deleted";
	}

}
