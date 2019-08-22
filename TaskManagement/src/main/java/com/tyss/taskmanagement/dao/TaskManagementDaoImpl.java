package com.tyss.taskmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tyss.taskmanagement.model.CreateTask;
import com.tyss.taskmanagement.model.TaskManagementRegister;
import com.tyss.taskmanagement.repository.CreateTaskRepository;
import com.tyss.taskmanagement.repository.TaskRepository;

@SuppressWarnings("unused")
@Service
@Transactional
public class TaskManagementDaoImpl implements TaskManagementDao {

	@Autowired
	private TaskRepository repository;
	@Autowired
	private CreateTaskRepository repo;
	@Autowired
	private JdbcTemplate jt;

	@Override
	public void saveTask(TaskManagementRegister task) {
		repository.save(task);
	}

	@Override
	public int getCredentialsByEmail(String email, String pass) {
		String sql = "select count(*) from task_management where user_email=? and user_Password=?";
		return jt.queryForObject(sql, new Object[] { email, pass }, Integer.class);
	}

	@Override
	public void saveCreateTask(CreateTask task) {
		repo.save(task);
	}

	/* assigned to me all tasks */
	@Override
	public List<CreateTask> getTaskByEmail(String email) {
		return  jt.query("select * from create_task where email_col=?", new Object[] { email },
				new RowMapper<CreateTask>() {
					public CreateTask mapRow(ResultSet rs, int row) throws SQLException {
						CreateTask ct = new CreateTask();
						ct.setId(rs.getInt(1));
						ct.setAssignTo(rs.getString(3));
						ct.setAddCategory(rs.getString(4));
						ct.setCategory(rs.getString(5));
						ct.setDate(rs.getDate(6));
						ct.setDescription(rs.getString(7));
						ct.setEmail(rs.getString(8));
						ct.setPriority(rs.getString(9));
						ct.setS_date(rs.getDate(10));
						return ct;
					}
				});
	}

	@Override
	public List<CreateTask> assignedToMeToDo(String email) {
		return  jt.query("select * from create_task where email_col=? and status=1",
				new Object[] { email }, new RowMapper<CreateTask>() {
					public CreateTask mapRow(ResultSet rs, int row) throws SQLException {
						CreateTask ct = new CreateTask();
						ct.setId(rs.getInt(1));
						ct.setAssignTo(rs.getString(3));
						ct.setAddCategory(rs.getString(4));
						ct.setCategory(rs.getString(5));
						ct.setDate(rs.getDate(6));
						ct.setDescription(rs.getString(7));
						ct.setEmail(rs.getString(8));
						ct.setPriority(rs.getString(9));
						ct.setS_date(rs.getDate(10));
						return ct;
					}
				});
	}

	@Override
	public List<CreateTask> assignedByMe(String email) {

		return jt.query("select * from create_task where assigned_by=?", new Object[] { email },
				new RowMapper<CreateTask>() {
					public CreateTask mapRow(ResultSet rs, int row) throws SQLException {
						CreateTask ct = new CreateTask();
						ct.setId(rs.getInt(1));
						ct.setAssignTo(rs.getString(3));
						ct.setAddCategory(rs.getString(4));
						ct.setCategory(rs.getString(5));
						ct.setDate(rs.getDate(6));
						ct.setDescription(rs.getString(7));
						ct.setEmail(rs.getString(8));
						ct.setPriority(rs.getString(9));
						ct.setS_date(rs.getDate(10));
						return ct;
					}
				});
	}

	@Override
	public Optional<CreateTask> getoneById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<CreateTask> assignedToMeInProgress(String email) {

		return  jt.query("select * from create_task where status=2 and email_col=?",
				new Object[] { email }, new RowMapper<CreateTask>() {
					public CreateTask mapRow(ResultSet rs, int row) throws SQLException {
						CreateTask ct = new CreateTask();
						ct.setId(rs.getInt(1));
						ct.setAssignTo(rs.getString(3));
						ct.setAddCategory(rs.getString(4));
						ct.setCategory(rs.getString(5));
						ct.setDate(rs.getDate(6));
						ct.setDescription(rs.getString(7));
						ct.setEmail(rs.getString(8));
						ct.setPriority(rs.getString(9));
						ct.setS_date(rs.getDate(10));
						return ct;
					}
				});
	}

	@Override
	public List<CreateTask> assignedToMeCompleted(String email) {

		return  jt.query("select * from create_task where status=3 and email_col=?",
				new Object[] { email }, new RowMapper<CreateTask>() {
					public CreateTask mapRow(ResultSet rs, int row) throws SQLException {
						CreateTask ct = new CreateTask();
						ct.setId(rs.getInt(1));
						ct.setAssignTo(rs.getString(3));
						ct.setAddCategory(rs.getString(4));
						ct.setCategory(rs.getString(5));
						ct.setDate(rs.getDate(6));
						ct.setDescription(rs.getString(7));
						ct.setEmail(rs.getString(8));
						ct.setPriority(rs.getString(9));
						ct.setS_date(rs.getDate(10));
						return ct;
					}
				});
	}

	@Override
	public List<CreateTask> assignedToMeBlocked(String email) {
		return  jt.query("select * from create_task where status=4 and email_col=?",
				new Object[] { email }, new RowMapper<CreateTask>() {
					public CreateTask mapRow(ResultSet rs, int row) throws SQLException {
						CreateTask ct = new CreateTask();
						ct.setId(rs.getInt(1));
						ct.setAssignTo(rs.getString(3));
						ct.setAddCategory(rs.getString(4));
						ct.setCategory(rs.getString(5));
						ct.setDate(rs.getDate(6));
						ct.setDescription(rs.getString(7));
						ct.setEmail(rs.getString(8));
						ct.setPriority(rs.getString(9));
						ct.setS_date(rs.getDate(10));
						return ct;
					}
				});
	}

}
