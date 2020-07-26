package net.esm;

import net.esm.common.support.config.NettyConfig;
import net.esm.common.support.properties.GlobalProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.net.InetSocketAddress;

/**
 * 应用启动器
 *
 */
@SpringBootApplication
public class EsmApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsmApplication.class);

    /**
     * jar启动
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EsmApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        LOGGER.info("The Dp application has been started successfully!");

        // 启动Netty Server，监听端口
        NettyConfig.start(new InetSocketAddress("0.0.0.0", 8090));
    }

    /**
     * war启动
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.bannerMode(Banner.Mode.OFF);
        SpringApplicationBuilder applicationBuilder = builder.sources(EsmApplication.class);
        LOGGER.info("The Dp application has been started successfully!");
        return applicationBuilder;
    }

}
