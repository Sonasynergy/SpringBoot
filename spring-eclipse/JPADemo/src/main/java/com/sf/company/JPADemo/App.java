package com.sf.company.JPADemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
	public static void main(String[] args) {
		Alien a = new Alien();
	      a.setId(4);
	      a.setName("Maria");
	      a.setTech("Hardware");
	      
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
	    	EntityManager em = emf.createEntityManager();
	    	
	    	em.getTransaction().begin();
	    	em.persist(a);
	    	em.getTransaction().commit();
	    	System.out.println(a);
	}
}
