package com.zippy.users.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personal_information")
public class PersonalInformation implements Serializable  {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_generator")
  @SequenceGenerator(name = "profile_generator", sequenceName = "profile_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "first_names")
  private String firstNames;

  @Column(name = "last_names")
  private String lastNames;

  @Column(name = "email")
  private String email;

  @Column(name = "occupation")
  private String occupation;

  @Column(name = "phone_number")
  private String phone;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Column(name = "document_id")
  private Long documentId;

  @Column(name = "reference_id")
  private Long referenceId;

  @JsonIgnore
  @OneToOne(targetEntity = Document.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "document_id",  insertable = false, updatable = false)
  private Document document;

  @JsonIgnore
  @OneToOne(targetEntity = Reference.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "reference_id",  insertable = false, updatable = false)
  private Reference reference;

}
