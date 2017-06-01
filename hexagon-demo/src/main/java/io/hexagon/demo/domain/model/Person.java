package io.hexagon.demo.domain.model;

import io.hexagon.ddd.domain.model.AbstractEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Xuegui Yuan
 */
@Entity
@Table(name = "person")
@Getter
@Setter
public class Person extends AbstractEntity {
    private String email;
    private String name;
    private String displayName;

    @OneToOne(optional = false, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id", referencedColumnName = "id", unique = true)
    private User user;
}
