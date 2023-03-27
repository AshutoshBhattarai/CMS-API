package com.application.cms.ExtraModels;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ApiResponse {

    HttpStatus status;
    int code;
    LocalDateTime timestamp;
    String message;
}
