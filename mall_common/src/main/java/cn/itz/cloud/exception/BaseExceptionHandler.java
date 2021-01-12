package cn.itz.cloud.exception;

import cn.itz.cloud.entity.Result;
import cn.itz.cloud.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共异常处理
 * @PackageName: cn.itz.cloud.exception
 * @ClassName: BaseExceptionHandler
 * @Author: codeZhang
 * @DateTime: 2021/1/12 10:31
 * @Version 1.0
 */
//全局捕获异常类，只要作用在@RequestMapping上，所有的异常都会被捕获
@ControllerAdvice
public class BaseExceptionHandler {

  /**
   * 异常处理
   * @param e
   * @return
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Result error(Exception e){
    e.printStackTrace();
    return new Result(false, StatusCode.ERROR,e.getMessage());
  }
}
