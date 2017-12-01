package io.zipcoder.tc_spring_poll_application.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue
    @Column(name = "POLL_ID")
    private Long id;

    @Column(name= "QUESTION")
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    private Set<Option> options;

    public Long getID(){
        return this.id;
    }

    public String getQuestion(){
        return this.question;
    }

    public Set<Option> getSet(){
        return this.options;
    }

}
