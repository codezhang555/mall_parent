package cn.itz.cloud.service;

import cn.itz.cloud.pojo.Album;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud.service
 * @Version 1.0
 * @date 2021/1/12 23:11
 */
public interface AlbumService {

    /**
     * 相册多条件分页查询
     * @param album
     * @param page
     * @param size
     * @return
     */
    PageInfo<Album> findPage(Album album,int page,int size);

    /**
     * 分页搜索
     * @param page 当前页
     * @param size 每页显示多少条数据
     * @return
     */
    PageInfo<Album> findPageList(int page,int size);

    /**
     * 多条件搜索
     * @param album
     * @return
     */
    List<Album> findList(Album album);

    /**
     * 添加
     * @param album
     */
    void add(Album album);

    /**
     * 根据id查询相册
     * @param id
     * @return
     */
    Album findAlbumById(Long id);

    /**
     * 修改相册
     * @param album
     */
    void update(Album album);
}
