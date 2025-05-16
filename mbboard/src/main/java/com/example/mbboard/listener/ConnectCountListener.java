package com.example.mbboard.listener;

import com.example.mbboard.dto.ConnectCount;
import com.example.mbboard.service.IRootService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component // 이거만 있으면 된다
public class ConnectCountListener implements HttpSessionListener {

    @Autowired
    private IRootService rootService;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("✅ rootService: " + (rootService == null ? "null" : "주입됨"));

        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("currentConnectCount");
        if (count == null) count = 0;
        context.setAttribute("currentConnectCount", count + 1);

        ConnectCount cc = new ConnectCount();
        cc.setMemberRole("ANONYMOUS");

        if (rootService.getConnectDateByKey(cc) == null) {
            rootService.addConnectCount(cc);
        } else {
            rootService.modifyConnectCount(cc);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("currentConnectCount");
        if (count == null || count <= 0) count = 1;
        context.setAttribute("currentConnectCount", count - 1);
    }
}