package com.lxz.oauth2.controller;


import com.lxz.oauth2.entity.TbContent;
import com.lxz.oauth2.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;


    @GetMapping("/")
    public List<TbContent> ContentList(){
        return tbContentService.selectAll();
    }

}
