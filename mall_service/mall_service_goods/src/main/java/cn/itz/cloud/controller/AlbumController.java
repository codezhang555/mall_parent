package cn.itz.cloud.controller;
import cn.itz.cloud.entity.Result;
import cn.itz.cloud.entity.StatusCode;
import cn.itz.cloud.pojo.Album;
import cn.itz.cloud.service.AlbumService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud.controller
 * @Version 1.0
 * @date 2021/1/12 23:11
 */
@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * 相册分页条件搜索
     * @param album
     * @param page  当前页
     * @param size  每页显示多少条
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Album album, @PathVariable int page,@PathVariable int size){
        //执行搜索
        PageInfo<Album> albumPageInfo = albumService.findPage(album, page, size);
        return new Result<>(true, StatusCode.OK,"查询成功！",albumPageInfo);
    }


    /**
     * 分页查询
     * @param page 当前页
     * @param size 每页显示多少条数据
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPageList(@PathVariable int page,@PathVariable int size){
        PageInfo<Album> pageInfo = albumService.findPageList(page, size);
        return new Result<>(true,StatusCode.OK,"查询成功！",pageInfo);
    }

    /**
     * 多条件查询
     * @param album
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Album>> findList(@RequestBody(required = false) Album album){
        List<Album> list = albumService.findList(album);
        return new Result<>(true,StatusCode.OK,"查询成功！",list);
    }

    /**
     * 根据id查询相册
     * @param id
     * @return
     */
    @GetMapping(value = "/searchById/{id}")
    public Result<Album> findAlbumById(@PathVariable Long id){
        Album album = albumService.findAlbumById(id);
        if (null != album){
            return new Result<>(true,StatusCode.OK,"查询成功！",album);
        }
        return new Result<>(false,StatusCode.ERROR,"数据不存在");
    }

    /**
     * 添加相册
     * @param album
     * @return
     */
    @PostMapping(value = "/addAlbum")
    public Result addAlbum(@RequestBody Album album){
        albumService.add(album);
        return new Result(true,StatusCode.OK,"添加成功！");
    }

    /**
     * 修改相册
     * @param album
     * @param id
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public Result updateAlbum(@RequestBody Album album,@PathVariable Long id){
        album.setId(id);
        albumService.update(album);
        return new Result(true,StatusCode.OK,"修改成功！");
    }
}
