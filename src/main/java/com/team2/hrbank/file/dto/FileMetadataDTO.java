package com.team2.hrbank.file.dto;

public record FileMetadataDTO(
   String file_name,
   String file_type,
   Long file_size
) {}
