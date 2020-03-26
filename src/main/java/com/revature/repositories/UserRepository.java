package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

/**
 * UserRepository which extends the JpaRepository.
 * This repository handles our various queries.
 * 
 * @author Adonis Cabreja
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/**
	 * Custom query that uses the @Query annotation to select a user by isDriver.
	 * 
	 * @param isDriver represents if a user is a driver or rider.
	 * @return Check {@link com.revature.services.impl.UserServiceImpl}
	 */
	
	public List<User> getUserByDriver(boolean driver);
	
	/**
	 * Custom query that uses the @Query annotation to select a user by username.
	 * 
	 * @param username represents the user's username.
	 * @return Check {@link com.revature.services.impl.UserServiceImpl}
	 */
	
	public List<User> getUserByUserName(String username);
	
	/**
	 * Custom query that uses the @Query annotation to select a user by isDriver and location.
	 * 
	 * @param isDriver represents if a user is a driver or rider.
	 * @param location represents the batch's location.
	 * @return Check {@link com.revature.services.impl.UserServiceImpl}
	 */
	
	public List<User> getUserByDriverAndBatch_BatchLocation(boolean driver, String location);
	
	@Query("select u from User u where u.driver = true and u.active = true and u.acceptingRides = true")
	public List<User> getActiveDrivers();
	
}
