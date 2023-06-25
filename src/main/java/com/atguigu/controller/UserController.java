package com.atguigu.controller;

import com.atguigu.domain.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     // 组合 @Controller 和 @ResponseBody
public class UserController {

    @Autowired
    UserService userService;

     // @RequestMapping(value = "/findAll",method = RequestMethod.GET) 等价于 @GetMapping("/findAll")
     // @RequestMapping(value = "/findAll",method = RequestMethod.POST) 等价于  @PostMapping("/findAll")
     // @RequestMapping(value = "/findAll",method = RequestMethod.DELETE) 等价于 @DeleteMapping("/findAll")
     // @RequestMapping(value = "/findAll",method = RequestMethod.PUT) 等价于 @PutMapping("/findAll")
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
}
