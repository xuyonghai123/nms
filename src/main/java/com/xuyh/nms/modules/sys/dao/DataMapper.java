package com.xuyh.nms.modules.sys.dao;

import com.xuyh.nms.modules.sys.entity.Datas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DataMapper {
    List<Datas> findData();
}
