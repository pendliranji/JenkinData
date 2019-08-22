package com.tyss.taskmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tyss.taskmanagement.model.TaskManagementRegister;
@Repository
public interface TaskRepository extends CrudRepository<TaskManagementRegister	, Integer> {

}
