package com.emse.spring.automacorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emse.spring.automacorp.model.RoomEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<RoomEntity, Long>, RoomDaoCustom {

    List<RoomEntity> findByBuildingId(Long id); // (1).

    @Query("select c from RoomEntity c where c.name=:name")  // (2)
    RoomEntity findByName(@Param("name") String name);

    @Modifying // (3)
    @Query("delete from RoomEntity c where c.name = ?1")
    void deleteByName(String name);
}