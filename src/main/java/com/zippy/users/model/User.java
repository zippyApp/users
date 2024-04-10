package com.zippy.users.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number")
  private String phone;

  @Column(name = "birth_date")
  private LocalDate birthDate;
  
  @OneToOne(targetEntity = Document.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "document_id", referencedColumnName = "id")
  private Document document;

  @OneToOne(targetEntity = Reference.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "reference_id", referencedColumnName = "id")
  private Reference reference;

}
