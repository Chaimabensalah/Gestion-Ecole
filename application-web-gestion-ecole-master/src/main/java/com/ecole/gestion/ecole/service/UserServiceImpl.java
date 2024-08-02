package com.ecole.gestion.ecole.service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecole.gestion.ecole.dao.*;
import com.ecole.gestion.ecole.model.Role;
import com.ecole.gestion.ecole.model.User;
 

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    
    
	
//	@Override
//	public User findUserByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}

	@Override
	public void saveUser(User user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
	}
	
	@Override
	public void saveUserSecond(User user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       // user.setActive(1);
       // Role userRole = roleRepository.findByRole("USER");
      //  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		//Employee emp=new Employee();
		//emp.setUser_id(user.getUser_id());
	//	emp.setUser(userRepository.findOne(user.getUser_id()));
		 //employeeMetier.save(emp);
		// employeeRepository.save(emp);
		
        userRepository.save(user);
	}
	
	@Override
	public void saveUserA(User user) {
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
       // Role userRole = roleRepository.findByRole("RH");
       // user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
	}
	
	@Override
	public void saveUserAd(User user) {
	//	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
	}
	
	@Override
	public User findOne(Integer arg0) {
		return userRepository.findOne(arg0);
	}
	
	@Override
	public User findEnabled(Integer arg0) {
		return userRepository.findEnabled(arg0);
	}
	
	//send an email:

  
 
//    private boolean emailExist(String email) {
//        User user = userRepository.findByEmail(email);
//        if (user != null) {
//            return true;
//        }
//        return false;
//    }
    
   
    @Override
	
	public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}
    
    @Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
    
    /* @Override
   	public List<User> findEmployee(int a) {
   		return userRepository.findEmployee(a);
   	} */

}

