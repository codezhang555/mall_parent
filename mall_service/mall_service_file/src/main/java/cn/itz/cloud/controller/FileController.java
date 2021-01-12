package cn.itz.cloud.controller;

import cn.itz.cloud.file.FastDFSFile;
import cn.itz.cloud.utils.FastDFSUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author CodeZhang
 * @ProjectName mall_parent
 * @Package cn.itz.cloud.controller
 * @Version 1.0
 * @date 2021/1/12 22:33
 */
@RestController
@CrossOrigin
public class FileController {

    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(),  //文件名字
                file.getBytes(),             //文件字节数组
                StringUtils.getFilenameExtension(file.getOriginalFilename()));//文件拓展名
        String[] uploads = FastDFSUtils.upload(fastDFSFile);
        return FastDFSUtils.getTrackerUrl()+"/"+uploads[0]+"/"+uploads[1];
    }
}
