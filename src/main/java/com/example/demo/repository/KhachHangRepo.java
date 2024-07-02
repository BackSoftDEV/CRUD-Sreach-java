package com.example.demo.repository;

import com.example.demo.enity.Khachhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo extends JpaRepository<Khachhang,Integer> {
}
