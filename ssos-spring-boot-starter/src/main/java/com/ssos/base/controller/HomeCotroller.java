package com.ssos.base.controller;

import com.ssos.base.model.DataResult;
import com.ssos.base.utils.UserUtils;
import com.ssos.base.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HomeCotroller
 * @Description: TODD
 * @Author: xwl
 * @Date: 2019-05-10 08:23
 * @Vsersion: 1.0
 */
@RestController
@Api(tags = "基本")
public class HomeCotroller {
    @GetMapping("/login")
    public DataResult login(){
        return DataResult.error("Token验证已过期");
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("获取当前登入用户的基本信息")
    public DataResult<UserVO> getUserInfo(){
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(UserUtils.getUser(),userVO);
        return DataResult.ok(userVO);
    }
}
