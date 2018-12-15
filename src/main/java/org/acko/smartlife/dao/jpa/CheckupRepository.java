package org.acko.smartlife.dao.jpa;

import org.acko.smartlife.models.dao.jpa.Checkup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Repository
public interface CheckupRepository extends JpaRepository<Checkup, String> {

    List<Checkup> findByUserId(Long userId);

    @Query(value = "select * from `checkup` where `is_deleted`=0 and `user_id`= :userId order by id desc limit 1;",nativeQuery = true)
    Checkup findLatest(@Param("userId") Long userId);
}
