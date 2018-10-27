package com.escoger.tv.services;

import com.escoger.tv.repo.config.AllTvRepo;

public class TVServiceImpl implements TVService{

private final AllTvRepo tvDao;
	
	
	
	public TVServiceImpl(AllTvRepo tvDao) {
		this.tvDao = tvDao;
	}
	
}
