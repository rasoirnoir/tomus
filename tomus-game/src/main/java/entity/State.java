package entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class State {
    @Id
    public UUID id;
    public String word;
    public Integer tries;
    public User user;
}
