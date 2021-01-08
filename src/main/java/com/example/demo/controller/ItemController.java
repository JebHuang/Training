package com.example.demo.controller;

import com.example.demo.common.*;
import com.example.demo.entity.Item;
import com.example.demo.model.AdminUser;
import com.example.demo.service.IItemService;
import com.example.demo.vo.ItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lance
 * @date 2021/1/8 9:47
 */
@RequestMapping("/item")
@RestController
public class ItemController extends BaseController {
    @Autowired
    private IItemService itemService;

    @GetMapping
    public PageVO<ItemVO> queryItem(@RequestParam(name = "type", required = false) Integer type,
                                    @RequestParam(name = "deal", required = false) Integer deal,
                                    @RequestParam(name = "handlerId", required = false) Long handlerId,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(name = "limit", required = false, defaultValue = "10") Integer pageSize) {
        Page<Item> pageEntity = itemService.page(name, handlerId, type, deal, page, pageSize);
        List<Item> list = pageEntity.getContent();
        // item convert to vo
        List<ItemVO> vos = list.stream()
                .map(this::transalte)
                .collect(Collectors.toList());
        PageVO<ItemVO> pageVO = new PageVO<>();
        pageVO.setCount(pageEntity.getTotalElements());
        pageVO.setData(vos);
        pageVO.setCode(0);
        pageVO.setMsg("success");
        return pageVO;
    }

    @PostMapping
    public Result<Boolean> saveItem(Item item) {
        item.setCreateDate(new Date());
        item.setDeal(DealTypeEnum.UNPROCESSED.getCode());
        itemService.saveItem(item);
        return new Result<>(true);
    }

    @PostMapping("/deal")
    public Result<Boolean> dealItem(@RequestParam(name = "id") Long id, HttpServletRequest request) {
        AdminUser currentUser = getSessionAdminUser(request);
        itemService.dealItem(id, currentUser.getUserId(),currentUser.getUsername());
        return new Result<>(true);
    }


    private ItemVO transalte(Item item) {
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(item, itemVO);
        itemVO.setSex(GenderTypeEnum.getDesc(item.getGender()));
        itemVO.setDeal(DealTypeEnum.getDesc(item.getDeal()));
        itemVO.setType(ItemTypeEnum.getDesc(item.getType()));
        itemVO.setPurpose(PurposeTypeEnum.getDesc(item.getPurpose()));
        itemVO.setHandlerName(StringUtils.isEmpty(itemVO.getHandlerName()) ? "-" : itemVO.getHandlerName());
        return itemVO;
    }

}
