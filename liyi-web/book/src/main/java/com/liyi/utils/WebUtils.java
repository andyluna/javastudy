package com.liyi.utils;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/6/2 23:45  星期三
 */

public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value , T bean ){
        try {

            /**
             * 把所有请求的参数都注入到bean对象中
             */
            BeanUtils.populate(bean, value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

}
