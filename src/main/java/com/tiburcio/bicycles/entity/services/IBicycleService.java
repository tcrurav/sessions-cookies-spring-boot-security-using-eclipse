package com.tiburcio.bicycles.entity.services;

import java.util.List;

import com.tiburcio.bicycles.entity.models.Bicycle;

public interface IBicycleService {
	public Bicycle get(long id);
	public List<Bicycle> getAll();
	public void save(Bicycle bicycle);
	public void update(Bicycle bicycle, long id);
	public void destroy(long id);
}
