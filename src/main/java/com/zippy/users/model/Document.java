package com.zippy.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document")
public class Document {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(targetEntity = DocumentType.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "document_type_id", referencedColumnName = "id")
  private DocumentType type;

  @Column(name = "document_number")
  private String number;

  @Column(name = "front_image")
  private String frontImage;

  @Column(name = "back_image")
  private String backImage;
}
