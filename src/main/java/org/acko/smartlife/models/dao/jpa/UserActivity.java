package org.acko.smartlife.models.dao.jpa;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_activity", indexes = {@Index(name = "idx_user_id", columnList = "user_id")})
@Where(clause = "is_deleted = 0")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserActivity extends BaseEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_calories")
    private Double totalCalories = 0D;

}


