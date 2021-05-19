package ru.dfed.annotation;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MaskAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class<?>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Set<Method> methods = ReflectionUtils.getAllMethods(beanClass);
        for (Method method : methods) {
            if (method.isAnnotationPresent(Mask.class)) {
                map.put(beanName, beanClass);
                System.out.println("\n ************************** \n");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if (beanClass != null) {
            System.out.println("\n ************************** \n");
            System.out.println(beanClass.getName());
            System.out.println("\n ************************** \n");
            Set<Method> methods = ReflectionUtils.getAllMethods(beanClass);
            for (Method method : methods) {
                if (method.isAnnotationPresent(Mask.class)) {
                    System.out.println("\n ************************** \n");
                    System.out.println("Mask method " + method.getName());
                    System.out.println("\n ************************** \n");
                    if (method.isDefault()) {
                        System.out.println("Mask default method " + method.getName());
                        System.out.println("\n ************************** \n");
                    }
                    return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if(method.isDefault()) {
                                return MethodHandles.lookup()
                                    .in(method.getDeclaringClass())
                                    .unreflectSpecial(method, method.getDeclaringClass())
                                    .bindTo(proxy)
                                    .invokeWithArguments();
                            }

                            try {
                                System.out.println("\n ************************** \n");
                                System.out.println("Mask method   " + method.getName());
                                System.out.println("\n ************************** \n");
                                return method.invoke(bean, args);
                            } catch (InvocationTargetException ex) {
                                throw ex.getCause();
                            }
                        }
                    });
                }
            }
        }
        return bean;
    }
}
