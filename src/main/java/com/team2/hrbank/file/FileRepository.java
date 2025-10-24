package com.team2.hrbank.file;

import com.team2.hrbank.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import com.team2.hrbank.file.domain.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity,Long>{ }