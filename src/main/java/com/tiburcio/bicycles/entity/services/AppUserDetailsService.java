package com.tiburcio.bicycles.entity.services;

import org.springframework.stereotype.Service;

import com.tiburcio.bicycles.entity.dao.IAppUserDao;
import com.tiburcio.bicycles.entity.models.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IAppUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser u = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
		
        return User.builder()
                .username(u.getUsername())
                .password(u.getPassword())
                //.roles(u.getRole().replace("ROLE_", "")) // "ROLE_USER" -> "USER"
                .build();
	}
	
}
