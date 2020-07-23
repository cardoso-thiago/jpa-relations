package br.com.jparelations.repository;

import br.com.jparelations.entity.Child;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ChildRepository extends CrudRepository<Child, Long> {
    @Query(value = "SELECT * FROM child c WHERE c.parent_id= :id", nativeQuery = true)
    Set<Child> findChildByParentId(Long id);
}
