package cn.itz.cloud.controller;

import cn.itz.cloud.entity.Result;
import cn.itz.cloud.entity.StatusCode;
import cn.itz.cloud.pojo.Brand;
import cn.itz.cloud.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud.controller
 * @Version 1.0
 * @date 2021/1/11 22:15
 */
@RestController
@RequestMapping(value = "/brand")
/**
 * 跨域，A域名访问B域名的数据
 *    域名或者请求端口或者协议不一致的时候，就跨域了
 */
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有品牌
     * @return
     */
    @GetMapping(value = "/findAllBrands")
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result<>(true, StatusCode.OK,"查询所有品牌成功！",brandList);
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @GetMapping(value = "/findBrandById/{id}")
    public Result<Brand> findBrandById(@PathVariable(value = "id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true,StatusCode.OK,"根据id查询品牌成功！",brand);
    }

    /**
     * 增加品牌
     * @param brand
     * @return
     */
    @PostMapping(value = "/addBrand")
    public Result addBrand(@RequestBody Brand brand){
        brandService.addBrand(brand);
        return new Result(true,StatusCode.OK,"添加成功！");
    }
}
