package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_event")
@Getter
@Setter

public class EventEntities extends Event {

    @Id


}
