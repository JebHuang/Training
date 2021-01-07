package com.example.demo.service;

import com.example.demo.entity.Item;

import java.util.List;

/**
 * @author Lance
 * @date 2021/1/7 18:16
 */
public interface IItemService {
    void saveItem(Item item);
    List<Item> listAllItem();
    List<Item> listUnDealItem();
    List<Item> listItemByUserId();
    List<Item> listItemByHandlerId();
}
