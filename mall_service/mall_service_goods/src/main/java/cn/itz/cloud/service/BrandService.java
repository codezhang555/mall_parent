package cn.itz.cloud.service;

import cn.itz.cloud.pojo.Brand;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud.service
 * @Version 1.0
 * @date 2021/1/11 22:16
 */
public interface BrandService {

    /**
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 增加品牌
     * @param brand
     */
    void addBrand(Brand brand);
}
