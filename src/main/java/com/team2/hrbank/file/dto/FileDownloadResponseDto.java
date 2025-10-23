package com.team2.hrbank.file.dto;

public record FileDownloadResponseDto(
    Long fileId,
    byte[] fileData
) {}
