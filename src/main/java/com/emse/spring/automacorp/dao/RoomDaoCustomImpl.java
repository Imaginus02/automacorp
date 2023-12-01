package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.WindowEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom{

    @PersistenceContext
    private EntityManager entityManager;

    public void openAllWindow(RoomEntity roomEntity) {
        String jpql = "select w from WindowEntity w where w.room = :room";
        List<WindowEntity> windows = (entityManager.createQuery(jpql, WindowEntity.class).setParameter("room", roomEntity)).getResultList();
        for (WindowEntity window : windows) {
            window.getWindowStatus().setValue(1.0);
        }
    }

    public void closeAllWindow(RoomEntity roomEntity) {
        String jpql = "select w from WindowEntity w where w.room = :room";
        List<WindowEntity> windows = (entityManager.createQuery(jpql, WindowEntity.class).setParameter("room", roomEntity)).getResultList();
        for (WindowEntity window : windows) {
            window.getWindowStatus().setValue(0.0);
        }
    }
}
