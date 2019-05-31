package com.java_feature.lambda.inbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alin
 * @version 1.0
 * @description // 专辑中的一支曲目。
 * @date 2019/5/31 13:00
 */

@AllArgsConstructor
@NoArgsConstructor
// == @ToString,@Getter,@Setter,@RequiredArgsConstructor,@EqualsAndHashCode。
// 不指定@Data的参数时为正常的构造器，加入参数 如 @Data("of")，则为静态构造 Artist.of()
@Data
public class Track {
    /**
     * 曲目名
     */
    private String name;
}
