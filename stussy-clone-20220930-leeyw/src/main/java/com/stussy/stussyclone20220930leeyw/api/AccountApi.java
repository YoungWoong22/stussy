package com.stussy.stussyclone20220930leeyw.api;

import com.stussy.stussyclone20220930leeyw.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930leeyw.dto.CMRespDto;
import com.stussy.stussyclone20220930leeyw.dto.RegisterReqDto;
import com.stussy.stussyclone20220930leeyw.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220930leeyw.exception.CustomValidationException;
import com.stussy.stussyclone20220930leeyw.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;


    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto,
                                      BindingResult bindingResult)throws Exception{

       accountService.duplicateEmail(registerReqDto);   //이메일 중복확인
       accountService.register(registerReqDto);         //회원가입진행

        return ResponseEntity.created(URI.create("/account/login")).body(new CMRespDto<>("회원가입 성공",registerReqDto.getEmail()));
    }
}

