package io.hexagon.ddd.domain.model;

import java.io.Serializable;

/**
 * @author Xuegui Yuan
 */
public interface ConcurrencySafeAggregateRoot<ID extends Serializable> extends ConcurrencySafeEntity<ID>  {
}
