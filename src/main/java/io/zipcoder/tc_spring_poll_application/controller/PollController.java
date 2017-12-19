package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Poll;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.awt.print.Pageable;
import java.net.URI;

@RestController
public class PollController {


/*

Create a PollController class in the controller sub package.

PollController signature should be annotated with @RestController
PollController has a pollRepository instance variable of type PollRepository

pollRepository should be annotated with @Inject

 */
@Inject
private PollRepository pollRepository;

    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {

        Poll poll = pollRepository.findOne(pollId);

        if(poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        } }

    @GetMapping("/polls")
    public ResponseEntity<Page<Poll>> getAllPolls(Pageable pageable) {

        Page<Poll> allPolls = pollRepository.findAll(pageable);

        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {

        poll = pollRepository.save(poll);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId()) //Class UriComponentsBuilder
                .toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        Poll p = pollRepository.findOne(pollId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping ("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.delete(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected void verifyPoll(Long pollId)throws ResourceNotFoundException{
        Poll poll = pollRepository.findOne(pollId);
        if(poll == null) {
            throw new ResourceNotFoundException();
        } }

    /* Create a void method in PollController called verifyPoll
    that checks if a specific poll id exists
    and throws a ResourceNotFoundException if not.
    Use this in any method that searches for or
    updates an existing poll (eg: Get, Put, and Delete methods).

    Note: This means that trying to submit a PUT request
    for a resource that doesn't exist will not implicitly create it; it should throw a 404 instead.
     */




}



//The method definition below supplies a GET request on the /polls endpoint which provides
// a collection of all of the polls available in the QuickPolls application.

//The method above begins with reading all of the polls using the PollRepository.
//We then create an instance of ResponseEntity and pass in Poll data and the HttpStatus.OK status value.
// The Poll data becomes part of the response body and OK (code 200) becomes the response status code.