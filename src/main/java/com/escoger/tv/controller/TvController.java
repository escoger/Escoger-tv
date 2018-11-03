package com.escoger.tv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escoger.tv.beans.AllTvBean;
import com.escoger.tv.services.TVService;

@RestController
@RequestMapping(path = "/tv", consumes = "application/json", produces = "application/json")
public class TvController {

	TVService tvService;

	@Autowired
	public TvController(TVService tvService) {
		this.tvService = tvService;
	}

	@GetMapping("/All")
	public ResponseEntity<List<AllTvBean>> getAllTv() {
		return new ResponseEntity<List<AllTvBean>>(tvService.getAllTv(), HttpStatus.OK);
	}

	@GetMapping	("/tvBrand/{brand}")
	public ResponseEntity<List<Object>> getAllTvBasedOnBrand(@PathVariable String brand) {

		return new ResponseEntity<List<Object>>(tvService.getAllTvBasedOnBrand(brand), HttpStatus.OK);
	}
	
}
