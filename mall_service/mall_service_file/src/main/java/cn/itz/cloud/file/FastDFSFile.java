package cn.itz.cloud.file;

import java.io.Serializable;

/**
 * 文件信息封装
 * @PackageName: cn.itz.cloud.file
 * @ClassName: FastDFSFile
 * @Author: codeZhang
 * @DateTime: 2021/1/12 11:13
 * @Version 1.0
 */
public class FastDFSFile implements Serializable {
  //文件名
  private String name;
  //文件内容
  private byte[] content;
  //文件拓展名
  private String ext;
  //文件MD5摘要值
  private String md5;
  //文件作者
  private String author;

  public FastDFSFile(String name, byte[] content, String ext, String md5, String author) {
    this.name = name;
    this.content = content;
    this.ext = ext;
    this.md5 = md5;
    this.author = author;
  }

  public FastDFSFile() {
  }

  public FastDFSFile(String name, byte[] content, String ext) {
    this.name = name;
    this.content = content;
    this.ext = ext;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }

  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}