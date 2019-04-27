package com._wx_public.yudaoyuanma.dto;

import com._wx_public.yudaoyuanma.entity.User;
import com._wx_public.yudaoyuanma.interf.DTOConvert;
import com.google.common.base.Converter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @author Administrator
 * @desc //封装的用户传输对象
 * @date 2019/4/27
 */
@Setter
@Getter
public class UserInputDTO {
    private String userName;
    private Integer age;
    /**
     * 0 女，1 男
     */
    private Byte sex;


    /**
     * 每一个转化对象都是由在遇到 DTO 转化的时候才会出现，那我们应该考虑一下，是否可以将这个类和 DTO 进行聚合呢
     * 内部类的正确实现姿势
     * @return
     */
    public User convertToUser(){
        UserInputDTOConvert userInputDTOConvert = new UserInputDTOConvert();
        return userInputDTOConvert.convert(this);
    }

//    private static class UserInputDTOConvert implements DTOConvert<UserInputDTO,User> {
//        @Override
//        public User convert(UserInputDTO userInputDTO) {
//            User user = new User();
//            BeanUtils.copyProperties(userInputDTO,user);
//            return user;
//        }
//    }
private static class UserInputDTOConvert extends Converter<UserInputDTO, User> {
    @Override
    protected User doForward(UserInputDTO userInputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userInputDTO,user);
        return user;
    }

    @Override
    protected UserInputDTO doBackward(User user) {
        UserInputDTO userInputDTO = new UserInputDTO();
        BeanUtils.copyProperties(user,userInputDTO);
        return userInputDTO;
    }
}
}
