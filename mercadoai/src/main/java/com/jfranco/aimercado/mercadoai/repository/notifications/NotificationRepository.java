package com.jfranco.aimercado.mercadoai.repository.notifications;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Notification.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByEmail(String email);

    List<Notification> findByType(String type);



}
