package br.com.luciano.testecascade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "DEPENDENTE")
public class Dependente {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NOME")
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "ID_SOCIO")
    private Socio socio;

    public Dependente() {
    }
    
    public Dependente(String nome) {
        this.nome = nome;
    }   
}
