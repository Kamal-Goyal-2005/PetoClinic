package com.caltech.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.caltech.clinic.pogo.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	String sql = "select user.pwd from User user where user.name=?1";
	
	
	String sql2 = "select user.pwd from User user where user.name=?1 and user.name='admin'";

	@Query(sql)
	public String validateuser(String name);
	
	@Query(sql2)
	public String checkAdmin(String name);
}
