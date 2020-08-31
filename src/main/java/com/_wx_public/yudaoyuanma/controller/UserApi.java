package com._wx_public.yudaoyuanma.controller;

import com._wx_public.yudaoyuanma.dto.UserInputDTO;
import com._wx_public.yudaoyuanma.entity.User;
import com._wx_public.yudaoyuanma.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DTO 转化
 */
@RequestMapping("/v1/api/user")
@RestController
public class UserApi {

    private final UserService userService;

    /**
     * 看来 spring支持在构造器上注入了，上面的#userService 被表示为final了
     * @param userService
     */
    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(UserInputDTO userInputDTO){
        /**
         * 上边的代码，从逻辑上讲，是没有问题的，只是这种写法让我很厌烦，例子中只有两个字段，如果有 20 个字段，我们要如何做呢？
         * 一个一个进行 set 数据吗？当然，如果你这么做了，肯定不会有什么问题，但是，这肯定不是一个最优的做法。
         * 网上有很多工具，支持浅拷贝或深拷贝的 Utils。举个例子，我们可以使用
         * org.springframework.beans.BeanUtils#copyProperties 对代码进行重构和优化：
         */

        /**
         * 这样写显得很繁琐，还不易读，用@Accessors(chain = true)
         */
        /*User user1 = new User();
        user1.setUserName(userInputDTO.getUserName());
        user1.setAge(userInputDTO.getAge());*/
        /**
         * 这样写是不是很舒服
         * 关于链式调用可以参考src\main\java\com\thinkinjava\basic\_10_6\Parcel7_1.java
         */
        User user2 = new User();
//        user2.setUserName("Alin").setAge(11);
        /**
         * BeanUtils.copyProperties 是一个浅拷贝方法，复制属性时，
         * 我们只需要把
         ***** DTO 对象和要转化的对象两个的属性值设置为一样的名称，并且保证一样的类型就可以了。
         * 如果你在做 DTO 转化的时候一直使用 set 进行属性赋值，那么请尝试这种方式简化代码，让代码更加清晰!
         */
        //虽然这段代码很好的简化和优化了代码，但是他的语义是有问题的，我们需要提现一个转化过程才好，所以代码改成如下：
        // Ctrl + Alt + M  不得不说，这代码生成的很IntelliJ
        /**
         * 这两段代码都没有暴露实现，都是在讲如何在同一个方法中，做一组相同层次的语义操作，而不是暴露具体的实现。
         * 如上所述，是一种重构方式，读者可以参考 Martin Fowler 的
         * 《Refactoring Imporving the Design of Existing Code》(重构 改善既有代码的设计) 这本书中的 Extract Method 重构方式。
         * ----幸好趁当当打折买了这本书哈哈哈
         */
        User user = convertFor(userInputDTO);
        return userService.addUser(user);
    }

    private User convertFor(UserInputDTO userInputDTO) {
        User user = new User();
        BeanUtils.copyProperties(userInputDTO,user);
        return user;
    }
}