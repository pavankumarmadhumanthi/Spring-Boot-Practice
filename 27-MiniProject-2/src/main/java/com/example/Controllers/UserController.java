package com.example.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bindings.LoginForm;
import com.example.Bindings.RegisterForm;
import com.example.Bindings.ResetPwd;
import com.example.Entities.User;
import com.example.Services.UserServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserServiceImp userservice;
	
	@Autowired
	private HttpSession session;

	@GetMapping("/loginform")
	public String showLoginForm(Model model) {
		model.addAttribute("loginform", new LoginForm());
		return "login";
	}

	@GetMapping("/registerform")
	public String showRegisterForm(Model model) {
		Map<Integer, String> countries = userservice.getCountries();
		model.addAttribute("registerform", new RegisterForm());
		model.addAttribute("countries", countries);
		return "register";
	}

	@GetMapping("/resetpwdform")
	public String showResetPwdForm(Model model) {
		ResetPwd resetPwd = new ResetPwd();
		resetPwd.setId((Integer)session.getAttribute("id"));
		model.addAttribute("resetpwdform",resetPwd);
		return "resetpwd";
	}
	@GetMapping("/states")
	@ResponseBody
	public Map<Integer, String> showStates(@RequestParam("cid")Integer Cid) {
		return userservice.getStates(Cid);	
	}
	@GetMapping("/cities")
	@ResponseBody
	public Map<Integer, String> showCities(@RequestParam("sid")Integer Sid) {
		return userservice.getCities(Sid);
	}
	
	@PostMapping("/registerformdata")
	public String userRegister(RegisterForm registerform,Model model) {
		String msg = userservice.saveUser(registerform);
		Map<Integer, String> countries = userservice.getCountries();
		model.addAttribute("countries",countries);
		model.addAttribute("msg",msg);
		return "redirect:/registerform";
	}
	@PostMapping("/loginformdata")
	public String userLoginValidition(LoginForm loginformdata,Model model) {
		User logedUser = userservice.loginUser(loginformdata);
		if(logedUser!=null) {
			session.setAttribute("id", logedUser.getUserid());
		String pwdstatus = logedUser.getPwdstatus();
		if(pwdstatus.equals("UPDATED")) {
			return "redirect:/dishboardview";
		}else {
			return "redirect:/resetpwdform";
		}
		}else {
			model.addAttribute("msg","Invalid User Creditionals");
			return "redirect:/loginform";
		}
		
	}
	@PostMapping("/resetpwdformdata")
	public String showResetPwdForm(@ModelAttribute ResetPwd resetpwddata ,Model model) {
		if(resetpwddata.getPassword1().equals(resetpwddata.getPassword2())) {
		User user = userservice.updatePwd(resetpwddata);
		if(user!=null) {
			return "redirect:/dishboardview";
		}}else {
		model.addAttribute("msg","Wrong Password");
		}
		return "resetpwd";
	
	
	}
	

}
