package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo userrepo;

	public void saveUser() {

		UserPk userPk = new UserPk(101, 9346543L);

		User user = new User("Pavan", 34554.00, userPk);

		userrepo.save(user);

	}

}
