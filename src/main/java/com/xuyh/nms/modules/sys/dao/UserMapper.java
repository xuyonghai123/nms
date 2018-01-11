package com.xuyh.nms.modules.sys.dao;

import com.xuyh.nms.modules.sys.entity.User;
import org.springframework.stereotype.Service;


@Service
public interface UserMapper {
    public User findUserByName(String username);
}
