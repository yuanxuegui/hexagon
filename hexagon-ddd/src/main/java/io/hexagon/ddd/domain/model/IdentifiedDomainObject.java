package io.hexagon.ddd.domain.model;

import java.io.Serializable;

/**
 * @author Xuegui Yuan
 */
public interface IdentifiedDomainObject<ID extends Serializable> extends Serializable {
    ID getId();
}
