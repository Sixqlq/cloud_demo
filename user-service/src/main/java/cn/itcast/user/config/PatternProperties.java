package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 获取配置文件参数的配置类，相比@Value更灵活
 * ConfigurationProperties注解详情：https://blog.csdn.net/yusimiao/article/details/97622666
 */
@Data
@ConfigurationProperties(prefix = "pattern")
@Component
public class PatternProperties {
    /**
     * 注入nacos配置文件中的属性 pattern.dateformat
     */
    private String dateformat;
    private String envSharedValue;
    private String name;
}
