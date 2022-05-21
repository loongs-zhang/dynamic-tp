package com.dtp.adapter.webserver.listener;

import com.dtp.adapter.TpHandler;
import com.dtp.adapter.webserver.handler.AbstractWebServerTpHandler;
import com.dtp.common.ApplicationContextHolder;
import com.dtp.common.event.RefreshEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;

/**
 * WebServerRefreshListener related
 *
 * @author: yanhom
 * @since 1.0.0
 **/
@Slf4j
public class WebServerRefreshListener implements ApplicationListener<RefreshEvent> {

    @Override
    public void onApplicationEvent(@NonNull RefreshEvent event) {
        try {
            TpHandler webServerTpHandler = ApplicationContextHolder.getBean(AbstractWebServerTpHandler.class);
            webServerTpHandler.updateTp(event.getDtpProperties());
        } catch (Exception e) {
            log.error("DynamicTp refresh, update web server thread pool failed.", e);
        }
    }
}