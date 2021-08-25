package com.synergyfolks.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        System.out.println("Helllo World");

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        Alien alien=entityManager.find(Alien.class,4);

        System.out.println(alien);
    }
}
