package com.atguigu.servicebase.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class BaseEntityVersion extends BaseEntity{
    @Version
    private Integer version;
}
