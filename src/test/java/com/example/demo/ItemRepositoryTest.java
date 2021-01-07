package com.example.demo;

import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.repository.IItemRepository;
import com.example.demo.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Lance
 * @date 2021/1/7 17:35
 */
@SpringBootTest
public class ItemRepositoryTest {
    @Resource
    private IItemRepository itemRepository;

    @Resource
    private IUserRepository IUserRepository;

    @Test
    public void save() {
        List<User> all = IUserRepository.findAll();
        User user = all.get(0);
        Item item = new Item();
        item.setContent("投诉某某员工");
        item.setDeal(0);
        item.setType(0);
        item.setCreateDate(new Date());
        item.setUser(user);
        itemRepository.save(item);
        System.out.println("----------------");
    }

    @Test
    public void update() {
        List<User> all = IUserRepository.findAll();
        User user = all.get(1);
        Item item = itemRepository.findAll().get(0);
        item.setHandler(user);
        item.setUpdateDate(new Date());
        item.setDeal(1);
        itemRepository.save(item);
    }

    @Test
    public void findByCondition() {
        User user = new User();
        user.setId(10L);
        Item item = new Item();
        item.setUser(user);
        Pageable pageable = PageRequest.of(2, 100);
        Page<Item> all = itemRepository.findAll(Example.of(item), pageable);
        System.out.println(all);
    }
}
