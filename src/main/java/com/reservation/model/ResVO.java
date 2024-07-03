package com.reservation.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.mem.model.MemVO;
import com.restime.model.ResTimeVO;
import com.tabletype.model.TableTypeVO;
@Entity
@Table(name="reservation")
public class ResVO implements java.io.Serializable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="reservation_id", updatable = false, insertable = false)
		private Integer reservationId;
		@JoinColumn(name="mem_no")
		private MemVO memNo;
		@Column(name="reservation_eatdate")
		private Date reservationEatdate;
		@Column(name="reservation_num")
		private Integer reservationNum;
		@JoinColumn(name="reservation_time_id")
		private ResTimeVO resTimeVO;
		@Column(name="reservation_date")
		private LocalDateTime reservationDate;
		@JoinColumn(name="table_id")
		private TableTypeVO TableTypeVO;
		@Column(name="reservation_table")
		private Integer reservationTable;
		
//		電話與備註
//		@Column(name="reservation_phone")
//		private String reservationPhone;
//		@Column(name="reservation_note")
//		private String reservationNote;
		
		
		
		public Integer getReservationId() {
			return reservationId;
		}
		public void setReservationId(Integer reservationId) {
			this.reservationId = reservationId;
		}
		public MemVO getMemNo() {
			return memNo;
		}
		public void setMemNo(MemVO memNo) {
			this.memNo = memNo;
		}
		public Date getReservationEatdate() {
			return reservationEatdate;
		}
		public void setReservationEatdate(Date reservationEatdate) {
			this.reservationEatdate = reservationEatdate;
		}
		public Integer getReservationNum() {
			return reservationNum;
		}
		public void setReservationNum(Integer reservationNum) {
			this.reservationNum = reservationNum;
		}
		public ResTimeVO getResTimeVO() {
			return resTimeVO;
		}
		public void setResTimeVO(ResTimeVO restimeVO) {
			this.resTimeVO = restimeVO;
		}
		public LocalDateTime getReservationDate() {
			return reservationDate;
		}
		public void setReservationDate(LocalDateTime reservationDate) {
			this.reservationDate = reservationDate;
		}
		public TableTypeVO getTableTypeVO() {
			return TableTypeVO;
		}
		public void setTableTypeVO(TableTypeVO tableTypeVO) {
			TableTypeVO = tableTypeVO;
		}
		public Integer getReservationTable() {
			return reservationTable;
		}
		public void setReservationTable(Integer reservationTable) {
			this.reservationTable = reservationTable;
		}
		
		
		
		
//		public String getReservationPhone() {
//			return reservationPhone;
//		}
//		public void setReservationPhone(String reservationPhone) {
//			this.reservationPhone = reservationPhone;
//		}
//		public String getReservationNote() {
//			return reservationNote;
//		}
//		public void setReservationNote(String reservationNote) {
//			this.reservationNote = reservationNote;
//		}
		
		
		
		
		
		
}
