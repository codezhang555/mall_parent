package cn.itz.cloud.service.impl;

import cn.itz.cloud.dao.BrandMapper;
import cn.itz.cloud.pojo.Brand;
import cn.itz.cloud.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud.service
 * @Version 1.0
 * @date 2021/1/11 22:15
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    /**
     * 查询所有品牌
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 根据id查询品牌详情
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 增加品牌
     * @param brand
     */
    @Override
    public void addBrand(Brand brand) {
        //方法中但凡带selective，会忽略空值
        brandMapper.insertSelective(brand);
    }
}
