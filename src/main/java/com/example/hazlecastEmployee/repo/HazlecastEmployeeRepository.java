package com.example.hazlecastEmployee.repo;

import com.example.hazlecastEmployee.entity.HazlecastEmployee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HazlecastEmployeeRepository extends MongoRepository<HazlecastEmployee,Integer> {
}
