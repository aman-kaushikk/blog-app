package com.aman.blogapp.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min=4,message = "Username Must be min 4 char")
    private String name;
    @Email(message = "Email Address is not valid")
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String about;
}
