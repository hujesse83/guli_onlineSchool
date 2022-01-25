package com.atguigu.aclservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.aclservice.constans.PermissionConstants;
import com.atguigu.aclservice.entity.Permission;
import com.atguigu.aclservice.entity.RolePermission;
import com.atguigu.aclservice.entity.User;
import com.atguigu.aclservice.helper.MemuHelper;
import com.atguigu.aclservice.helper.PermissionHelper;
import com.atguigu.aclservice.mapper.PermissionMapper;
import com.atguigu.aclservice.service.PermissionService;
import com.atguigu.aclservice.service.RolePermissionService;
import com.atguigu.aclservice.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private RolePermissionService rolePermissionService;
    
    @Autowired
    private UserService userService;
    
    //获取全部菜单
    @Override
    public List<Permission> queryAllMenu() {

        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<Permission> permissionList = baseMapper.selectList(wrapper);

        List<Permission> result = bulid(permissionList);

        return result;
    }

    //根据角色获取菜单
    @Override
    public List<Permission> selectAllMenu(String roleId) {
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));

        //根据角色id获取角色权限
        List<RolePermission> rolePermissionList = rolePermissionService.list(new QueryWrapper<RolePermission>().eq("role_id",roleId));
        //转换给角色id与角色权限对应Map对象
