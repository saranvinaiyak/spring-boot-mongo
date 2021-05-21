package com.example.mongodemo.core.service;

import com.example.mongodemo.core.documententity.StudentDetailDocumentEntity;
import com.example.mongodemo.core.domain.AddStudentRequest;
import com.example.mongodemo.core.repository.StudentDtlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AddStudentService {

    private @Autowired StudentDtlRepository studentDtlRepository;

    public boolean addStudent(AddStudentRequest addStudentRequest)
    {

        if(Objects.isNull(addStudentRequest))
        {
            return false;
        }

        StudentDetailDocumentEntity studentDetailDocumentEntity = getStudentDocumentEntity(addStudentRequest);

        studentDtlRepository.save(studentDetailDocumentEntity);

        return true;
    }

    private static StudentDetailDocumentEntity getStudentDocumentEntity(AddStudentRequest addStudentRequest)
    {
        StudentDetailDocumentEntity studentDetailDocumentEntity = new StudentDetailDocumentEntity();

        studentDetailDocumentEntity.setStudentName(addStudentRequest.getStudentName());
        studentDetailDocumentEntity.setBranch(addStudentRequest.getBranch());
        studentDetailDocumentEntity.setDateOfBirth(addStudentRequest.getDateOfBirth());
        studentDetailDocumentEntity.setRollNo(addStudentRequest.getRollNo());
        studentDetailDocumentEntity.setSection(addStudentRequest.getSection());
        studentDetailDocumentEntity.setYear(addStudentRequest.getYear());

        return studentDetailDocumentEntity;
    }

}
