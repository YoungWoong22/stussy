package com.stussy.stussyclone20220930Leeyw.service;

import com.stussy.stussyclone20220930Leeyw.dto.CollectionListRespDto;
import com.stussy.stussyclone20220930Leeyw.dto.ProductRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;
    public ProductRespDto getProduct(int pdtId) throws Exception;
}
