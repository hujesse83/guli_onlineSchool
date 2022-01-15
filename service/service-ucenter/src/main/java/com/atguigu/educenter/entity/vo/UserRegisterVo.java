package com.atguigu.educenter.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author jesse.hu
 * @date 2022/1/15 10:24
 */
@Data
public class UserRegisterVo {
    @ApiModelProperty(value = "昵称")
    @Size(min = 4,max = 16 ,message = "nickName's length must between 4 and 16")
    private String nickname;
    @ApiModelProperty(value = "手机号")
    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$")
    private String mobile;
    @ApiModelProperty(value = "密码")
    @Size(min = 8,max = 16 ,message = "nickName's length must between 8 and 16")
    private String password;
    @ApiModelProperty(value = "验证码")
    @Size(min = 4,max = 4 ,message = "code error")
    private String code;
}
