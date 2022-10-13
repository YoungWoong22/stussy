package com.stussy.stussyclone20220930leeyw.dto;

import com.stussy.stussyclone20220930leeyw.domain.User;
import com.stussy.stussyclone20220930leeyw.dto.validation.ValidationGroups;
import lombok.Data;
import org.apache.logging.log4j.message.Message;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterReqDto {
    // 한글자 이상 무조건 들어와야함. 세글자를 넘을 수는 없다. 무조건 한글이어야한다.
    @NotBlank(message = "이름은 비워 둘 수 없습니다" , groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 1 , max = 3 , message = "이름은 3자 까지만 입력가능합니다" , groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^[가-횡]*$" , message= "한글만 가능합니다" ,groups = ValidationGroups.PatternCheckGroup.class)
    private String lastName;

    @Size(min = 1 , max = 2 , message = "이름은 2자 까지만 입력가능합니다" , groups = ValidationGroups.SizeGroup.class)
    @NotBlank(message = "이름은 비워 둘 수 없습니다" , groups = ValidationGroups.NotBlankGroup.class)
    @Pattern(regexp = "^[가-횡]*$" , message= "한글만 가능합니다" ,groups = ValidationGroups.PatternCheckGroup.class)
    private String firstName;

    @NotBlank(message = "이메일은 비워 둘 수 없습니다" , groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;


    @NotBlank(message = "비밀번호는 비워 둘 수 없습니다" , groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8 , max = 16 , message = "비밀번호는 8자 부터 16자까지 입력하여야 합니다"  , groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$",
            message = "비밀번호는 특수기호, 영문, 숫자를 모두 포함해야합니다" ,groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(new BCryptPasswordEncoder().encode(password))  //password 암호화
                .name(firstName + lastName)
                .role_id(1)

                .build();
    }

}
