package com.tyss.taskmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class CreateTask {

	@Id
	@GeneratedValue
	Integer id;
	@Column(name = "descript")
	String description;
	String assignTo;
	@Column(name = "s_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date s_date=new Date();
	@Column(name = "date_column")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date date;
	@Column(name = "catgory")
	String category;
	@Column(name = "addcatgory")
	String addCategory;
	String priority;
	@Column(name = "email_col")
	private String email;
	private String assignedBy;
	
	int status=1;

}
