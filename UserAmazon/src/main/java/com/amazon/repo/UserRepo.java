package com.amazon.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.amazon.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
	
	User save(User user);
	
	User findByUserId(String user);
	
		
}
