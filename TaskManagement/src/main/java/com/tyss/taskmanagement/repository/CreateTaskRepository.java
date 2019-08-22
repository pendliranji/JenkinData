package com.tyss.taskmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.tyss.taskmanagement.model.CreateTask;

public interface CreateTaskRepository extends CrudRepository<CreateTask, Integer> {

}
