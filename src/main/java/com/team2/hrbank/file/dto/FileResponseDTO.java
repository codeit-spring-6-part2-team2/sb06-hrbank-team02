package com.team2.hrbank.file.dto;

public record FileResponseDTO(
   Long file_id,
   byte[] file_data
   ) {}
