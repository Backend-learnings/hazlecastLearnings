package com.example.hazlecastEmployee.service;

import com.example.hazlecastEmployee.entity.HazlecastEmployee;
import com.example.hazlecastEmployee.generic.HubResponse;
import com.example.hazlecastEmployee.generic.HubStatusCode;
import com.example.hazlecastEmployee.repo.HazlecastEmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
@Slf4j
@Service
public class HazlecastEmployeeServiceImpl {

  @Autowired
  private HazlecastEmployeeRepository hazlecastEmployeeRepository;

  @Cacheable(value = "hazlecastEmployee")
  public Iterable<HazlecastEmployee> getAllHazlecastEmployees() {
    log.info("Get all the Hazlecast Employees ");
    return hazlecastEmployeeRepository.findAll();
  }

  @CacheEvict(value = "hazlecastEmployee")
  public String deleteHazlecastEmployee(int id) {
    log.info("product deleted with the id : {}",id);
    try {
      hazlecastEmployeeRepository.deleteById(id);
    } catch (Exception e) {
      log.info("Some problem while deleting the Redis Employee : {}"+ e);
    }
    return "Deleted Successfully!";
  }

  @Cacheable(value = "hazlecastEmployee", key = "#id")
  public HubResponse<HazlecastEmployee> findHazlecastEmployeeById(int id) {
    log.info("Finding product with respect to Id : {}", id);
    Optional<HazlecastEmployee> option = hazlecastEmployeeRepository.findById(id);
    HubResponse<HazlecastEmployee> employeeHubResponse = new HubResponse<>();
    if(option.isPresent()) {
      employeeHubResponse.setResponseObject(option.get());
      employeeHubResponse.setStatus(HubStatusCode.SUCCESS);
    } else {
      employeeHubResponse.setStatus(HubStatusCode.BAD_REQUEST);
    }

    return employeeHubResponse;
  }

  @CachePut(value = "hazlecastEmployee", key = "#id")
  public HubResponse<HazlecastEmployee> updateHazlecastEmployeeById(int id, HazlecastEmployee employee) {
    log.info("update the product with respect to id: {}", id);
    HazlecastEmployee hazlecastEmployee = new HazlecastEmployee();
    BeanUtils.copyProperties(employee, hazlecastEmployee);
    hazlecastEmployee.setId(id);
    HubResponse<HazlecastEmployee> resp = new HubResponse<>();

    HazlecastEmployee hhazlecastEmployee = hazlecastEmployeeRepository.save(hazlecastEmployee);

    resp.setResponseObject(hhazlecastEmployee);
    resp.setStatus(HubStatusCode.SUCCESS);

    return resp;
  }

  @CachePut(value = "hazlecastEmployee")
  public HazlecastEmployee addHazlecastEmployee(HazlecastEmployee redisEmployee) {
    log.info("HazlecastEmployee has been added into the database: {}", redisEmployee);
    return hazlecastEmployeeRepository.save(redisEmployee);
  }

}
