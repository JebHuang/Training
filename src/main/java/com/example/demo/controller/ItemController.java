package com.example.demo.controller;

import com.example.demo.vo.ItemVO;
import com.example.demo.common.DealTypeEnum;
import com.example.demo.common.ItemTypeEnum;
import com.example.demo.common.Result;
import com.example.demo.common.GenderTypeEnum;
import com.example.demo.entity.Item;
import com.example.demo.service.IItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lance
 * @date 2021/1/8 9:47
 */
@RestController
public class ItemController {
    @Autowired
    private IItemService itemService;

    @GetMapping("/item")
    public Result<List<ItemVO>> queryItem(@RequestParam(name = "type", required = false) Integer type,
                          @RequestParam(name = "deal", required = false) Integer deal,
                          @RequestParam(name = "handlerId", required = false) Long handlerId,
                          @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        List<Item> list = itemService.list(handlerId, type, deal, page, pageSize);
        // 转为 Vo
        List<ItemVO> itemVOs = new ArrayList<>(list.size());
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(item -> itemVOs.add(transalte(item)));
        }

        Result<List<ItemVO>> result = new Result<>(itemVOs);
        return result;
    }

    @PostMapping
    public Result<Boolean> saveItem(Item item) {
        itemService.saveItem(item);
        return new Result<>(true);
    }

    @PostMapping("/item/deal")
    public Result<Boolean> dealItem(@RequestParam(name = "id") Long id) {
        itemService.dealItem(id, 111L);
        return new Result<>(true);
    }


    private ItemVO transalte(Item item) {
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(item, itemVO);
        itemVO.setSex(GenderTypeEnum.getDesc(item.getGender()));
        itemVO.setDeal(DealTypeEnum.getDesc(item.getDeal()));
        itemVO.setType(ItemTypeEnum.getDesc(item.getType()));
        return itemVO;
    }
}
