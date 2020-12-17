package com.didi.日记总结;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2020/12/17 下午9:12
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = list.stream().map(value -> value).collect(Collectors.toList());
        Map<Object, Object> res = doRpcInvoke2(collect);
        for (Integer integer : list) {
            // error
            // Integer result = doRpcInvoke(integer);//假设rpc调用耗时50ms
            // do sth...

            // correct
            if (res.get(integer) != null) {
                // do sth...
            }
        }
    }

    private static Integer doRpcInvoke(Integer integer) {
        return 1;
    }
    private static Map<Object, Object> doRpcInvoke2(List<Integer> integers) {
        return Collections.emptyMap();
    }
}
