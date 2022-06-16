package entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "states_history")
public class StateHistory {
    @Id
    @SequenceGenerator(name = "stateHistorySeq", sequenceName = "stateHistory_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "stateHistorySeq")
    public Long id;
    public Timestamp date;
    public String answer;
    public State state;
}
