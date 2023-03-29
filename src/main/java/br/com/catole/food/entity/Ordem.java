package br.com.catole.food.entity;

import br.com.catole.food.util.Cliente;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @ManyToOne
    private Cliente cliente;

    public Ordem(Integer id, BigDecimal valorTotal, LocalDateTime dataCriacao, Cliente cliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
    }

    //JPA obriga a criar um construtor vazio
    public Ordem() {
    }
    //FIM


    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
