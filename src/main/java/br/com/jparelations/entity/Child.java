package br.com.jparelations.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = false)
    private Parent parent;

    public Child() {
    }

    public Child(String value, Parent parent) {
        this.value = value;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Parent getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id) &&
                Objects.equals(value, child.value) &&
                Objects.equals(parent, child.parent);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
