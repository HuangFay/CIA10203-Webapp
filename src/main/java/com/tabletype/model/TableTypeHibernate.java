package com.tabletype.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class TableTypeHibernate implements TableTypeDAO_interface{

	private SessionFactory factory;
	public TableTypeHibernate() {
		factory=HibernateUtil.getSessionFactory();
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public void insert(TableTypeVO tabletypeVO) {
		getSession().save(tabletypeVO);
		
	}

	@Override
	public void update(TableTypeVO tabletypeVO) {
		getSession().update(tabletypeVO);
		
	}

	@Override
	public void delete(Integer tableId) {
		// TODO Auto-generated method stub
		getSession().delete(tableId);
	}

	@Override
	public TableTypeVO findByPrimaryKey(Integer tableId) {
		
		 return getSession().get(TableTypeVO.class,tableId);
	}

	@Override
	public List<TableTypeVO> getAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from TableTypeVO",TableTypeVO.class).list();
	}

}
