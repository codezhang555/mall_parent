package cn.itz.cloud.service.impl;

import cn.itz.cloud.dao.BrandMapper;
import cn.itz.cloud.pojo.Brand;
import cn.itz.cloud.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

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
     * 条件+分页查询
     * @param brand
     * @param page 当前页
     * @param size 每页显示多少条
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(brand);
        //执行搜索
        return new PageInfo<>(brandMapper.selectByExample(example));
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<>(brandMapper.selectAll());
    }

    /**
     * 多条件查询品牌
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findBrandList(Brand brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

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

    /**
     * 修改品牌信息
     * @param brand
     */
    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 根据id删除品牌
     * @param id
     */
    @Override
    public void deleteBrand(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建条件查询对象
     * @param brand
     * @return
     */
    public Example createExample(Brand brand){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null){
            //品牌id
            if (!StringUtils.isEmpty(brand.getId())){
                criteria.andEqualTo("id",brand.getId());
            }
            //品牌名称
            if (!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            //品牌图片
            if (!StringUtils.isEmpty(brand.getImage())){
                criteria.andLike("image","%"+brand.getImage()+"%");
            }
            //品牌首字母
            if (!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
            //排序
            if (!StringUtils.isEmpty(brand.getSeq())){
                criteria.andEqualTo("seq",brand.getSeq());
            }
        }
        return example;
    }
}
