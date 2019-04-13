package com.java_feature.tenum.entity;

import com.java_feature.tenum.annotation.InitSex;
import com.java_feature.tenum.annotation.ValidateAge;
import lombok.Getter;
import lombok.Setter;

/**
 * user
 *
 * @author zl
 */
@Setter
@Getter
public class User {
    private String username;
    @ValidateAge(min = 20, max = 35, value = 22)
    private int age;
    @InitSex(sex = InitSex.SEX_TYPE.MAN)
    private String sex;
}