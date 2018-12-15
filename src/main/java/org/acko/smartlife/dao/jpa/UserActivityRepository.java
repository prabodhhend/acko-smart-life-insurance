package org.acko.smartlife.dao.jpa;

import org.acko.smartlife.models.dao.jpa.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UserActivityRepository extends JpaRepository<UserActivity,Integer> {



    List<UserActivity> findByUserIdAndCreatedAtBetween(Long userId,Date start, Date end);
}
