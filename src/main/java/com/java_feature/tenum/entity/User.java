package com.java_feature.tenum.entity;

import com._wx_public.yudaoyuanma.entity.Student;
import com.java_feature.tenum.annotation.InitSex;
import com.java_feature.tenum.annotation.ValidateAge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * user
 *
 * @author zl
 */
@Setter
@Getter
@AllArgsConstructor
public class User implements Comparable<User>{
    private String username;
    @ValidateAge(min = 20, max = 35, value = 22)
    private int age;
    @InitSex(sex = InitSex.SEX_TYPE.MAN)
    private String sex;

    @Override
    public int compareTo(User u) {
        return this.username.compareTo(u.getUsername());
    }
}