package io.hexagon.ddd.domain.model;

import javax.persistence.MappedSuperclass;

/**
 * @author Xuegui Yuan
 */
@MappedSuperclass
public abstract class AbstractAggregateRoot extends AbstractEntity implements AggregateRoot<Long> {
    @Override
    public void apply(DomainEvent domainEvent) {

    }
}
