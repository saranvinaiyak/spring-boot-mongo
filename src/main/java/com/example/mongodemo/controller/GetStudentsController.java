package com.example.mongodemo.controller;

import com.example.mongodemo.core.domain.StudentDetails;
import com.example.mongodemo.core.service.GetStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class GetStudentsController {

    private static final Logger LOG = Logger.getLogger(GetStudentsController.class.getName());

    private @Autowired GetStudentsService getStudentsService;

    @GetMapping(value = "/display/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDetails>> getStudentDetails()
    {
        ResponseEntity<List<StudentDetails>> responseEntity;

        try
        {
            List<StudentDetails> studentDetailsList = getStudentsService.studentDetailsList();
            responseEntity = new ResponseEntity<>(studentDetailsList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            LOG.severe("An exception occurred while trying to get student list. " + e.getMessage());
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
