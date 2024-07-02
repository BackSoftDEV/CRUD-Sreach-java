package com.example.demo.repository;

import com.example.demo.enity.Giohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiohangRepo extends JpaRepository<Giohang,Integer> {
     @Query("select P from Giohang P where P.magiohang Like ?1")
     List<Giohang> findByTen(String keyword);
}
