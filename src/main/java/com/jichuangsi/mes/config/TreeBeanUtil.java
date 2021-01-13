package com.jichuangsi.mes.config;

import com.jichuangsi.mes.entity.RolePower;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TreeBeanUtil {
    public List menuList(List<RolePower> rolePowers){
        List list = new ArrayList();
        for (RolePower x : rolePowers) {
            Map mapArr = new LinkedHashMap();
            if(x.getFid() == 0){
                mapArr.put("id", x.getId());
                mapArr.put("label", x.getRolePowerName());
//                mapArr.put("spread",true);
                mapArr.put("parentId", x.getFid());
                mapArr.put("children", menuChild(x.getId(),rolePowers));
                list.add(mapArr);
            }
        }
        return list;
    }


    private List menuChild(Integer id,List<RolePower> rolePowers) {
        List lists = new ArrayList();
        for (RolePower  x : rolePowers) {
            Map childArray = new LinkedHashMap();
            if (x.getFid().equals(id)) {
                childArray.put("id", x.getId());
                childArray.put("label", x.getRolePowerName()+"");
//                childArray.put("spread",true);
                childArray.put("parentId", x.getFid());
                childArray.put("children", menuChild(x.getId(),rolePowers));
                lists.add(childArray);
            }
        }
        return lists;
    }
}
