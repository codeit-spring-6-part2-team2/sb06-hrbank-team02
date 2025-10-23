package com.team2.hrbank.file.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "files")
@Entity
public class File {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long fileId;

  @Column(nullable = false)
  private String fileName;

  @Column(nullable = false)
  private String fileType;

  @Column(nullable = false)
  private Long fileSize;

  @Column(nullable = false)
  private String filePath;

}
