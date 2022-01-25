package com.atguigu.aclservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jesse.hu
 * @date 2022/1/24 23:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionRole {
    private String roleId;
    private String permissionIds;
}
