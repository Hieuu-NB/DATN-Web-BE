package com.example.springserver.repository;

import com.example.springserver.entity.truyen_onl.TrangTruyenOnl;
import com.example.springserver.entity.truyen_onl.TruyenOnl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruyenOnlRepository extends JpaRepository<TruyenOnl, Long> {
    @Query(value = "SELECT * FROM truyen_onl WHERE LOWER(ten_truyen) LIKE LOWER(CONCAT('%', :key, '%'))", nativeQuery = true)
    List<TruyenOnl> search(String key);
}
