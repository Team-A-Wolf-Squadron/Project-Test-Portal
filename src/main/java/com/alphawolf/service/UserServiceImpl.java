package com.alphawolf.service;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphawolf.model.StudentTest;
import com.alphawolf.model.User;
import com.alphawolf.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User save(User user) {
		changePassword(user, user.getPassword());

		//Set user
		user.setEnabled("Y");//TODO
		user.setRole("ROLE_USER");
		
		//Send mail
		//sendMail(user);
		
		return userRepository.save(user);
	}


	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	public List<User> findByRole(String role) {
		return userRepository.findByRole(role);
	}
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	
	private void sendMail(User user){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("");
		mailSender.setPassword("");
		Properties p = new Properties();
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(p);
		
		MailMail mm = new MailMail();
		mm.setMailSender(mailSender);
		String mailbody = "To complete registreation please click the following link\n";
		
		mm.sendMail("teamawolfsquadron@gmail.com",	//From
					user.getUsername(),				//To
					"Email validation", 	//Subject
					mailbody);				//Message
	}

	@Transactional
	public User update(User user, User newUserInfo, String newPassword) {
		System.out.println("In userservice.update");
		if(! newUserInfo.getPhonenumber().equals(user.getPhonenumber() ) && newUserInfo.getPhonenumber().trim().length() > 0 ) {
			user.setPhonenumber(newUserInfo.getPhonenumber());
		}
		
		if(! newUserInfo.getAddress().equals(user.getAddress() ) && newUserInfo.getAddress().trim().length() > 0 ) {
			user.setAddress(newUserInfo.getAddress());
		}
		if(! newUserInfo.getPostcode().equals(user.getPostcode() ) && newUserInfo.getPostcode().trim().length() > 0 ) {
			user.setPostcode(newUserInfo.getPostcode());
		}
		if(! newUserInfo.getPersonalCodeNumber().equals(user.getPersonalCodeNumber() ) && newUserInfo.getPersonalCodeNumber().trim().length() > 0 ) {
			user.setPersonalCodeNumber(newUserInfo.getPersonalCodeNumber());
		}
		if(! newUserInfo.getSex().equals(user.getSex() ) && newUserInfo.getSex().trim().length() > 0 ) {
			user.setSex(newUserInfo.getSex());
		}
		if(! newUserInfo.getMailAddress().equals(user.getMailAddress() ) && newUserInfo.getMailAddress().trim().length() > 0 ) {
			user.setMailAddress(newUserInfo.getMailAddress());
		}
		if(! newUserInfo.getCompany().equals(user.getCompany() ) && newUserInfo.getCompany().trim().length() > 0 ) {
			user.setCompany(newUserInfo.getCompany());
		}
		if(! newUserInfo.getFirstName().equals(user.getFirstName() ) && newUserInfo.getFirstName().trim().length() > 0 ) {
			user.setFirstName(newUserInfo.getFirstName());
		}
		if(! newUserInfo.getLastName().equals(user.getLastName() ) && newUserInfo.getLastName().trim().length() > 0 ) {
			user.setLastName(newUserInfo.getLastName());
		}
		if( newPassword != null && newPassword.trim().length() > 0  ) {
			changePassword(user, newPassword);
		}

		return userRepository.save(user);
		
	}

	private void changePassword(User user, String password) {
		//Hash password
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		user.setPassword( bcpe.encode(password));
		
	}

	@Transactional
	public User update(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public User update(User user, StudentTest studentTest) {
		user.addStudentTest(studentTest);
		return userRepository.save(user);
	}


}
