package entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "roleSeq")
    public Long id;
    public String role;
}
