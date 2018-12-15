package org.acko.smartlife.models.dao.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author prabodh.hend
 */
@Data
@Entity
@Table(name = "checkup", indexes = {@Index(name = "idx_user_id", columnList = "user_id"),
        @Index(name = "idx_checkup_date", columnList = "checkup_date")})
@Where(clause = "is_deleted = 0")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Checkup extends BaseEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "checkup_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkupDate;

    @Column(name = "checkup_id")
    private String checkupId;

    @Column(name = "bill_generated")
    private Double billGenerated;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "amount_due")
    private Double amountDue;

    @Column(name = "is_rewarded")
    private boolean isRewarded;

//    @OneToMany(mappedBy = "checkup", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "checkup_id")
//    private List<CheckupDetails> checkupDetailsList = new ArrayList<>();

}
