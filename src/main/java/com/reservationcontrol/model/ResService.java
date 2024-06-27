package com.reservationcontrol.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("resService")
public class ResService {	
	@Autowired
	ResRepository repository;
	
	public void addRes(ResCVO resVO) {
		repository.save(resVO);
	}
	
	public void updateRes(ResCVO resVO) {
		repository.save(resVO);
	}
	
	//應該用不到
	public void deleteRes(Integer reservationControlId) {
		if (repository.existsById(reservationControlId))
			repository.deleteByreservationControlId(reservationControlId);
	}
	
	public ResCVO getOneRes(Integer reservationControlId) {
		Optional<ResCVO> optional = repository.findById(reservationControlId);
//		return optional.get();
		return optional.orElse(null);  // public T orElse(T other) : 如果值存在就回傳其值，否則回傳other的值
	}
	
	public List<ResCVO>getAll(){
		return repository.findAll();
	}

}
