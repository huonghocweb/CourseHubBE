package org.example.poly.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userName;
    private String fullName;
    private String password;
    private Boolean gender;
    private String address;
    private String imageUrl;
    private String phoneNumber;
    private LocalDate birthday;
    private String email;
    private Boolean status;
    private List<Integer> roleIds ;
}
