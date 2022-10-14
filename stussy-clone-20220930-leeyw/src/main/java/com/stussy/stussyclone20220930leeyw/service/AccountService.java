package com.stussy.stussyclone20220930leeyw.service;

import com.stussy.stussyclone20220930leeyw.domain.User;
import com.stussy.stussyclone20220930leeyw.dto.RegisterReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountService {

    void duplicateEmail(RegisterReqDto registerReqDto) throws Exception;

    void register(RegisterReqDto registerReqDto) throws Exception;
}
