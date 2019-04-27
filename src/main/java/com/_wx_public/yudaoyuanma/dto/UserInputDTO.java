package com._wx_public.yudaoyuanma.dto;

import lombok.Getter;
import lombok.Setter;

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
}
