package com.example.demo.service.impl;

import com.example.demo.common.DealTypeEnum;
import com.example.demo.entity.Item;
import com.example.demo.repository.IItemRepository;
import com.example.demo.service.IItemService;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public List<Item> list(Long handlerId, Integer type, Integer deal, Integer page, Integer pageSize) {
        Item item = new Item();
        if (handlerId != null) {
            item.setHandlerId(handlerId);
        }
        if (type != null) {
            item.setType(type);
        }
        if (deal != null) {
            item.setDeal(deal);
        }
        List<Item> items = findByCondition(item, page, pageSize);
        return items;
    }

    @Override
    @Transactional
    public void saveItem(Item item) {
        if (StringHelper.isEmpty(item.getContent())) {
            throw new RuntimeException("item content can't empty!");
        }
        if (StringHelper.isEmpty(item.getPhone())) {
            throw new RuntimeException("item phone can't empty!");
        }
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public void dealItem(Long itemId, Long handlerId) {
        if (itemId == null) {
            throw new RuntimeException("item id can't empty");
        }
        Item item = itemRepository.getOne(itemId);
        if (item != null) {
            item.setUpdateDate(new Date());
            item.setHandlerId(handlerId);
            item.setDeal(DealTypeEnum.PROCESSED.getCode());
            itemRepository.save(item);
        }
    }

    private List<Item> findByCondition(Item item, Integer page, Integer pageSize) {
        Sort.Order order = Sort.Order.desc("id");
        Sort sort = Sort.by(order);
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        Example<Item> example = Example.of(item);
        Page<Item> all = itemRepository.findAll(example, pageRequest);
        return all.getContent();
    }
}
