package com.reservationcontrol.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_control")
public class ReservationControlVO implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reservation_control_id", updatable = false, insertable = false)
	private Integer reservationControlId;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="table_type")
	private Integer tableId;
	@Column(name="reservation_control_date")
	private Date reasrvationControlDate;
	@Column(name="reservation_control_table")
	private String reasrvationControlTable;
	
	
	public Integer getReservationControlId() {
		return reservationControlId;
	}
	public void setReservationControlId(Integer reservationControlId) {
		this.reservationControlId = reservationControlId;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public Date getReasrvationControlDate() {
		return reasrvationControlDate;
	}
	public void setReasrvationControlDate(Date reasrvationControlDate) {
		this.reasrvationControlDate = reasrvationControlDate;
	}
	public String getReasrvationControlTable() {
		return reasrvationControlTable;
	}
	public void setReasrvationControlTable(String reasrvationControlTable) {
		this.reasrvationControlTable = reasrvationControlTable;
	}
	
	
	
	
}
