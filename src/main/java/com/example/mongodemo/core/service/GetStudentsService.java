package com.example.mongodemo.core.service;

import com.example.mongodemo.core.documententity.StudentDetailDocumentEntity;
import com.example.mongodemo.core.domain.StudentDetails;
import com.example.mongodemo.core.repository.StudentDtlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class GetStudentsService {

    private @Autowired StudentDtlRepository studentDtlRepository;

    public List<StudentDetails> studentDetailsList()
    {
        List<StudentDetailDocumentEntity> studentDetailDocumentEntities = studentDtlRepository.findAll();
        return copyStudentDetails(studentDetailDocumentEntities);
    }

    private static List<StudentDetails> copyStudentDetails(List<StudentDetailDocumentEntity> studentDetailDocumentEntities)
    {
        List<StudentDetails> studentDetailsList = new ArrayList<>();

        if(Objects.nonNull(studentDetailDocumentEntities) && !studentDetailDocumentEntities.isEmpty())
        {
            studentDetailDocumentEntities.forEach((e) -> {
                if (Objects.nonNull(e)) studentDetailsList.add(copyStudentDetails(e));
            });
        }

        return studentDetailsList;
    }

    private static StudentDetails copyStudentDetails(StudentDetailDocumentEntity studentDetailDocumentEntity)
    {
        StudentDetails studentDetails = new StudentDetails();

        studentDetails.setId(studentDetailDocumentEntity.getId());
        studentDetails.setRollNo(studentDetailDocumentEntity.getRollNo());
        studentDetails.setStudentName(studentDetailDocumentEntity.getStudentName());
        studentDetails.setBranch(studentDetailDocumentEntity.getBranch());
        studentDetails.setSection(studentDetailDocumentEntity.getSection());
        studentDetails.setYear(studentDetailDocumentEntity.getYear());
        studentDetails.setDateOfBirth(studentDetailDocumentEntity.getDateOfBirth());

        return studentDetails;
    }

}
