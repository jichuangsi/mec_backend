package com.jichuangsi.mes.controller;

import com.jichuangsi.mes.service.PackingService;
import com.jichuangsi.mes.service.ProductionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("后台-包装管理")
@CrossOrigin
@RestController
@RequestMapping("/packingController")
public class PackingController {


    @Resource
    private PackingService packingService;
}
