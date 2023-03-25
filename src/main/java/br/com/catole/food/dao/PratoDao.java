package br.com.catole.food.dao;

import br.com.catole.food.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Prato prato) {
        this.entityManager.persist(prato);
        System.out.println("Entidade cadastrada:" + prato);
    }

    public Prato consultar(final Integer id){
        return this.entityManager.find(Prato.class, id);
    }

    public void atualizar(final Prato prato){
        this.entityManager.merge(prato);
    }

    public void exluir(final Prato prato){
        this.entityManager.remove(prato);
    }
}
