package com.qiang.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                //进行对应的设置，比如开启驼峰法命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
