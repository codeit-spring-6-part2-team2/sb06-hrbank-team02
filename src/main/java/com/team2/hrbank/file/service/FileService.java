package com.team2.hrbank.file.service;

import com.team2.hrbank.file.dto.FileMetadataDto;
import com.team2.hrbank.file.dto.FileDownloadResponseDto;

public interface FileService {
  FileMetadataDto uploadFile(FileMetadataDto fileMetadataDto);

  FileDownloadResponseDto downloadFile(Long fileId);

}
