package com.reservationcontrol.model;

import java.sql.Date;

public class ReservationControlServiceHibernate {
private ReservationControlDAO_interface dao;
public ReservationControlServiceHibernate() {
	dao = new ReservationControlDAOHibernate();
}

public ResVO addReservationControl(Integer tableId,Date reasrvationControlDate,String reasrvationControlTable) {
	ResVO reservationControlVO = new ResVO();
	reservationControlVO.getTableTypeVO().setTableId(tableId);;
	reservationControlVO.setReasrvationControlDate(reasrvationControlDate);
	reservationControlVO.setReasrvationControlTable(reasrvationControlTable);
	dao.insert(reservationControlVO);
	
	return reservationControlVO;
}

}
