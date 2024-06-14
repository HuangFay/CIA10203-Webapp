package com.reservationcontrol.model;

import java.util.*;

public interface ReservationControlDAO_interface {
	public void insert (ReservationControlVO reservationControlVO);
	public void update(ReservationControlVO reservationControlVO);
	public void delete(Integer reservationControlId);
	public ReservationControlVO findByPrimaryKey(Integer reservationControlId);
	public List<ReservationControlVO> getAll();
	
	
}
