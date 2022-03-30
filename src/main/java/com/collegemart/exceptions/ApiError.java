package com.collegemart.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiError {
    String messgae;
    List<String> details;
    HttpStatus status;
    LocalDateTime timestamp;
}
