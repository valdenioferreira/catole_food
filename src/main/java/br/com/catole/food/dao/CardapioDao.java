package br.com.catole.food.dao;

import br.com.catole.food.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
     * CRUD
     * C = CREATE
     * R = READ
     * U = UPDATE
     * D = DELETE
     * */

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("valor",filtro).getResultList();
    }

    public Cardapio consultarPorNome(final String filtro){
        try {
        String jpql = "SELECT c FROM Cardapio c WHERE Upper(c.nome) = Upper(:nome)";
        return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("nome",filtro).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public List<Cardapio> consultarTodos(){
        String jpql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(jpql,Cardapio.class).getResultList();
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

}
