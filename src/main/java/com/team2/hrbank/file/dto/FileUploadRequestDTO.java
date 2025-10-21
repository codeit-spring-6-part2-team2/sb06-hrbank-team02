package com.team2.hrbank.file.dto;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequestDTO(
    MultipartFile multipartFile
) {}
