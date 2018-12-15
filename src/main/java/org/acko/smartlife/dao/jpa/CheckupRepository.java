package org.acko.smartlife.dao.jpa;

import org.acko.smartlife.models.dao.jpa.Checkup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Repository
public interface CheckupRepository extends JpaRepository<Checkup, String> {

    List<Checkup> findByUserId(Long userId);
}
