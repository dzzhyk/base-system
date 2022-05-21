package com.yankaizhang.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yankaizhang.common.utils.StringUtils;
import com.yankaizhang.framework.security.RegisterBody;
import com.yankaizhang.framework.security.service.SysRegisterService;
import com.yankaizhang.framework.web.controller.BaseController;
import com.yankaizhang.framework.web.domain.AjaxResult;

/**
 * 注册验证
 *
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
