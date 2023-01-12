package com.examportal.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.examportal.models.Roles;
@Repository
public interface RoleRepository extends JpaRepository<Roles, Long>{

}
