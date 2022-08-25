package com.qlq.cloudalibabaseataorder8801.mapper;

import org.apache.ibatis.annotations.Insert;

public interface OrderMapper {
    @Insert("insert into `order` (count) values (1)")
    void create();
}
