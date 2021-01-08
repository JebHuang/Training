package com.example.demo;

import com.example.demo.common.DealTypeEnum;
import com.example.demo.common.GenderTypeEnum;
import com.example.demo.common.ItemTypeEnum;
import com.example.demo.common.PurposeTypeEnum;
import com.example.demo.controller.BaseController;
import com.example.demo.entity.Item;
import com.example.demo.model.AdminUser;
import com.example.demo.repository.IItemRepository;
import com.example.demo.vo.ItemVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Common Controller
 *
 * @author Jeb
 */
@Slf4j
@RestController
public class Controller extends BaseController {

    @Resource
    private IItemRepository itemRepository;

    @GetMapping(value = {"", "index", "/"})
    public ModelAndView index(ModelAndView mv, HttpServletRequest request) {
        AdminUser currentUser = getSessionAdminUser(request);
        mv.addObject("currentUser", currentUser);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "loginOut")
    public String loginOut(HttpServletRequest request) {
        try {
            logout(request);
        } catch (ServletException e) {
            log.error(e.getMessage(), e);
        }
        return "success";
    }

    @GetMapping(value = "welcome")
    public ModelAndView welcome(ModelAndView mv) {
        mv.setViewName("welcome");
        return mv;
    }

    @GetMapping(value = "consult/table")
    public ModelAndView consultHandle(ModelAndView mv, HttpServletRequest request) {
        AdminUser currentUser = getSessionAdminUser(request);
        StringBuilder roleList = new StringBuilder();
        for (String str : currentUser.getRoles()) {
            roleList.append(str).append(",");
        }
        mv.addObject("roles", roleList.toString());
        mv.setViewName("consult/table");
        return mv;
    }

    @GetMapping(value = "consult/add")
    public ModelAndView consultAdd(ModelAndView mv) {
        mv.setViewName("consult/add");
        return mv;
    }

    @GetMapping(value = "consult/edit")
    public ModelAndView consultEdit(Long id, ModelAndView mv, HttpServletRequest request) {
        AdminUser currentUser = getSessionAdminUser(request);
        Item item = null;
        Item backUpItem = new Item(0L, "-", 0, "-", "-", 0, 0, "-", null, null, 0, "-", "-");
        if (null != id) {
            Optional<Item> opItem = itemRepository.findById(id);
            item = opItem.orElse(backUpItem);
        }
        ItemVO vo = transalte(item);
        mv.addObject("item", vo);
        mv.setViewName("consult/edit");
        return mv;
    }

    @GetMapping(value = "consult/data")
    public ConsultDataVO consultData() {
        ConsultDataVO vo = new ConsultDataVO();
        Item itemCondition1 = new Item();
        itemCondition1.setDeal(0);
        Item itemCondition2 = new Item();
        itemCondition2.setDeal(1);
        long itemCount1 = itemRepository.count(Example.of(itemCondition1));
        long itemCount2 = itemRepository.count(Example.of(itemCondition2));
        vo.setInProcessCount(itemCount1 + "");
        vo.setAccomplishCount(itemCount2 + "");
        return vo;
    }

    @Data
    public static class ConsultDataVO {
        private String inProcessCount;
        private String accomplishCount;
    }

    private ItemVO transalte(Item item) {
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(item, itemVO);
        itemVO.setSex(GenderTypeEnum.getDesc(item.getGender()));
        itemVO.setDeal(DealTypeEnum.getDesc(item.getDeal()));
        itemVO.setType(ItemTypeEnum.getDesc(item.getType()));
        itemVO.setPurpose(PurposeTypeEnum.getDesc(item.getPurpose()));
        return itemVO;
    }
}
