package org.acko.smartlife.models.dao.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.acko.smartlife.constants.DataType;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author prabodh.hend
 */
@Data
@Entity
@Table(name = "checkup_details", indexes = {@Index(name = "idx_checkup_id", columnList = "checkup_id")})
@Where(clause = "is_deleted = 0")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckupDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "checkup_id")
    private String checkupId;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "value")
    private String value;

    @Column(name = "data_type")
    @Enumerated(EnumType.STRING)
    private DataType dataType;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted;

}
