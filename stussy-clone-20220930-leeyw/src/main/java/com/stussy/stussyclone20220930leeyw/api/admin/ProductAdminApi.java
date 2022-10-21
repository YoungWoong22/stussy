package com.stussy.stussyclone20220930leeyw.api.admin;

import com.stussy.stussyclone20220930leeyw.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930leeyw.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220930leeyw.dto.CMRespDto;
import com.stussy.stussyclone20220930leeyw.dto.admin.ProductRegisterReqDto;
import com.stussy.stussyclone20220930leeyw.service.admin.ProductManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class ProductAdminApi {

    private final ProductManagementService productManagementService;


    @LogAspect
    @ValidAspect
    @PostMapping("/product")
    public ResponseEntity<?> registerProductMst(@Valid @RequestBody ProductRegisterReqDto productRegisterReqDto,
                                                BindingResult bindingResult) throws Exception {
        //기존 값에서 새로 가져오기
        String name = productRegisterReqDto.getName();

        Random random = new Random();

        for (int i=0; i<100; i++){
            productRegisterReqDto.setCategory(i/10 +1);
            productRegisterReqDto.setName(name + (i + 1));

            //가격 랜덤
            productRegisterReqDto.setPrice((random.nextInt(10) +1) * 100000);

        productManagementService.registerMst(productRegisterReqDto);
        }


        return ResponseEntity.created(null)
                .body(new CMRespDto<>("Register successfully",true));
    }


    @GetMapping("/product/category")
    public ResponseEntity<?> getCategoryList() throws Exception {
        return ResponseEntity.ok().
                body(new CMRespDto<>("Get Successfully", productManagementService.getCategoryList()))  ;

    }


}
