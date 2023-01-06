package com.example.hazlecastEmployee.controller;

import com.example.hazlecastEmployee.entity.HazlecastEmployee;
import com.example.hazlecastEmployee.generic.HubResponse;
import com.example.hazlecastEmployee.service.HazlecastEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hazlecastEmployee")
public class HazlecastEmployeeController {
  @Autowired
  private HazlecastEmployeeServiceImpl hazlecastEmployeeService;

  @GetMapping
  public Iterable<HazlecastEmployee> getAllHazlecastEmployees() {
    return hazlecastEmployeeService.getAllHazlecastEmployees();
  }

  @GetMapping("/{id}")
  public HubResponse<HazlecastEmployee> getHazlecastEmployeeById(@PathVariable("id") int id) {
    return hazlecastEmployeeService.findHazlecastEmployeeById(id);
  }

  @PostMapping
  public HazlecastEmployee addHazlecastEmployee(@RequestBody HazlecastEmployee hazlecastEmployee) {
    return hazlecastEmployeeService.addHazlecastEmployee(hazlecastEmployee);
  }

  @DeleteMapping("/{id}")
  public String deleteHazlecastEmployeeById(@PathVariable("id") int id) {
    return hazlecastEmployeeService.deleteHazlecastEmployee(id);
  }

  @PutMapping("/update/{id}")
  public HubResponse<HazlecastEmployee> updateHazlecastEmployee(@PathVariable("id") int id,@RequestBody HazlecastEmployee hazlecastEmployee) {
    HubResponse<HazlecastEmployee> employeeHubResponse =  hazlecastEmployeeService.updateHazlecastEmployeeById(id,hazlecastEmployee);
    return employeeHubResponse;
  }
}
