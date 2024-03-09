package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int count = 0;
	static {
		users.add(new User(++count,"Vijay",LocalDate.now().minusYears(50)));
		users.add(new User(++count,"Ajith",LocalDate.now().minusYears(45)));
		users.add(new User(++count,"Surya",LocalDate.now().minusYears(40)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		User user = users.stream().filter(predicate).findFirst().orElse(null); 
		return user;
	}
	
	public User saveUser(User user) {
		user.setId(++count);
		users.add(user);
		return user; 
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
