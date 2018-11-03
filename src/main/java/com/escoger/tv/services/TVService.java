package com.escoger.tv.services;

import java.util.List;

import com.escoger.tv.beans.AllTvBean;

public interface TVService {

	List<AllTvBean> getAllTv();

	List<Object> getAllTvBasedOnBrand(String brand);

}
