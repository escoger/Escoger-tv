package com.escoger.tv.repo.config;

import java.util.Collection;
import java.util.List;

import com.escoger.tv.beans.AllTvBean;

public interface AllTvRepo {
	
	public List<AllTvBean> getAllTv();

	public Collection<? extends Object> getAllTvBasedOnBrand(String brand, Class clazz);
	
	
	
	

}
