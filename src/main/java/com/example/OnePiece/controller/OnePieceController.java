package com.example.OnePiece.controller;

import com.example.OnePiece.dto.OnePieceDTO;
import com.example.OnePiece.entity.OnePiece;
import com.example.OnePiece.mapper.Mapper;
import com.example.OnePiece.service.OnePieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/anime")
public class OnePieceController {

    private final OnePieceService onePieceService;
    private final Mapper mapper;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody OnePieceDTO onePieceDTO) {
        var anime = mapper.mapToEntity(onePieceDTO);
        onePieceService.create(anime);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody OnePiece onePiece, @PathVariable Long id) {
        onePieceService.update(onePiece, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        onePieceService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<OnePieceDTO> get(@PathVariable Long id) {
        var animeDB = onePieceService.findById(id);
        var animeResponse = mapper.mapToDTO(animeDB);
        return ResponseEntity.ok(animeResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OnePieceDTO>> findAll() {
        var animes = onePieceService.findAll()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(animes);
    }

    @GetMapping("/power")
    public ResponseEntity<List<OnePieceDTO>> findByAbility(@RequestParam String ability) {
        var animes = onePieceService.findByAbility(ability)
                .stream().map(mapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(animes);
    }

    @GetMapping("/group")
    public ResponseEntity<List<OnePieceDTO>> findByCrew(@RequestParam String crew) {
        var animes = onePieceService.findByCrew(crew)
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(animes);
    }

}
