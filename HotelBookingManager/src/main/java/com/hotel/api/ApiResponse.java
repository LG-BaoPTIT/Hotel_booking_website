package com.hotel.api;
import com.hotel.dto.UserDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private Boolean success;
    private String message;
    private UserDTO userDTO;
 
}