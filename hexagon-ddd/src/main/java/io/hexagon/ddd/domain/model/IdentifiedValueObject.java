package io.hexagon.ddd.domain.model;

import java.io.Serializable;

/**
 * @author Xuegui Yuan
 */
public interface IdentifiedValueObject<ID extends Serializable> extends IdentifiedDomainObject<ID> {
}
