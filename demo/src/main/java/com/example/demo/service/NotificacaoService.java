package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

import jakarta.annotation.PreDestroy;

@Service
public class NotificacaoService {
    private SocketIONamespace namespace;
    private SocketIOServer server;

    public void publicar(String mensagem) {
        namespace.getBroadcastOperations().sendEvent("notificacao", mensagem);
    }

    public void NotificationService(SocketIOServer server){
        this.server = server;
        this.namespace = server.addNamespace("/ws-listener");
        this.server.start();
    }

    @PreDestroy
    private void stopSocketIO(){
        this.server.stop();
    }
}
