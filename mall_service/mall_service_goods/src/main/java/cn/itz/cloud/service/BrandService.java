package cn.itz.cloud.service;

import cn.itz.cloud.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud.service
 * @Version 1.0
 * @date 2021/1/11 22:16
 */
public interface BrandService{

    /**
     * 多条件分页查询
     * @param brand
     * @param page 当前页
     * @param size 每页显示多少条
     * @return
     */
    PageInfo<Brand> findPage(Brand brand,int page,int size);

    /**
     * 分页查询
     * @param page 当前页
     * @param size 每页显示多少条
     * @return
     */
    PageInfo<Brand> findPage(int page,int size);

    /**
     * 多条件搜索品牌
     * @param brand
     * @return
     */
    List<Brand> findBrandList(Brand brand);

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

    /**
     * 修改品牌信息
     * @param brand
     */
    void updateBrand(Brand brand);

    /**
     * 根据id删除品牌
     * @param id
     */
    void deleteBrand(Integer id);
}
