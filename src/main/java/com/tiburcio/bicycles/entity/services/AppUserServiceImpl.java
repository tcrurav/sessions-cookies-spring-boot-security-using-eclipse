package com.tiburcio.bicycles.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiburcio.bicycles.entity.dao.IAppUserDao;
import com.tiburcio.bicycles.entity.models.AppUser;

@Service
public class AppUserServiceImpl implements IAppUserService{
	
	private final PasswordEncoder passwordEncoder;
	
	public AppUserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

	@Autowired
	private IAppUserDao appUserDao;

	@Override
	public AppUser get(long id) {
		return appUserDao.findById(id).get();
	}

	@Override
	public List<AppUser> getAll() {
		return (List<AppUser>) appUserDao.findAll();
	}

	@Override
	public AppUser register(AppUser appUser) {
		if (appUserDao.findByUsername(appUser.getUsername()).isPresent()) {
            throw new RuntimeException("Usuario ya existe");
        }
        AppUser u = new AppUser();
        u.setUsername(appUser.getUsername());
        u.setPassword(passwordEncoder.encode(appUser.getPassword()));
//        u.setRole("ROLE_USER");
        System.out.println("llegó aquí");
		return appUserDao.save(u);		
	}

	@Override
	public void update(AppUser appUser, long id) {
		appUserDao.findById(id).ifPresent((x) -> {
			appUser.setId(id);
			appUserDao.save(appUser);
		});
	}

	@Override
	public void destroy(long id) {
		appUserDao.deleteById(id);
	}

}
