package com.escoger.tv.services;

import java.util.ArrayList;
import java.util.List;

import com.escoger.tv.beans.AllTvBean;
import com.escoger.tv.repo.config.AllTvRepo;

public class TVServiceImpl implements TVService {

	private final AllTvRepo tvDao;

	public TVServiceImpl(AllTvRepo tvDao) {
		this.tvDao = tvDao;
	}

	@Override
	public List<AllTvBean> getAllTv() {
		Iterable<AllTvBean> tvList = tvDao.getAllTv();
		return (List<AllTvBean>) tvList;
	}

	@Override
	public List<Object> getAllTvBasedOnBrand(String brand) {
		List<Object> allTvList = null;
		Class clazz = null;
		
		if(brand==null || brand.equalsIgnoreCase("")) {
			// need to handle this scenario
		}
		
		try {
			 clazz = Class.forName("com.escoger.tv.beans."+brand);
			 allTvList = new ArrayList<Object>(tvDao.getAllTvBasedOnBrand(brand,clazz));
		}
		
		catch(Exception e1) {
			//e1.printStackTrace();
		}
		return allTvList;
	}

}
