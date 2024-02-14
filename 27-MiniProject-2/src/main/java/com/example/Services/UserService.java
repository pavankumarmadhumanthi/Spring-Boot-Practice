package com.example.Services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.Bindings.LoginForm;
import com.example.Bindings.RegisterForm;
import com.example.Bindings.ResetPwd;
import com.example.Entities.City;
import com.example.Entities.State;
import com.example.Entities.User;

@Service
public interface UserService {
	public String saveUser(RegisterForm registerfrom);
	public User loginUser(LoginForm loginform);
	public User updatePwd(ResetPwd resetpwd);
	public String generatePwd();
	public Map<Integer,String> getCountries();
	public Map<Integer,String> getStates(Integer cid);
	public Map<Integer,String> getCities(Integer stateid);

}
