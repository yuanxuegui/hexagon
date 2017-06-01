package io.hexagon.demo.domain.model;

import io.hexagon.ddd.domain.model.AbstractAggregateRoot;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

/**
 * @author Xuegui Yuan
 */
@Entity
@Table(name = "user")
@Data
public class User extends AbstractAggregateRoot {
    @NonNull
    private String username;

    @NonNull
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Person person;

    @Column(name = "is_locked")
    private boolean locked;

    public void changePersonName(String name) {
        this.person.setName(name);
    }
}
