package com.examportal.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examportal.examportal.models.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	 @Query("SELECT u FROM Users u WHERE u.username =:n")
	 public Users findByUserName(@Param("n") String username);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Users u WHERE u.id =:a")
	public void deleteByUserName(@Param("a") Long userid);
	
	
}
