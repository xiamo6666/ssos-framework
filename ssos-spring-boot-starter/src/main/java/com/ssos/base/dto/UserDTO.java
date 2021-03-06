package com.ssos.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: UserDTO
 * @Description: TODD
 * @Author: xwl
 * @Date: 2018-12-24 16:26
 * @Vsersion: 1.0
 */
@Data
public class UserDTO {
    @ApiModelProperty("用户名")
    @NotBlank(message = "not null")
    private String username;
    @ApiModelProperty("密码")
    @NotBlank(message = "not null")
    private String password;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("地区")
    private String region;
}
