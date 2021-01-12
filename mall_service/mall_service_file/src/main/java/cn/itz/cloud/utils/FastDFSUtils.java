package cn.itz.cloud.utils;

import cn.itz.cloud.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传相关操作
 * @PackageName: cn.itz.cloud.utils
 * @ClassName: FastDFSUtils
 * @Author: codeZhang
 * @DateTime: 2021/1/12 16:31
 * @Version 1.0
 */
public class FastDFSUtils {

  /**
   * 初始化tracker信息
   */
  static {
    try {
      ClientGlobal.initByProperties("fdfs_client.properties");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 文件上传
   * @param file 要上传的信息封装->FastDFSFile
   * @return String[]
   *              1.文件上传所存储的组名
   *              2.文件存储路径
   */
  public static String[] upload(FastDFSFile file){
    //获取文件作者
    NameValuePair[] meta_list = new NameValuePair[1];
    meta_list[0] = new NameValuePair(file.getAuthor());

    /**
     * 文件上传后的返回值
     * uploadResults[0]:文件上传所存储的组名：例如group1
     * uploadResults[1]:文件存储路径
     */
    String[] uploadResults = null;
    try {
      //获取StorageClient对象
      StorageClient storageClient = getStorageClient();
      //执行文件上传
      uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return uploadResults;
  }

  /**
   * 获取文件信息
   * @param groupName 组名
   * @param remoteFileName 文件存储完整名
   * @return
   */
  public static FileInfo getFile(String groupName,String remoteFileName){
    try {
      //获取StorageClient对象
      StorageClient storageClient = getStorageClient();
      //获取文件信息
      return storageClient.get_file_info(groupName,remoteFileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 文件下载
   * @param groupName 组名
   * @param remoteFileName 文件存储完整名
   * @return
   */
  public static InputStream downloadFile(String groupName,String remoteFileName){
    try {
      //获取StorageClient
      StorageClient storageClient = getStorageClient();
      //获取StorageClient下载文件
      byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
      //将字节数组转换成字节输入流
      return new ByteArrayInputStream(fileByte);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 文件删除实现
   * @param groupName 组名
   * @param remoteFileName 文件存储完整名
   */
  public static void deleteFile(String groupName,String remoteFileName){
    try {
      StorageClient storageClient = getStorageClient();
      storageClient.delete_file(groupName,remoteFileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取组信息
   * @param groupName 组名
   * @return
   */
  public static StorageServer getStorages(String groupName){
    TrackerServer trackerServer = null;
    try {
      TrackerClient trackerClient = new TrackerClient();
      trackerServer = trackerClient.getConnection();
      return trackerClient.getStoreStorage(trackerServer,groupName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据文件组名和文件存储路径获取Storage服务的ip、端口信息
   * @param groupName  组名
   * @param remoteFileName  文件完整存储名
   * @return
   */
  public static ServerInfo[] getServerInfo(String groupName,String remoteFileName){
    try {
      TrackerClient trackerClient = new TrackerClient();
      TrackerServer trackerServer = trackerClient.getConnection();
      return trackerClient.getFetchStorages(trackerServer,groupName,remoteFileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取Tracker服务地址
   * @return
   */
  public static String getTrackerUrl(){
    try {
      TrackerClient trackerClient = new TrackerClient();
      TrackerServer trackerServer = trackerClient.getConnection();
      return "http://" + trackerServer.getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 获取TrackerServer
   * @return
   */
  public static TrackerServer getTrackerServer(){
    //创建TrackerClient客户端对象
    TrackerClient trackerClient = new TrackerClient();
    //通过TrackerClient对象获取TrackerServer信息
    TrackerServer trackerServer = null;
    try {
      trackerServer = trackerClient.getConnection();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return trackerServer;
  }

  /**
   * 获取StorageClient
   * @return
   */
  public static StorageClient getStorageClient(){
    TrackerServer trackerServer = null;
    try {
      trackerServer = getTrackerServer();
    } catch (Exception e) {
      e.printStackTrace();
    }
    StorageClient storageClient = new StorageClient(trackerServer, null);
    return storageClient;
  }
}
