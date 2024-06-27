package com.reservationcontrol.model;

import java.sql.Date;

public class ReservationControlServiceHibernate {
private ReservationControlDAO_interface dao;
public ReservationControlServiceHibernate() {
	dao = new ReservationControlDAOHibernate();
}

public ResCVO addReservationControl(Integer tableId,Date reasrvationControlDate,String reasrvationControlTable) {
	ResCVO reservationControlVO = new ResCVO();
	reservationControlVO.getTableTypeVO().setTableId(tableId);;
	reservationControlVO.setReasrvationControlDate(reasrvationControlDate);
	reservationControlVO.setReasrvationControlTable(reasrvationControlTable);
	dao.insert(reservationControlVO);
	
	return reservationControlVO;
}

}
