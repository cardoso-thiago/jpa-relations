package br.com.jparelations.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    @OneToMany(
            mappedBy = "parent",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Child> childs = new HashSet<>();

    public Parent(String value, Set<Child> childs) {
        this.value = value;
        this.childs = childs;
    }

    public Parent() {
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Set<Child> getChilds() {
        return childs;
    }
}
