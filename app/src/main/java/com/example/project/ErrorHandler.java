package com.example.project;

import com.domain.projectname.api.filters.ApiErrorHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler implements ApiErrorHandler {
}
