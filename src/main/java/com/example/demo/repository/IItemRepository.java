package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lance
 * @date 2021/1/7 17:34
 */
public interface IItemRepository extends JpaRepository<Item, Long> {
}
