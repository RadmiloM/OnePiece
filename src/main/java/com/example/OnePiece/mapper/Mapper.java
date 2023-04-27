package com.example.OnePiece.mapper;

import com.example.OnePiece.dto.OnePieceDTO;
import com.example.OnePiece.entity.OnePiece;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public OnePieceDTO mapToDTO(OnePiece onePiece) {
        var name = onePiece.getName();
        var ability = onePiece.getAbility();
        var crew = onePiece.getCrew();
        var strength = onePiece.getStrength();
        var age = onePiece.getAge();

        return new OnePieceDTO(name, age, ability, strength, crew);
    }

    public List<OnePieceDTO> mapToDTO(List<OnePiece> onePiece){
        return onePiece.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public OnePiece mapToEntity(OnePieceDTO onePieceDTO){
        var onePiece = new OnePiece();
        onePiece.setName(onePieceDTO.getName());
        onePiece.setAbility(onePieceDTO.getAbility());
        onePiece.setCrew(onePieceDTO.getCrew());
        onePiece.setStrength(onePieceDTO.getStrength());
        onePiece.setAge(onePieceDTO.getAge());
        return onePiece;

    }
}
