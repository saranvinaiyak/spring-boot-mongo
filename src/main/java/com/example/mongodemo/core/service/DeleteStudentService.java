package com.example.mongodemo.core.service;

import com.example.mongodemo.core.repository.StudentDtlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DeleteStudentService {

    private @Autowired StudentDtlRepository studentDtlRepository;

    public String deleteStudent(String id)
    {
        if(Objects.nonNull(id) && !"".equals(id.trim()))
        {
            studentDtlRepository.deleteById(id);
        }

        return "DELETED";
    }

}
