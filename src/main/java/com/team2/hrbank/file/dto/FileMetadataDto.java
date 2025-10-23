package com.team2.hrbank.file.dto;

public record FileMetadataDto(
    Long fileId,
    String fileName,
    String fileType,
    Long fileSize,
    String filePath
) {}
