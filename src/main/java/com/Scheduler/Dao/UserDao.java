package com.Scheduler.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Scheduler.Models.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
