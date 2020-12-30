package com.jichuangsi.mes.common;

import com.jichuangsi.mes.repository.SCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//生成编号
@Component
public class GenerationNumberConfig {
    private static GenerationNumberConfig gn;

    @Value("${mes.staffNumber}")
    private static String staffNum;


    @Autowired
    private SCustomerRepository crepository;


    @PostConstruct
    public void init(){
        gn = this;
        gn.crepository = this.crepository;
    }

    /**
     * 生成员工编号
     * @return
     */
    public static String getStaffNumber(){
        Integer count =gn.crepository.countByallId();
        String staffNumber = staffNum+"000"+count;
        return staffNumber;
    }

    public static void main(String[] args) {

        System.out.print(getStaffNumber());

    }


}
