package org.acko.smartlife.service.integration.impl;

import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.models.dao.integration.User;
import org.acko.smartlife.service.integration.UserService;
import org.springframework.stereotype.Service;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public User validate(Long userId) {
        User user = new User();
        user.setId(userId);
        return user;
    }

}
