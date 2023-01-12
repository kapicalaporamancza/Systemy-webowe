package com.example.productlistfragments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String firstName);
    List<Product> findByNameContaining(String substring);

    @Transactional
    @Modifying
    @Query("update Product p set p.name = ?1, p.weight = ?2, p.price = ?3, p.category = ?4 where p.id = ?5")
    void updateProduct(String name, Float weight, Float price, long category, long id);
}
