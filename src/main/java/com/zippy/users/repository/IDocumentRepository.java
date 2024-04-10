package com.zippy.users.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zippy.users.model.Document;

@Repository
public interface IDocumentRepository extends JpaRepository<Document, Long>{
  
}