//        List<String> permissionIdList = rolePermissionList.stream().map(e -> e.getPermissionId()).collect(Collectors.toList());
//        allPermissionList.forEach(permission -> {
//            if(permissionIdList.contains(permission.getId())) {
//                permission.setSelect(true);
//            } else {
//                permission.setSelect(false);
//            }
//        });
        for (int i = 0; i < allPermissionList.size(); i++) {
            Permission permission = allPermissionList.get(i);
            for (int m = 0; m < rolePermissionList.size(); m++) {
                RolePermission rolePermission = rolePermissionList.get(m);
                if(rolePermission.getPermissionId().equals(permission.getId())) {
                    permission.setSelect(true);
                }
            }
        }


        List<Permission> permissionList = bulid(allPermissionList);
        return permissionList;
    }


    //递归删除菜单
    @Override
    public void removeChildById(String id) {
        List<String> idList = new ArrayList<>();
        this.selectChildListById(id, idList);

        idList.add(id);
        baseMapper.deleteBatchIds(idList);
    }

    //根据用户id获取用户菜单
    @Override
    public List<String> selectPermissionValueByUserId(String id) {

        List<String> selectPermissionValueList = null;
        if(this.isSysAdmin(id)) {
            //如果是系统管理员，获取所有权限
            selectPermissionValueList = baseMapper.selectAllPermissionValue();
        } else {
            selectPermissionValueList = baseMapper.selectPermissionValueByUserId(id);
        }
        return selectPermissionValueList;
    }

    @Override
    public List<JSONObject> selectPermissionByUserId(String userId) {
        List<Permission> selectPermissionList = null;
        if(this.isSysAdmin(userId)) {
            //如果是超级管理员，获取所有菜单
            selectPermissionList = baseMapper.selectList(null);
        } else {
            selectPermissionList = baseMapper.selectPermissionByUserId(userId);
        }

        List<Permission> permissionList = PermissionHelper.bulid(selectPermissionList);
        List<JSONObject> result = MemuHelper.bulid(permissionList);
        return result;
    }

    /**
     * 判断用户是否系统管理员
     * @param userId
     * @return
     */
    private boolean isSysAdmin(String userId) {
        User user = userService.getById(userId);

        if(null != user && "admin".equals(user.getUsername())) {
            return true;
        }
        return false;
    }

    /**
     *	递归获取子节点
     * @param id
     * @param idList
     */
    private void selectChildListById(String id, List<String> idList) {
        List<Permission> childList = baseMapper.selectList(new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }

    /**
     * 使用递归方法建菜单
     * @param treeNodes
     * @return
     */
    private static List<Permission> bulid(List<Permission> treeNodes) {
        List<Permission> trees = new ArrayList<>();
        for (Permission treeNode : treeNodes) {
            if ("0".equals(treeNode.getPid())) {
                treeNode.setLevel(1);
                trees.add(findChildren(treeNode,treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param treeNodes
     * @return
     */
    private static Permission findChildren(Permission treeNode,List<Permission> treeNodes) {
        treeNode.setChildren(new ArrayList<Permission>());

        for (Permission it : treeNodes) {
            if(treeNode.getId().equals(it.getPid())) {
                int level = treeNode.getLevel() + 1;
                it.setLevel(level);
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return treeNode;
    }


    //========================DFS递归查询所有菜单================================================
    //获取全部菜单
    @Override
    public List<Permission> getAllMenuList() {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        List<Permission> allPermissionList = baseMapper.selectList(wrapper);
        return getPermissionListBFS(allPermissionList);
    }

    private List<Permission> getPermissionListDFS(List<Permission> allPermissionList) {
        List<Permission> resNodeList = new ArrayList<>();
        for(Permission permissionNode : allPermissionList) {
            if(PermissionConstants.PERMISSION_PID.equals(permissionNode.getPid())) { // 寻找顶层（一级菜单）
                permissionNode.setLevel(1);
                Permission permissionItem = selectChildrenDFS(permissionNode, allPermissionList);
                resNodeList.add(permissionItem);
            }
        }
        return resNodeList;
    }

    private Permission selectChildrenDFS(Permission parentNode, List<Permission> allPermissionList) {
        for(Permission item : allPermissionList) {
            if(parentNode.getId().equals(item.getPid())) {
                //把父菜单的level值+1
                int level = parentNode.getLevel()+1;
                item.setLevel(level);
                //把查询出来的子菜单放到父菜单里面
                parentNode.setChildren(new ArrayList<>());
                Permission childrenNode = selectChildrenDFS(item, allPermissionList);
                parentNode.getChildren().add(childrenNode);
            }
        }
        return parentNode;
    }

    //========================BFS递归查询所有菜单================================================
    private List<Permission> getPermissionListBFS(List<Permission> allPermissionList) {
        Deque<Permission> deque = new ArrayDeque<>();
        List<Permission> resNodeList = new ArrayList<>();
        for(Permission permissionNode : allPermissionList) {
            if(PermissionConstants.PERMISSION_PID.equals(permissionNode.getPid())) { // 寻找顶层（一级菜单）
                permissionNode.setLevel(1);
                deque.add(permissionNode);
                resNodeList.add(permissionNode);
            }
        }
        while (!deque.isEmpty()){
            int size = deque.size();
            while(size>0){
                Permission node = deque.poll();
                List<Permission> childrenList = getChildrenByPId(node, allPermissionList);
                if (childrenList==null){
                    size--;
                    continue;
                }
                for (Permission permission : childrenList) {
                    permission.setLevel(node.getLevel() + 1);
                    deque.offer(permission);
                }
                node.setChildren(childrenList);
                size--;
            }
        }
        return resNodeList;
    }

    public static List<Permission> getChildrenByPId(Permission permission,List<Permission> allPermissionList){
        return allPermissionList.stream().filter(item-> item.getPid().equals(permission.getId())).collect(Collectors.toList());
    }



    //============递归删除菜单, 因为是管理员才能操作, 并且菜单不会有很多级. 菜单有很多集采用bfs.
    @Override
    public void removeChildByIdGuli(String id) {
        List<String> idList = new ArrayList<>();
        selectPermissionChildById(id,idList);
        idList.add(id);
        baseMapper.deleteBatchIds(idList);
    }

    private void selectPermissionChildById(String id, List<String> idList) {
        QueryWrapper<Permission>  wrapper = new QueryWrapper<>();
        wrapper.eq("pid",id);
        wrapper.select("id");   // 查处指定列
        List<Permission> childIdList = baseMapper.selectList(wrapper);
        for (Permission childPermission : childIdList) {
            idList.add(childPermission.getId());
            selectPermissionChildById(childPermission.getId(), idList);
        }
    }

    //=========================给角色分配菜单=======================

    /**
     * @param roleId 角色Id
     * @param permissionIds 菜单Ids,
     * 给角色分配多个permission
     */
    @Override
    public void assignPermissionByRoleId(String roleId,String[] permissionIds) {
        rolePermissionService.remove(new QueryWrapper<RolePermission>().eq("role_id", roleId));
        List<RolePermission> rolePermissionList = new ArrayList<>();
        //遍历所有菜单数组
        for(String perId : permissionIds) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(perId);
            rolePermissionList.add(rolePermission);
        }
        rolePermissionService.saveBatch(rolePermissionList); // 多个insert.
    }
}
