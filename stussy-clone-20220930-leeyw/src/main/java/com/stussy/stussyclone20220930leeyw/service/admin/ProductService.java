package com.stussy.stussyclone20220930leeyw.service.admin;

import com.stussy.stussyclone20220930leeyw.dto.CollectionListRespDto;

import java.util.List;

public interface ProductService {

    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;


}
