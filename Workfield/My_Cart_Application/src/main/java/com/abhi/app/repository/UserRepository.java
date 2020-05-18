package com.abhi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abhi.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	@Query("SELECT user FROM User user WHERE user.userName=:userName "
			+ "AND user.password=:password")
	public User fetchUserByUserNameAndPassword(@Param("userName") String userName, 
			@Param("password") String password );

}
