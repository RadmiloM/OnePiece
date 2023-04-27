package com.example.OnePiece.repository;

import com.example.OnePiece.entity.OnePiece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnePieceRepository extends JpaRepository<OnePiece, Long> {

    List<OnePiece> findByAbility(String ability);

    List<OnePiece> findByCrew(String crew);
}
