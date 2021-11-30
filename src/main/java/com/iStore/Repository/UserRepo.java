package com.iStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iStore.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByEmail(String userEmail);
}
