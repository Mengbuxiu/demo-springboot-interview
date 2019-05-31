package com.java_feature.lambda.inbook.entity;

import lombok.*;

/**
 * @author Alin
 * @version 1.0
 * @description // 创作音乐的个人或团队。
 * @date 2019/5/31 13:00
 */

@AllArgsConstructor
@NoArgsConstructor
// == @ToString,@Getter,@Setter,@RequiredArgsConstructor,@EqualsAndHashCode。
// 不指定@Data的参数时为正常的构造器，加入参数 如 @Data("of")，则为静态构造 Artist.of()
@Data
public class Artist {
    /**
     * 艺术家的名字
     */
    private String name;
    /**
     * 乐队成员，该字段可为空
     */
    private String members;
    /**
     * 乐队来自哪里
     */
    private String origin;

}
