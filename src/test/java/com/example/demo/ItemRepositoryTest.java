package com.example.demo;

import com.example.demo.common.DealTypeEnum;
import com.example.demo.common.ItemTypeEnum;
import com.example.demo.common.GenderTypeEnum;
import com.example.demo.entity.Item;
import com.example.demo.repository.IItemRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IItemService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    @Resource
    private IItemService itemService;

    @Test
    public void saveByRepo() {
        Item item = new Item();
        item.setContent("投诉某个员工拒绝服务");
        item.setName("李四");
        item.setPhone("12345678901");
        item.setEmail("li4@163.com");
        item.setGender(GenderTypeEnum.SIR.getCode());
        item.setCreateDate(new Date());
        item.setType(ItemTypeEnum.SUGGESTION.getCode());
        item.setDeal(DealTypeEnum.UNPROCESSED.getCode());
        Item save = itemRepository.save(item);
        System.out.println(save.toString());
    }

    @Test
    public void saveByService() {
        Item item = new Item();
        item.setContent("投诉某个员工拒绝服务");
        item.setName("李四");
        item.setPhone("12345678901");
        item.setEmail("li4@163.com");
        item.setGender(GenderTypeEnum.SIR.getCode());
        item.setCreateDate(new Date());
        item.setType(ItemTypeEnum.SUGGESTION.getCode());
        item.setDeal(DealTypeEnum.UNPROCESSED.getCode());
        itemService.saveItem(item);
        System.out.println("----------------");
    }

    @Test
    public void listByService() {
        List<Item> list = itemService.list(null, null, DealTypeEnum.UNPROCESSED.getCode(), 1, 2);
        list.forEach(System.out::println);
    }

    @Test
    public void test() {
        Item item = new Item();
        item.setDeal(DealTypeEnum.UNPROCESSED.getCode());

        Sort.Order order = Sort.Order.desc("id");
        Sort sort = Sort.by(order);
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        Example<Item> example = Example.of(item);
        Page<Item> all = itemRepository.findAll(example, pageRequest);
        System.out.println(all.getContent());
    }

    @Test
    public void update() {
//        itemService.dealItem(2L, "82781L", currentUser.getUsername());
    }

    @Test
    public void findByCondition() {
        ;
    }
}
