package com.example.mongodemo.controller;

import com.example.mongodemo.core.domain.StudentDetails;
import com.example.mongodemo.core.service.DeleteStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DeleteStudentController {

    private static final Logger LOG = Logger.getLogger(DeleteStudentController.class.getName());

    private @Autowired DeleteStudentService deleteStudentService;

    @DeleteMapping(value = "/delete/student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") String id)
    {
        ResponseEntity<String> responseEntity;

        try
        {
            String response = deleteStudentService.deleteStudent(id);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            LOG.severe("An exception occurred while trying to delete student. " + e.getMessage());
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

}
