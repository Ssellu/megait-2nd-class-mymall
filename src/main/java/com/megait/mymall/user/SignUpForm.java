package com.megait.mymall.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/*
 signup.html 의 form 내용들을 --> SignUpForm DTO로 포장 --> Validator 에게 전달
 */
@Data
public class SignUpForm {
    @NotBlank
    @Length(min = 5, max=40)
    @Email
    private String email;

    @NotBlank
    private String password;

    private String zipcode;
    private String city;
    private String street;

    @NotBlank
    private String agreeTermsOfService;
}
