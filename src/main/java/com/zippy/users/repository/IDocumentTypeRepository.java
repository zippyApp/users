package com.zippy.users.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zippy.users.model.DocumentType;

@Repository
public interface IDocumentTypeRepository extends JpaRepository<DocumentType, Integer>{

    DocumentType findByName(String name);
}
