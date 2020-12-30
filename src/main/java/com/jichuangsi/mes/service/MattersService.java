package com.jichuangsi.mes.service;

import com.jichuangsi.mes.repository.MattersRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//办事项
@Service
public class MattersService {


    @Resource
    private MattersRepository mattersRepository;


}
