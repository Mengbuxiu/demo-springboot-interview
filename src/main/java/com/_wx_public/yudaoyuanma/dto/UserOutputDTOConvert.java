package com._wx_public.yudaoyuanma.dto;

import com._wx_public.yudaoyuanma.entity.User;
import com._wx_public.yudaoyuanma.interf.DTOConvert;
import org.springframework.beans.BeanUtils;

public class UserOutputDTOConvert implements DTOConvert<User,UserOutputDTO> {
    @Override
    public UserOutputDTO convert(User user) {
        UserOutputDTO userOutputDTO = new UserOutputDTO();
        BeanUtils.copyProperties(user, userOutputDTO);
        return userOutputDTO;
    }
}