package com.example.mongodemo.controller;

import com.example.mongodemo.core.domain.AddStudentRequest;
import com.example.mongodemo.core.service.AddStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class AddStudentController {

    private static final Logger LOG = Logger.getLogger(AddStudentController.class.getName());

    private @Autowired AddStudentService addStudentService;

    @PostMapping(value = "/add/student", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addStudent(@RequestBody AddStudentRequest addStudentRequest)
    {
        ResponseEntity<Boolean> responseEntity;

        try
        {
            Boolean studentAdded = addStudentService.addStudent(addStudentRequest);
            responseEntity = new ResponseEntity<>(studentAdded, HttpStatus.OK);
        }
        catch (Exception e)
        {
            LOG.severe("An exception occurred while trying to add student. " + e.getMessage());
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


}
