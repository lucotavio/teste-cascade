package br.com.luciano.testecascade.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SOCIO")
public class Socio {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NOME")
    private String nome;
    
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Dependente> dependentes;

    public Socio() {
        this(null);
    }
    
    public Socio(String nome) {
        this.nome = nome;
        this.dependentes = new HashSet<>();
    }
    
    public void adicionarDependente(Dependente dependente){
        dependentes.add(dependente);
        dependente.setSocio(this);
    }
    
    public void removerDependente(Integer id){
        this.dependentes.removeIf(d -> d.getId().equals(id));
    }
    
}
