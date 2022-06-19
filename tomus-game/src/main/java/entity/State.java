package entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "states")
public class State extends PanacheEntityBase {
    @Id
    public UUID id;
    public String word;
    public Integer tries;
    @OneToOne
    public User user;
}
