package cn.itz.cloud.controller;

import cn.itz.cloud.entity.Result;
import cn.itz.cloud.entity.StatusCode;
import cn.itz.cloud.pojo.Brand;
import cn.itz.cloud.service.BrandService;
import com.github.pagehelper.PageInfo;
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
     * 分页+多条件查询
     * @param brand
     * @param page 当前页
     * @param size 每页多少条数据
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findBrandPage(@RequestBody(required = false) Brand brand,@PathVariable int page,@PathVariable int size){
        //执行搜索
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<>(true,StatusCode.OK,"查询成功！",pageInfo);
    }

    /**
     * 分页查询
     * @param page 当前页
     * @param size 每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page,@PathVariable int size){
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<>(true,StatusCode.OK,"查询成功！",pageInfo);
    }

    /**
     * 多条件搜索品牌数据
     * @param brand
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody(required = false) Brand brand){
        List<Brand> list = brandService.findBrandList(brand);
        return new Result<>(true,StatusCode.OK,"查询成功！",list);
    }

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

    /**
     * 修改品牌信息
     * @param brand
     * @param id
     * @return
     */
    @PutMapping(value = "/updateBrand/{id}")
    public Result updateBrand(@RequestBody Brand brand,@PathVariable Integer id){
        brand.setId(id);
        brandService.updateBrand(brand);
        return new Result(true,StatusCode.OK,"修改成功！");
    }

    /**
     * 根据id删除品牌
     * @param id
     * @return
     */
    @DeleteMapping("/deleteBrandById/{id}")
    public Result deleteBrandById(@PathVariable Integer id){
        brandService.deleteBrand(id);
        return new Result(true,StatusCode.OK,"删除成功！");
    }
}
