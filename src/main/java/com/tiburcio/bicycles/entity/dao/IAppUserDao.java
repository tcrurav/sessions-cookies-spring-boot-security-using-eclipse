package com.tiburcio.bicycles.entity.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tiburcio.bicycles.entity.models.AppUser;

public interface IAppUserDao extends CrudRepository<AppUser, Long>{
	Optional<AppUser> findByUsername(String username);
}
