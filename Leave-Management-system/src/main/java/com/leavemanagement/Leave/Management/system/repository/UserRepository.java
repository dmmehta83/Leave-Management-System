package com.leavemanagement.Leave.Management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagement.Leave.Management.system.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);
}
