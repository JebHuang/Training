package com.example.demo;

import com.example.demo.entity.Item;
import com.example.demo.repository.IItemRepository;
import lombok.Data;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class Controller {

    @Resource
    private IItemRepository itemRepository;

    @GetMapping(value = {"", "index", "/"})
    public ModelAndView index(ModelAndView mv) {
        // todo: 增加 首页-显示用户名
        mv.addObject("userName", "先生");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "welcome")
    public ModelAndView welcome(ModelAndView mv) {
        mv.setViewName("welcome");
        return mv;
    }

    @GetMapping(value = "consult/table")
    public ModelAndView consultHandle(ModelAndView mv) {
        mv.setViewName("consult/table");
        return mv;
    }

    @GetMapping(value = "consult/add")
    public ModelAndView consultAdd(ModelAndView mv) {
        mv.setViewName("consult/add");
        return mv;
    }

    @GetMapping(value = "consult/edit")
    public ModelAndView consultEdit(ModelAndView mv) {
        mv.setViewName("consult/edit");
        return mv;
    }

    @GetMapping(value = "consult/data")
    public ConsultDataVO consultData() {
        ConsultDataVO vo = new ConsultDataVO();
        Item itemCondition1 = new Item();

        Item itemCondition2 = new Item();

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
}
