package com.team2.hrbank.file.service;

import com.team2.hrbank.file.dto.FileMetadataDTO;
import com.team2.hrbank.file.dto.FileResponseDTO;
import com.team2.hrbank.file.dto.FileUploadRequestDTO;
import java.io.IOException;

public interface FileService {

  FileMetadataDTO uploadFile(FileUploadRequestDTO fileUploadRequestDTO) throws IOException;

  FileResponseDTO downloadFile(Long id) throws IOException;




}
