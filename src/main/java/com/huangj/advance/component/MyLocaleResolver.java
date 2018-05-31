package com.huangj.advance.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author huangj
 * @Description:  自定义区域解析器：解析url中的区域信息，
 * spring boot 默认的是根据请求头带来的区域信息获取Locale进行国际化
 * @date 2018/5/31
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("language");
        if(StringUtils.isEmpty(language)){
            return Locale.getDefault();
        }

        String[] localeInfo = StringUtils.split(language,"_");
        return new Locale(localeInfo[0],localeInfo[1]);
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

}
