package com.xuyh.nms.modules.sys.web;

import com.xuyh.nms.modules.sys.dao.RoleMapper;
import com.xuyh.nms.modules.sys.entity.Role;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private RoleMapper roleMapper;

    public Role getRole(){
        return new Role();
    }
}
