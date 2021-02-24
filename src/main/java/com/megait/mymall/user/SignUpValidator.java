package com.megait.mymall.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SignUpValidator implements Validator {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignUpForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpForm signUpForm = (SignUpForm)target;
        if(memberRepository.existsByEmail(signUpForm.getEmail())){
            errors.rejectValue(
                    "email",
                    "duplicated.email",
                    new Object[]{signUpForm.getEmail()},
                    "이미 사용중인 이메일입니다.");
        }
    }
}
// TODO memberRepository 만들기
// TODO validate() 이란?