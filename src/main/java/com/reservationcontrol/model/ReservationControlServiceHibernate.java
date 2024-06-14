package com.reservationcontrol.model;

import java.sql.Date;

public class ReservationControlServiceHibernate {
private ReservationControlDAO_interface dao;
public ReservationControlServiceHibernate() {
	dao = new ReservationControlDAOHibernate();
}

public ReservationControlVO addReservationControl(Integer tableId,Date reasrvationControlDate,String reasrvationControlTable) {
	ReservationControlVO reservationControlVO = new ReservationControlVO();
	reservationControlVO.setTableId(tableId);
	reservationControlVO.setReasrvationControlDate(reasrvationControlDate);
	reservationControlVO.setReasrvationControlTable(reasrvationControlTable);
	dao.insert(reservationControlVO);
	
	return reservationControlVO;
}

}
