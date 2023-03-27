package br.com.catole.food.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory CATOLEFOOD =  Persistence.createEntityManagerFactory("catoleFood");

    public static EntityManager getEntityManagerCatoleFood() {
        return CATOLEFOOD.createEntityManager();
    }
}
