package br.com.catole.food.service.test;

import br.com.catole.food.dao.PratoDao;
import br.com.catole.food.entity.Prato;
import br.com.catole.food.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Prato risoto = new Prato();

        risoto.setNome("Risoto de frango");
        risoto.setDescricao("Risoto de frango com legumes frescos");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(90.50));

        EntityManager entityManager = JPAUtil.getEntityManagerCatolefood();
        PratoDao pratoDao = new PratoDao(entityManager);
        entityManager.getTransaction().begin();
        pratoDao.cadastrar(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
