package com.example.people_sync_backend.shared.records;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;

@Builder
public record ApiError(
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime timestamp,

        Integer code,
        String status,
        List<String> errors) {

}
