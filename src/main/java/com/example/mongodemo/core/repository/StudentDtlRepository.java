package com.example.mongodemo.core.repository;

import com.example.mongodemo.core.documententity.StudentDetailDocumentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDtlRepository extends MongoRepository<StudentDetailDocumentEntity, String> {
}
