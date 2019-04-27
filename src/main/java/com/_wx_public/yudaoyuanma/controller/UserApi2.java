package com._wx_public.yudaoyuanma.controller;

import com._wx_public.yudaoyuanma.dto.UserInputDTO;
import com._wx_public.yudaoyuanma.dto.UserInputDTOConvert;
import com._wx_public.yudaoyuanma.entity.User;
import com._wx_public.yudaoyuanma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Administrator
 * @desc //TODO
 * @date 2019/4/27
 */
@RequestMapping("/v1/api/user")
@RestController

public class UserApi2 {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@Valid UserInputDTO userInputDTO, BindingResult bindingResult){
        checkDTOParams(bindingResult);
        User user = new UserInputDTOConvert().convert(userInputDTO);
        return userService.addUser(user);
    }
    private void checkDTOParams(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //throw new 带验证码的验证错误异常
        }
    }
}
