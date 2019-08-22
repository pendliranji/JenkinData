package com.tyss.taskmanagement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.taskmanagement.dao.TaskManagementDao;
import com.tyss.taskmanagement.model.CreateTask;
import com.tyss.taskmanagement.model.TaskManagementRegister;
import com.tyss.taskmanagement.repository.TaskRepository;

@RestController
@RequestMapping("/rest")
public class TaskManagementRestController {
	@Autowired
	private TaskManagementDao dao;

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private TaskRepository repo;

	@PostMapping(path = "/RegisterTaskUsers")
	@Transactional
	public ResponseEntity<?> save(@RequestBody TaskManagementRegister task) {
		ResponseEntity<?> re = new ResponseEntity<>(repo.save(task), HttpStatus.OK);
		return re;
	}

	@PostMapping(path = "/checkLogin")
	public ResponseEntity<String> checkLogin(@RequestBody TaskManagementRegister task, HttpServletRequest req) {
		HttpSession ses = req.getSession();
		int count = dao.getCredentialsByEmail(task.getUser_Email(), task.getUser_Password());
		ResponseEntity<String> re = null;
		if (count == 1) {
			ses.setAttribute("email", task.getUser_Email());
			re = new ResponseEntity<String>("Login success", HttpStatus.OK);
		} else {
			re = new ResponseEntity<>("Login failed", HttpStatus.FAILED_DEPENDENCY);
		}
		return re;
	}

	@PostMapping(path = "/createTask")
	public ResponseEntity<String> save(@RequestBody CreateTask task, HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("${spring.mail.username}");
		mailMessage.setTo(task.getEmail());
		mailMessage.setSubject(task.getCategory());
		mailMessage.setText(task.getDescription());
		mailSender.send(mailMessage);
		String mail = (String) ses.getAttribute("email");
		task.setAssignedBy(mail);
		dao.saveCreateTask(task);
		ResponseEntity<String> re = new ResponseEntity<>("success", HttpStatus.OK);
		return re;
	}

	@GetMapping(path = "/assignedToMe")
	public List<CreateTask> assignedTasksToMe(HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		String mail = (String) ses.getAttribute("email");
		System.out.println(mail+"----------------------------------------------");
		return dao.getTaskByEmail(mail);

	}

	@GetMapping(path = "/todo")
	public List<CreateTask> assignedToMeToDo(HttpServletRequest req) {
		HttpSession ses = req.getSession(false);
		String Email = (String) ses.getAttribute("email");

		return dao.assignedToMeToDo(Email);
	}
	
	@GetMapping(path = "/assignByMe")
	public List<CreateTask> assignTasksByMe(HttpServletRequest req, Map<String, Object> map) {
		HttpSession ses = req.getSession(false);
		String mail = (String) ses.getAttribute("email");

		return dao.assignedByMe(mail);
		
	}
	@GetMapping(path = "/inprogress")
	public List<CreateTask> assignedToMeInProgress(HttpServletRequest req, Map<String, Object> map) {
		HttpSession ses = req.getSession(false);
		String mail = (String) ses.getAttribute("email");

		return dao.assignedToMeInProgress(mail);
	}
	@GetMapping(path = "/completed")
	public List<CreateTask> assignedToMeCompleted(HttpServletRequest req, Map<String, Object> map) {
		HttpSession ses = req.getSession(false);
		String mail = (String) ses.getAttribute("email");

		return dao.assignedToMeCompleted(mail);
	}
	@GetMapping(path = "/blocked")
	public 	List<CreateTask> assignedToMeInBlocked(HttpServletRequest req, Map<String, Object> map) {
		HttpSession ses = req.getSession(false);
		String mail = (String) ses.getAttribute("email");

		return dao.assignedToMeBlocked(mail);
	}

	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "Logout";
	}


}
