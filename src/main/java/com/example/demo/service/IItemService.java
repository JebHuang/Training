package com.example.demo.service;

import com.example.demo.entity.Item;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Lance
 * @date 2021/1/7 18:16
 */
public interface IItemService {
    List<Item> list(Long handlerId, Integer type, Integer deal, Integer page, Integer pageSize);
    void saveItem(Item item);
    void dealItem(Long itemId, String handlerId, String username);
    Page<Item> page(String name, Long handlerId, Integer type, Integer deal, Integer page, Integer pageSize);
}
