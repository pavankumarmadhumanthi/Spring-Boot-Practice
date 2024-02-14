package com.example.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Bindings.LoginForm;
import com.example.Bindings.RegisterForm;
import com.example.Bindings.ResetPwd;
import com.example.Entities.City;
import com.example.Entities.Country;
import com.example.Entities.State;
import com.example.Entities.User;
import com.example.Repos.CityRepo;
import com.example.Repos.CountryRepo;
import com.example.Repos.StateRepo;
import com.example.Repos.UserRepo;
import com.example.Utilites.EmailUtility;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private JavaMailSender mailsender;

	@Value("$(spring.mail.user)")
	private String fromMail;

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private CityRepo cityrepo;
	@Autowired
	private CountryRepo countryrepo;
	@Autowired
	private StateRepo staterepo;

	@Override
	public String saveUser(RegisterForm registerfrom) {
		if (userrepo.findByEmail(registerfrom.getEmail()) == null) {
			User user = new User();
			BeanUtils.copyProperties(registerfrom, user);
			user.setPwdstatus("NOTUPDATED");
			user.setPassword(generatePwd());
			userrepo.save(user);
			EmailUtility emailutility = new EmailUtility();
			sendPassword(user.getPassword(), emailutility, user.getEmail());

			return "Registration Success";
		} else {
			return "Failed to Register";
		}
	}

	private void sendPassword(String password, EmailUtility emailutility, String mail) {
		SimpleMailMessage simplemailmessage = new SimpleMailMessage();
		simplemailmessage.setFrom(fromMail);
		simplemailmessage.setSubject(emailutility.getSubject());
		simplemailmessage.setText(emailutility.getMessage()+password);
		simplemailmessage.setTo(mail);
		mailsender.send(simplemailmessage);

	}

	@Override
	public User loginUser(LoginForm loginform) {
		User user = userrepo.findByEmailAndPassword(loginform.getEmail(), loginform.getPassword());
		return user;
	}

	@Override
	public User updatePwd(ResetPwd resetpwd) {
		Optional<User> optionaluser = userrepo.findById(resetpwd.getId());
		User user = optionaluser.get();
		user.setPassword(resetpwd.getPassword1());
		user.setPwdstatus("UPDATED");
		User save = userrepo.save(user);
		return save;
		
	}

	@Override
	public String generatePwd() {
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer password=new StringBuffer();
		Random r=new Random();
		for(int i=0;i<5;i++) {
		int nextInt = r.nextInt(str.length()-1);
		password.append(str.charAt(nextInt));
		}
		return password.toString();
	}

	@Override
	public Map<Integer, String> getCountries() {
		// TODO Auto-generated method stub
		List<Country> countries = countryrepo.findAll();
		Map<Integer, String> countrymap = new HashMap<>();
		countries.forEach(country -> {
			countrymap.put(country.getCid(), country.getCname());
		});

		return countrymap;
	}

	@Override
	public Map<Integer, String> getStates(Integer cid) {
		// TODO Auto-generated method stub
		List<State> states = staterepo.findByCid(cid);
		Map<Integer, String> statemap = new HashMap<>();
		states.forEach(state -> {
			statemap.put(state.getSid(), state.getSname());
		});

		return statemap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateid) {
		List<City> cities = cityrepo.findBySid(stateid);
		Map<Integer, String> citymap = new HashMap<>();
		cities.forEach(city -> {
			citymap.put(city.getCityid(), city.getCityname());
		});
		return citymap;
	}

}
