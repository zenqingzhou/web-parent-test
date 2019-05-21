package com.bidewu.web.config.interceptor;


import com.bidewu.web.common.constant.datarule.ApiResultCodeEnum;
import com.bidewu.web.common.constant.sys.SystemExceptionErrorCodeEnum;
import com.bidewu.web.common.exceptions.BaseException;
import com.bidewu.web.common.exceptions.CorpException;
import com.bidewu.web.common.exceptions.ParamException;
import com.bidewu.web.common.exceptions.ToutiaoRequestException;
import com.bidewu.web.common.restmodel.AgentApiResult;
import com.bidewu.web.common.restmodel.ToutiaoApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Set;

/**
 * zhangjinglei 2017/8/31 上午9:54
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Value("${exception.show}")
    private String showException="";

    // 异常处理方法：
    // 根据特定的异常返回指定的 HTTP 状态码
    @ResponseStatus(value= HttpStatus.OK)  // 400
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public AgentApiResult handleValidationException(HttpServletRequest request, ConstraintViolationException ex) {
        logger.error("异常:"+request.getRequestURI(),ex);
        Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : errors) {
            strBuilder.append(violation.getMessage() + "\n");
        }

        logger.error("错误请求！");
        return AgentApiResult.Fail(SystemExceptionErrorCodeEnum.CONSTRAINTVIOLATIONEXCEPTION, strBuilder.toString());
    }


    @ResponseStatus(value=HttpStatus.OK)
    @ExceptionHandler(value=MethodArgumentNotValidException.class) //400
    @ResponseBody
    public AgentApiResult MethodArgumentNotValidHandler(HttpServletRequest request,
                                                        MethodArgumentNotValidException exception) {
        logger.error("异常:"+request.getRequestURI(),exception);
        HashMap<String,String> errortip=new HashMap<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errortip.put(error.getField(),error.getDefaultMessage());
        }

        logger.error("请求参数错误！");
        return AgentApiResult.Fail(SystemExceptionErrorCodeEnum.METHODARGUMENTNOTVALIDEXCEPTION, errortip);
    }

    @ResponseStatus(value=HttpStatus.OK)  // 404
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public AgentApiResult NoHandlerFoundException( HttpServletRequest request,Exception ex) {
        logger.error("异常:"+request.getRequestURI(),ex);

        return AgentApiResult.Fail(SystemExceptionErrorCodeEnum.NOHANDLERFOUNDEXCEPTION, "找不到接口地址："+request.getRequestURI().toString());
    }

    // 通用异常的处理，返回500
    @ResponseStatus(value=HttpStatus.OK)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AgentApiResult handleException( HttpServletRequest request,Exception ex) {
        logger.error("异常:"+request.getRequestURI(),ex);
        if(ex instanceof BaseException){
            BaseException baseex=(BaseException)ex;
            return AgentApiResult.Fail(baseex.getCode(), baseex.getMessage());
        }
        if(this.showException!=null && this.showException.toLowerCase().equals("true")) {
            return AgentApiResult.Fail(SystemExceptionErrorCodeEnum.EXCEPTION, this.getExceptionDetail(ex));
        }
        else {
            return AgentApiResult.Fail(SystemExceptionErrorCodeEnum.EXCEPTION);
        }
    }

    @ResponseStatus(value=HttpStatus.OK)  // 500
    @ExceptionHandler({ToutiaoRequestException.class})
    @ResponseBody
    public ToutiaoApiResult handleApiRequestException(HttpServletRequest request, Exception ex) {
        logger.error("异常:"+request.getRequestURI(), ex);
        if(ex instanceof BaseException){
            ToutiaoRequestException exception = (ToutiaoRequestException)ex;
            return new ToutiaoApiResult (ApiResultCodeEnum.REQUEST_PARAM_ERROR, exception.getMessage());
        }
        return new ToutiaoApiResult(ApiResultCodeEnum.SERVER_INTERNAL_ERROR_CODE);
    }

    /**
     * 请求参数绑定异常-房源导入API
     * @param request
     * @param ex
     * @return
     */
    @ResponseStatus(value=HttpStatus.OK)
    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    public ToutiaoApiResult handleServletRequestBindingException(HttpServletRequest request, ServletRequestBindingException ex){

        logger.error("异常:"+request.getRequestURI(), ex);
        return new ToutiaoApiResult (ApiResultCodeEnum.REQUEST_PARAM_ERROR, ex.getMessage());
    }


    /**
     * 自定义企业管理业务操作异常
     * @param request
     * @param corpException
     * @return
     */
    @ResponseStatus(value=HttpStatus.OK)  // 500
    @ExceptionHandler(CorpException.class)
    @ResponseBody
    public AgentApiResult corpException(HttpServletRequest request,CorpException corpException){
        logger.error("异常:"+request.getRequestURI(),corpException);
        return AgentApiResult.Fail(corpException.getCode(),corpException.getMessage());
    }
    /**
     * @author  wangzw
     * @create  2018/2/23 14:08
     * @desc 请求参数格式不正确的异常
     **/
    @ResponseStatus(value=HttpStatus.OK)
    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public AgentApiResult paramErrorException(HttpServletRequest request,ParamException pe){
        logger.error("异常:"+request.getRequestURI(),pe);
        return AgentApiResult.Fail(pe.getCode(),pe.getMessage());
    }
    /**
     * @author  wangzw
     * @create  2018/3/2 16:36
     * @desc 无法抛出的参数异常
     **/
    @ResponseStatus(value=HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AgentApiResult BindException(HttpServletRequest request,BindException be){
        logger.error("异常:"+request.getRequestURI(),be);
        return AgentApiResult.Fail(	10002,"Argument-error|请求参数错误");
    }


    private String getExceptionDetail(Exception e) {
        StringBuffer stringBuffer = new StringBuffer(e.toString() + "\n");
        StackTraceElement[] messages = e.getStackTrace();
        int length = messages.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(messages[i].toString()+"\n");
        }
        return stringBuffer.toString();
    }
}