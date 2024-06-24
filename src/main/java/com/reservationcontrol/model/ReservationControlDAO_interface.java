package com.reservationcontrol.model;

import java.util.*;

public interface ReservationControlDAO_interface {
	public void insert (ResVO reservationControlVO);
	public void update(ResVO reservationControlVO);
	public void delete(Integer reservationControlId);
	public ResVO findByPrimaryKey(Integer reservationControlId);
	public List<ResVO> getAll();
	
	
}
