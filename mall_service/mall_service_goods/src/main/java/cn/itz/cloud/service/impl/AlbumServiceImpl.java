package cn.itz.cloud.service.impl;

import cn.itz.cloud.dao.AlbumMapper;
import cn.itz.cloud.pojo.Album;
import cn.itz.cloud.service.AlbumService;
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
 * @Package cn.itz.cloud.service.impl
 * @Version 1.0
 * @date 2021/1/12 23:11
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    /**
     * 相册多条件分页查询
     * @param album
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Album> findPage(Album album, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example albumExample = createAlbumExample(album);
        //执行搜索
        return new PageInfo<>(albumMapper.selectByExample(albumExample));
    }

    /**
     * 分页搜索
     * @param page 当前页
     * @param size 每页显示多少条数据
     * @return
     */
    @Override
    public PageInfo<Album> findPageList(int page, int size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(albumMapper.selectAll());
    }

    /**
     * 多条件搜索
     * @param album
     * @return
     */
    @Override
    public List<Album> findList(Album album) {
        Example example = createAlbumExample(album);
        return albumMapper.selectByExample(example);
    }

    /**
     * 添加相册
     * @param album
     */
    @Override
    public void add(Album album) {
        albumMapper.insertSelective(album);
    }

    /**
     * 根据id查询相册
     * @param id
     * @return
     */
    @Override
    public Album findAlbumById(Long id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改相册
     * @param album
     */
    @Override
    public void update(Album album) {
        albumMapper.updateByPrimaryKey(album);
    }

    /**
     * 多条件查询对象
     * @param album
     * @return
     */
    public Example createAlbumExample(Album album){
        Example example = new Example(Album.class);
        Example.Criteria criteria = example.createCriteria();
        if (album != null){
            //编号
            if (!StringUtils.isEmpty(album.getId())){
                criteria.andEqualTo("id",album.getId());
            }
            //相册封面
            if (!StringUtils.isEmpty(album.getImage())){
                criteria.andEqualTo("image",album.getImage());
            }
            //相册名称
            if (!StringUtils.isEmpty(album.getTitle())){
                criteria.andLike("title","%"+album.getTitle()+"%");
            }
            //图片列表
            if (!StringUtils.isEmpty(album.getImageItems())){
                criteria.andEqualTo("imageItems","%"+album.getImageItems()+"%");
            }
        }
        return example;
    }
}
