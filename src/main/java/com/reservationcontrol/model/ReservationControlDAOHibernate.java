package com.reservationcontrol.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;
public class ReservationControlDAOHibernate  implements ReservationControlDAO_interface{
	private SessionFactory factory;
	
	public ReservationControlDAOHibernate() {
		factory=HibernateUtil.getSessionFactory();
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public void insert(ReservationControlVO reservationControlVO) {
				getSession().save(reservationControlVO);
	}

	@Override
	public void update(ReservationControlVO reservationControlVO) {
		// TODO Auto-generated method stub
			getSession().update(reservationControlVO);
	}

	@Override
	public void delete(Integer reservationControlId) {
		// TODO Auto-generated method stub
		getSession().delete(reservationControlId);
	}

	@Override
	public ReservationControlVO findByPrimaryKey(Integer reservationControlId) {
		// TODO Auto-generated method stub
		return getSession().get(ReservationControlVO.class,reservationControlId);
		 
	}

	@Override
	public List<ReservationControlVO> getAll() {
		// TODO Auto-generated method stub
		
		return  getSession().createQuery("from ReservationControlVO",ReservationControlVO.class).list();
	}

}
