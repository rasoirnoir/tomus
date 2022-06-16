package entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Id
    public UUID id;
    public String mail;
    public String username;
    public String password;
    public boolean active;
    public State state;
}
