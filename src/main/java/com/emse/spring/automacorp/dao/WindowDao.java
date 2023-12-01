package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.RoomEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emse.spring.automacorp.model.WindowEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface                                                                                                                         WindowDao extends JpaRepository<WindowEntity, Long>, WindowDaoCustom {

    //List<RoomEntity> findByRoomId(Long id); // (1).

    @Query("select c from WindowEntity c where c.name=:name")  // (2)
    WindowEntity findByName(@Param("name") String name);

    @Modifying // (3)
    @Query("delete from WindowEntity c where c.name = ?1")
    void deleteByName(String name);

    @Modifying
    @Query("delete from WindowEntity w where w.room = ?1")
    void deleteAllByRoom(RoomEntity roomEntity);

}
