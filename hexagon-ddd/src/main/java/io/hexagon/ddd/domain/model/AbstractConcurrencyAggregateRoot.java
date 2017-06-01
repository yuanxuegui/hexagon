package io.hexagon.ddd.domain.model;

import javax.persistence.MappedSuperclass;

/**
 * @author Xuegui Yuan
 */
@MappedSuperclass
public class AbstractConcurrencyAggregateRoot extends AbstractConcurrencySafeEntity implements AggregateRoot<Long> {
    @Override
    public void apply(DomainEvent domainEvent) {

    }
}
