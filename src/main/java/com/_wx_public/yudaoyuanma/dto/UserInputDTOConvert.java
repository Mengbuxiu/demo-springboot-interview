package com._wx_public.yudaoyuanma.dto;

import com._wx_public.yudaoyuanma.entity.User;
import com._wx_public.yudaoyuanma.interf.DTOConvert;
import org.springframework.beans.BeanUtils;

public class UserInputDTOConvert implements DTOConvert<UserInputDTO,User> {
    @Override
    public User convert(UserInputDTO userInputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userInputDTO, user);
        return user;
    }

    /**
     * 测试spring的beanutils如果参数个数不对应怎么办
     * 结论：只会浅克隆匹配的属性和类型
     * @param args
     */
   /* public static void main(String[] args) {
        UserInputDTO userInputDTO = new UserInputDTO();
        userInputDTO.setAge(11);
        userInputDTO.setUserName("Alin");
        userInputDTO.setSex((byte) 1);
        User user = new UserInputDTOConvert().convert(userInputDTO);
        System.out.println(user);
        //User(userName=Alin, age=11)
    }*/
}