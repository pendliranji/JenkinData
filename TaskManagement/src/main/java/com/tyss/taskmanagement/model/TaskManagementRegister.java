package com.tyss.taskmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="task_management")
@Data
public class TaskManagementRegister {
	@Column(name="task_id")
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	@Column(name="first_name")
	private String first_Name;
	@Column(name="last_name")
	private String last_Name;
	private long contact;
	@NotNull
	@Column(name="user_email")
	private String user_Email;
	@Column(name="user_Password")
	private String user_Password;
	@Column(name="confirm_Password")
	private String user_Confirm_Password;
	
}
