package org.acko.smartlife.service.integration;

import org.acko.smartlife.models.dao.integration.User;

/**
 * @author prabodh.hend
 */
public interface UserService {

    public User validate(Long userId);
}
