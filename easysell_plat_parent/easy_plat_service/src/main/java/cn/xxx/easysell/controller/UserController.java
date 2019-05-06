package cn.xxx.easysell.controller;

import cn.xxx.easysell.domain.User;
import cn.xxx.easysell.util.AjaxResult;
import com.netflix.discovery.util.StringUtil;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){
        if(user!=null&& !StringUtils.isEmpty(user.getUsername())&&!StringUtils.isEmpty(user.getPwd())){
            if("admin".equals(user.getUsername())&&"123".equals(user.getPwd())){
                return AjaxResult.me();
            }
        }
        return AjaxResult.me().setSuccess(false).setMsg("登录失败");
    }
    @RequestMapping("/test")
    public AjaxResult tset(){
        return AjaxResult.me();
    }

}
