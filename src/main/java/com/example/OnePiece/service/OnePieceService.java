package com.example.OnePiece.service;

import com.example.OnePiece.entity.OnePiece;
import com.example.OnePiece.exception.IdNotFoundException;
import com.example.OnePiece.repository.OnePieceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OnePieceService {

    private final OnePieceRepository onePieceRepository;

    public void create(OnePiece onePiece) {
        onePieceRepository.save(onePiece);
    }

    public void update(OnePiece onePiece, Long id) {
        var optionalAnime = onePieceRepository.findById(id);
        if (optionalAnime.isEmpty()) {
            throw new IdNotFoundException("anime with id: " + id + " was not found in database");
        }
        var animeDB = optionalAnime.get();

        if (null != onePiece.getName() && !"".equals(onePiece.getName())) {
            animeDB.setName(onePiece.getName());
        }
        if (null != onePiece.getAbility() && !"".equals(onePiece.getAbility())) {
            animeDB.setAbility(onePiece.getAbility());
        }
        if (null != onePiece.getCrew() && !"".equals(onePiece.getCrew())) {
            animeDB.setCrew(onePiece.getCrew());
        }
        animeDB.setAge(onePiece.getAge());
        animeDB.setStrength(onePiece.getStrength());

        onePieceRepository.save(animeDB);

    }

    public void delete(Long id) {
        var optionalAnime = onePieceRepository.findById(id);
        if (optionalAnime.isEmpty()) {
            throw new IdNotFoundException("anime with id: " + id + " was not found in database");
        }
        onePieceRepository.deleteById(id);
    }

    public OnePiece findById(Long id) {
        var optionalAnime = onePieceRepository.findById(id);
        if (optionalAnime.isEmpty()) {
            throw new IdNotFoundException("anime with id: " + id + " was not found in database");
        }
        return optionalAnime.get();
    }

    public List<OnePiece> findAll() {
        return onePieceRepository.findAll();
    }

    public List<OnePiece> findByAbility(String ability) {
        return onePieceRepository.findByAbility(ability);
    }

    public List<OnePiece> findByCrew(String crew) {
        return onePieceRepository.findByCrew(crew);
    }

}
