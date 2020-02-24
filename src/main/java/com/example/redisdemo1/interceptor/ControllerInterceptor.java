package com.example.redisdemo1.interceptor;

import com.example.redisdemo1.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class ControllerInterceptor implements HandlerInterceptor {
    /**
     * 在所有http请求进来之前
     * 所有方法落到这个上面去校验
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) factory.getBean("stringRedisTemplate");
        log.info("进入拦截器-{}",request.getHeader("token"));
        String token = request.getHeader("token");
        String value = stringRedisTemplate.opsForValue().get(token);
        if (StringUtils.isEmpty(value)){
            return false;
        }
        log.info("token-{}",token);
        return true;
    }
}
