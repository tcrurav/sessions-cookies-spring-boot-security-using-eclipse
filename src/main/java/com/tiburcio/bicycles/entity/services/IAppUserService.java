package com.tiburcio.bicycles.entity.services;

import java.util.List;

import com.tiburcio.bicycles.entity.models.AppUser;

public interface IAppUserService {
	
	public AppUser get(long id);
	public List<AppUser> getAll();
	public AppUser register(AppUser appUser);
	public void update(AppUser appUser, long id);
	public void destroy(long id);
}
