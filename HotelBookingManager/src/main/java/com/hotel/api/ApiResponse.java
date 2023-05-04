package com.hotel.api;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private Boolean success;
    private String message;
 
}