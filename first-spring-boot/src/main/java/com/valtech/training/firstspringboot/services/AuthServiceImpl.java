package com.valtech.training.firstspringboot.services;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;
import com.valtech.training.firstspringboot.repositories.UserRepo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthServiceImpl implements AuthService, UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder; //stores the password in encoded form
	
	//we are pre-populating data
	@PostConstruct
	public void populateUsers() {
		RegisterUserModel model = new RegisterUserModel();
		model.setUsername("scott");
		model.setPassword("tiger123");
		createUser(model);
		
		model.setUsername("admin");
		model.setPassword("admin123");
		
		User user = createUser(model);
//		upgradeUserToAdmin(user.getId());
	}
	
	public User createUser(RegisterUserModel regUserModel) {
		User user = new User(regUserModel.getUsername(),
				passwordEncoder.encode(regUserModel.getPassword()),Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
		user.setEnabled(true);
		return userRepo.save(user);
	}
	
	public boolean changePassword(ChangePasswordModel passwordModel) {
		
		User user = userRepo.findByUsername(passwordModel.getUsername());
		
		// to check id old passsword == newPassword
		if(passwordEncoder.matches(passwordModel.getNewPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(passwordModel.getNewPassword()));
			userRepo.save(user);
			return true;// to check if password was changes successfully
		}
		return false;
	}
	
	public void upgradeUserToAdmin(long id) {
		User user = userRepo.getReferenceById(id);
		user.addRole("ROLE_ADMIN");
		userRepo.save(user);
	}
	
	public void enableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(true);
	}
	
	public void disableUser(long id) {
		userRepo.getReferenceById(id).setEnabled(false);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username);
	}
	
	
}
