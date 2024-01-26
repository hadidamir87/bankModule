package com.example.demo.model.dto;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends AbstractDto{
    private String name;
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "رمز باید حداقل دارای ۸ حرف و شامل عدد و حروف باشد")
    private String password;
    @Pattern(regexp = "^09[0|1|2|3][0-9]{8}$", message = "شماره همراه باید ۱۱ رقم باشد")
    private String phoneNumber;
}
