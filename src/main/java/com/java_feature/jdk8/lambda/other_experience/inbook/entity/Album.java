package com.java_feature.jdk8.lambda.other_experience.inbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alin
 * @version 1.0
 * @description // 专辑，由若干曲目组成。
 * @date 2019/5/31 13:00
 */

@AllArgsConstructor
@NoArgsConstructor
// == @ToString,@Getter,@Setter,@RequiredArgsConstructor,@EqualsAndHashCode。
// 不指定@Data的参数时为正常的构造器，加入参数 如 @Data("of")，则为静态构造 Artist.of()
@Data
public class Album {
    /**
     * 专辑名
     */
    private String name;
    /**
     * 专辑上所有曲目的列表。
     */
    private String tracks;

    /**
     * 参与创作本专辑的艺术家列表。
     */
    private String musicians;
}
