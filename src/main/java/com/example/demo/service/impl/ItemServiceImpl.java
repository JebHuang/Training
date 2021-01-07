package com.example.demo.service.impl;

import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.repository.IItemRepository;
import com.example.demo.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Lance
 * @date 2021/1/7 18:21
 */
@Service
public class ItemServiceImpl implements IItemService {
    @Autowired
    private IItemRepository itemRepository;

    @Override
    @Transactional
    public void saveItem(Item item) {

    }

    @Override
    public List<Item> listAllItem() {
        return null;
    }

    @Override
    public List<Item> listUnDealItem() {
        return null;
    }

    @Override
    public List<Item> listItemByUserId() {
        return null;
    }

    @Override
    public List<Item> listItemByHandlerId() {
        return null;
    }

    private List<Item> findByCondition(Item item) {
        PageRequest pageRequest = PageRequest.of(1, 100);
        Example<Item> example = Example.of(item);
        Page<Item> all = itemRepository.findAll(example, pageRequest);
        return all.getContent();
    }
}
