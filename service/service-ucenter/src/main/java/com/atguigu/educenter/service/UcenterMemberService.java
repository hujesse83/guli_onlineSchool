package com.atguigu.educenter.service;

import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.educenter.entity.vo.UserLoginVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-14
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UserLoginVo userLoginVo);
}
