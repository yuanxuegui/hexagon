package io.hexagon.ddd.domain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Xuegui Yuan
 */
public interface Entity<ID extends Serializable> extends IdentifiedDomainObject<ID> {
}
