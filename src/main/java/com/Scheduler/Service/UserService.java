package com.Scheduler.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Scheduler.Dao.UserDao;
import com.Scheduler.Models.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	Logger log = LoggerFactory.getLogger(UserService.class);

	// Schedule a job to add object in DW in 5 second
	@Scheduled(fixedRate = 5000)
	public void add2DBJob() {
		User user = new User();
		user.setName("user" + new Random().nextInt(374483));
		userDao.save(user);
		System.out.println("Add service call in" + new Date().toString());
	}

	@Scheduled(cron = "0/15 * * * * *")
	public void fatchedDBJob() {
		List<User> user = userDao.findAll();
		System.out.println("fatched service call in" + new Date().toString());
		System.out.println("No of record fatched :" + user.size());
		log.info("users:{}", user);

	}

}
