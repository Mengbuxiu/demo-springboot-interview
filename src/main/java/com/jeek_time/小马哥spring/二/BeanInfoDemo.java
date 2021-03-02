package com.jeek_time.小马哥spring.二;


import com.java_feature.jdk8.lambda.other_experience.entity.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.Arrays;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2021/3/2 上午11:38
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
//            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();
            if ("age".equals(propertyName)) {
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
            }
        });
    }

    /**
     * spring3.0之前大量使用 {@link PropertyEditorSupport} 把text转换为相应的类型
     */
    private static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
