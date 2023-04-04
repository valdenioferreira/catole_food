package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.OrdemDao;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(clienteDao.consultarPorNome("COELHO"));
//        Ordem ordem = ordemDao.joinFetchCliente(2);
//        System.out.println(ordemDao.consultarItensMaisVendidos());
        entityManager.getTransaction().commit();
        entityManager.close();
//        System.out.println(ordem.getCliente().getNome());
    }
}
