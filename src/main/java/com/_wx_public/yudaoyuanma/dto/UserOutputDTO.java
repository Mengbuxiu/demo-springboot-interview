package com._wx_public.yudaoyuanma.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 * @desc 不应该直接返回 User 实体，因为如果这样的话，就暴露了太多实体相关的信息，这样的返回值是不安全的，
 *       所以我们更应该返回一个 DTO 对象，我们可称它为 UserOutputDTO：
 * @date 2019/4/27
 */
@Setter
@Getter
public class UserOutputDTO {
    private String userName;
    private Integer age;
    /**
     * 0 女，1 男
     */
    private Byte sex;
}
