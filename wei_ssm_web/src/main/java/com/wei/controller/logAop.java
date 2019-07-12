package com.wei.controller;

import com.wei.domain.sysLog;
import com.wei.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 *
 * 访问日志切面类
 */
@Component
@Aspect
public class logAop {
    //为获取ip
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService iSysLogService;

    private Date startTime;
    private Class executionClass;
    private Method executionMethod;
    private Long excuteionTime;
    //主要用于获取时长,访问的类，访问的方法
    @Before("execution(* com.wei.controller.*.*(..))&&!execution(* com.wei.controller.sysLogController.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //1.访问开始时间
        startTime=new Date();
        //2.获取访问的类
        executionClass= jp.getTarget().getClass();
        //3.获取访问的方法
        String methodName = jp.getSignature().getName();
        //3.1获取方法参数
        Object[] args = jp.getArgs();

        if(args==null&&args.length==0){//无参数
            //通过类过获取方法
            executionMethod=executionClass.getMethod(methodName);
        }else {//方法有参数,遍历所有参数，放到classArgs中再获取
            Class[] classArgs = new Class[args.length];
            for (int i=0;i<args.length;i++){
                //类型参数要获取
                classArgs[i]=args[i].getClass();
            }
            executionMethod=executionClass.getMethod(methodName,classArgs);
        }
            
    }


    //主要获取日志中其它信息，时长、ip、url...
    @After("execution(* com.wei.controller.*.*(..))&&!execution(* com.wei.controller.sysLogController.*(..))")
    public void doAfter(JoinPoint jp){
        //1.获取url
        String url="";
        String ip;
        //1.1获取requestMapping，确定不是日志类
        if(executionClass!=logAop.class){
            //获取类的requestMapping
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){

             //获取方法的requestMapping
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    url=classAnnotation.value()[0]+methodAnnotation.value()[0];

                    //2.获取ip,可通过request获取,要在web.xml配置一个listener,
                    // org.springframework.web.context.request.RequestContextListener
                    ip=request.getRemoteAddr();
                    //3.获取访问时长
                    excuteionTime=new Date().getTime()-startTime.getTime();
                    //4.获取当前操作者
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User)context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //5.进行封装
                    sysLog sysLog=new sysLog();
                    sysLog.setExecutionTime(excuteionTime);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(startTime);
                    sysLog.setMethod("类:"+executionClass.getName()+"方法:"+executionMethod.getName());

                    //6.调用service完成操作
                    iSysLogService.save(sysLog);

                }
            }
        }


    }
}
