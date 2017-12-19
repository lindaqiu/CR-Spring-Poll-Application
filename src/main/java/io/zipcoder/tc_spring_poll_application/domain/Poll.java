package io.zipcoder.tc_spring_poll_application.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Poll{

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

    public Long getPollId(){
        return this.id;
    }


    public String getPollQuestion(){
        return this.question;
    }

    public Set<Option> getSet(){
        return this.options;
    }

}
