package br.com.catole.food.service.teste;

import br.com.catole.food.dao.CardapioDao;
import br.com.catole.food.util.CargaDeDadosUtil;
import br.com.catole.food.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerCatoleFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de produtos por valor: "+ cardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));
        entityManager.close();
    }
}