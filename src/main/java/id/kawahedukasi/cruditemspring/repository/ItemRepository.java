package id.kawahedukasi.cruditemspring.repository;

import id.kawahedukasi.cruditemspring.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {
    Optional<Item> findByName(String name); //bikin abstract method

    @Query(nativeQuery = true, value = "SELECT * FROM item_schema.item where \"count\" != 0 ")
    List<Item> listExistItem();
}
