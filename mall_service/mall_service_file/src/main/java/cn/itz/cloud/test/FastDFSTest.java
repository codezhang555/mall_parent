package cn.itz.cloud.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

/**
 * @PackageName: cn.itz.cloud
 * @ClassName: FastDFSTest
 * @Author: codeZhang
 * @DateTime: 2021/1/12 16:00
 * @Version 1.0
 */
public class FastDFSTest {

    @Test
    public void upload() throws Exception {

      //加载全局的配置文件
      ClientGlobal.initByProperties("fdfs_client.properties");

      //创建TrackerClient客户端对象
      TrackerClient trackerClient = new TrackerClient();
      //通过TrackerClient对象获取TrackerServer信息
      TrackerServer trackerServer = trackerClient.getConnection();
      //获取StorageClient对象
      StorageClient storageClient = new StorageClient(trackerServer, null);
      //执行文件上传
      String[] jpgs = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\3.jpg", "jpg", null);

      for (String jpg : jpgs) {
        System.out.println(jpg);
      }
    }
}
