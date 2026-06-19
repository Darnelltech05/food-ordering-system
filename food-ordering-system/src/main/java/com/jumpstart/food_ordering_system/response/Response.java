package com.jumpstart.food_ordering_system.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Generic response wrapper for all API responses.
 * Ensures consistent response format across all endpoints.
 *
 * @param <T> The type of data being returned
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private int statusCode;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    /**
     * Static factory method for success responses.
     *
     * @param message Success message
     * @param data    The data being returned
     * @param <T>     The type of data
     * @return Response object with status 200
     */
    public static <T> Response<T> success(String message, T data) {
        return Response.<T>builder()
                .statusCode(200)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Static factory method for error responses.
     *
     * @param code    HTTP status code
     * @param message Error message
     * @param <T>     The type of data (usually Void for errors)
     * @return Response object with error details
     */
    public static <T> Response<T> error(int code, String message) {
        return Response.<T>builder()
                .statusCode(code)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}