package io.hexagon.ddd.domain.model;

import java.util.Date;

/**
 * @author Xuegui Yuan
 */
public interface DomainEvent {

    int eventVersion();

    Date occurredOn();
}
