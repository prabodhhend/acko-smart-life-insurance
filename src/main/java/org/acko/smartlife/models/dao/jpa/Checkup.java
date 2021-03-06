package org.acko.smartlife.models.dao.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "checkup_type")
    private String checkupType;

    @Column(name = "bill_generated")
    private Double billGenerated = 0D;

    @Column(name = "amount_paid")
    private Double amountPaid = 0D;

    @Column(name = "amount_due")
    private Double amountDue = 0D;

    @Column(name = "is_rewarded")
    private boolean isRewarded;

}
