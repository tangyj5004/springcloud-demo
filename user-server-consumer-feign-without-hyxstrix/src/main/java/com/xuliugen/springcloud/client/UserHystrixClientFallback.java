package com.xuliugen.springcloud.client;

import com.xuliugen.springcloud.bean.User;
import org.springframework.stereotype.Component;

/**
 * Created by xuliugen on 2017/8/29.
 */
@Component
public class UserHystrixClientFallback implements UserFeignHyxstrixClient {

    @Override
    public User getById(String id) {
        User user = new User();
        user.setId("1234567890");
        return user;
    }

}
