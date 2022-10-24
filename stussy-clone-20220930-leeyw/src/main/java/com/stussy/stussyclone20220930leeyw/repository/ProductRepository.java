package com.stussy.stussyclone20220930leeyw.repository;

import com.stussy.stussyclone20220930leeyw.domain.CollectionsProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {
    public List<CollectionsProduct> getProductList(Map<String, Object> map) throws Exception;
}
