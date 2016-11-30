package com.carpool.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Project: Carpool
 * Package: com.carpool.configuration
 * Author:  Novemser
 * 2016/12/1
 */
@Configuration
public class TilesConfig {
    /**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/views/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     * Configure ViewResolvers to deliver preferred views.
     */
    @Bean(name = "tilesViewResolver")
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }

}
