package com.tabletype.model;

import org.hibernate.Session;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import util.HibernateUtil;

public class TestGetAndLoad {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			
			TableTypeVO table = session.get(TableTypeVO.class, 2);
			System.out.println("資料為"+ table);
			
			System.out.println( ReflectionToStringBuilder.toString(table));
			
//			Dept dept2 = session.load(Dept.class, 20);
//			System.out.println(dept2);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
		
	}
}
