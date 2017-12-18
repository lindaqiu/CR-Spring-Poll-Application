package io.zipcoder.tc_spring_poll_application.repositories;

import io.zipcoder.tc_spring_poll_application.domain.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Query(value = "SELECT v.* " +
            "FROM Option o, Vote v " +
            "WHERE o.POLL_ID = ?1 " +
            "AND v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
    public Iterable<Vote> findVotesByPoll(Long pollId);
}

/*
The method findAll in the VoteRepository retrieves all votes in a Database rather than a given poll.
To ensure we can get votes for a given poll, we must add the code below to our VoteRepository.

The custom finder method findVotesByPoll takes the ID of the Poll as its parameter.
The @Query annotation on this method takes a native SQL query along with the nativeQuery flag set to true.
        At runtime, Spring Data JPA replaces the ?1 placeholder with the passed-in pollId parameter value.

*/