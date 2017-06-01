package io.hexagon.demo.domain.model;

import io.hexagon.ddd.domain.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Xuegui Yuan
 */
@Entity
@Table(name = "person")
@Data
public class Person extends AbstractEntity {
    private String email;
    private String name;
    private String displayName;

    @OneToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id", referencedColumnName = "id", unique = true)
    private User user;
}
