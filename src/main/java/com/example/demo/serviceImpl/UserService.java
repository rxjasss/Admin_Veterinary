package com.example.demo.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public com.example.demo.entity.User register(com.example.demo.entity.User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		user.setEnabled(false);
		user.setRole("USER");
		return userRepository.save(user);
	}

	public com.example.demo.entity.User registerVeterinary(com.example.demo.entity.User user) {
		List<com.example.demo.entity.User>usuarios=userRepository.findAll();
        for(com.example.demo.entity.User u: usuarios) {
            if(u.getUsername().equals(user.getUsername())) {
                return null;
            }
        }
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		user.setEnabled(false);
		user.setRole("VETERINARY");
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User usuario = userRepository.findByUsername(username);

		UserBuilder builder = null;

		if (usuario != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));

		} else
			throw new UsernameNotFoundException("Usuario no encontrado");
		return builder.build();
	}
	
	public com.example.demo.entity.User findUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public com.example.demo.entity.User findUserId(int id) {
		return userRepository.findById(id);
	}
	
	public int activate(String username) {
        int a=0;
        com.example.demo.entity.User u=userRepository.findByUsername(username);
        com.example.demo.entity.User user=new com.example.demo.entity.User();
        user.setPassword(passwordEncoder().encode(u.getPassword()));
        user.setUsername(u.getUsername());
        user.setId(u.getId());
        user.setName(u.getName());
        user.setSurname(u.getSurname());
        user.setRole(u.getRole());
        user.setPetList(u.getPetList());
        user.setReportList(u.getReportList());
        

        if(u.isEnabled()==false) {
            user.setEnabled(true);
            a=1;
        }else {
            user.setEnabled(false);
            a=0;
        }

        userRepository.save(user);
        return a;
    }

    public void deleteUser(String username) throws Exception {
        com.example.demo.entity.User u = userRepository.findByUsername(username);
        userRepository.delete(u);
    }
    
    public com.example.demo.entity.User updateUser(com.example.demo.entity.User user) {
        return userRepository.save(user);
    }

    public List<com.example.demo.entity.User> listAllUsers() {
    	List<com.example.demo.entity.User> usersList= userRepository.findAll().stream().collect(Collectors.toList());
        List<com.example.demo.entity.User> filteredList= usersList.stream().filter(x->x.getRole().equals("VETERINARY") || x.getRole().equals("USER")).collect(Collectors.toList());
        return filteredList;
    }

}
