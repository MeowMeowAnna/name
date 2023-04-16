package com.example.Pribori.service;

import com.example.Pribori.dto.CommentDto;
import com.example.Pribori.dto.KonvektoriDto;
import com.example.Pribori.dto.ObogrevateliDto;
import com.example.Pribori.entity.Comment;
import com.example.Pribori.entity.Konvektori;
import com.example.Pribori.entity.Obogrevateli;
import com.example.Pribori.repository.CommentRepository;
import com.example.Pribori.repository.KonvektoriRepository;
import com.example.Pribori.repository.ObogrevateliRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public abstract class DefaultService implements ObogrevateliService,KonvektoriService,CommentService, ObogrevateliRepository {

    private final ObogrevateliRepository obogrevateliRepository;
    private final KonvektoriRepository konvektoriRepository;
    private final CommentRepository commentRepository;
    private final PriboriConverter priboriConverter;


    @Override
    public ObogrevateliDto saveObogrevateli(ObogrevateliDto obogrevateliDto) {
        try{
            validatePriboriDto(obogrevateliDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        List<ObogrevateliDto> obogrevateliDtoList = new ArrayList<>(findAllOb());
        Long a = Long.valueOf(obogrevateliDtoList.size());
        obogrevateliDto.setId(a+1);
        Obogrevateli obogrevateli= priboriConverter.fromObDtoToOb(obogrevateliDto);
        obogrevateli = obogrevateliRepository.save(obogrevateli);
        return priboriConverter.fromObToObDto(obogrevateli);
    }

    @Query(value = "SELECT * from obogrevateli where name like ?1;", nativeQuery = true)
    List<Obogrevateli> fbn(String name){return  null;}

    @Override
    public void deleteObogrevateli(Long id) {
        obogrevateliRepository.deleteById(id);
    }

    @Override
    public ObogrevateliDto findByNameOb(String name) {
        Obogrevateli obogrevateli = obogrevateliRepository.findByNameContains(name).get(0);
        if (obogrevateli != null){
            return priboriConverter.fromObToObDto(obogrevateli);
        }
        return null;
    }

    @Override
    public List<ObogrevateliDto> findAllOb() {
        List<Obogrevateli> obogrevateliList = new ArrayList<>(obogrevateliRepository.findAll());
        List<ObogrevateliDto> obogrevateliDtoList = new ArrayList<>();
        if(!obogrevateliList.isEmpty()){
            for (Obogrevateli obogrevateli:obogrevateliList){
                obogrevateliDtoList.add(priboriConverter.fromObToObDto(obogrevateli));
            }
            return obogrevateliDtoList;
        }
        return null;
    }

    @Override
    public List<ObogrevateliDto> findObogrev(Long price) {
        List<Obogrevateli> obogrevateliList = new ArrayList<>(obogrevateliRepository.findAllByPriceGreaterThanEqual(price));
        List<ObogrevateliDto> obogrevateliDtoList = new ArrayList<>();
        if(!obogrevateliList.isEmpty()){
            for (Obogrevateli obogrevateli:obogrevateliList){
                obogrevateliDtoList.add(priboriConverter.fromObToObDto(obogrevateli));
            }
            return obogrevateliDtoList;
        }
        return null;
    }

    @Override
    public KonvektoriDto saveKonvektori(KonvektoriDto konvektoriDto) {
        try{
            validatePriboriDto(konvektoriDto);
        } catch (ValidationException e){
            e.printStackTrace();
        }
        List<KonvektoriDto> konvektoriDtoList = new ArrayList<>(findAllK());
        Long a = Long.valueOf(konvektoriDtoList.size());
        konvektoriDto.setId(a+1);
        Konvektori konvektori = priboriConverter.fromKoDtoToKo(konvektoriDto);
        konvektori = konvektoriRepository.save(konvektori);
        return priboriConverter.fromKoToKoDto(konvektori);
    }

    @Override
    public void deleteKonvektori(Long id) {
        konvektoriRepository.deleteById(id);
    }

    @Override
    public KonvektoriDto findByNameK(String name) {
        Konvektori konvektori = konvektoriRepository.findByNameContains(name).get(0);
        if(konvektori != null){
            return  priboriConverter.fromKoToKoDto(konvektori);
        }
        return null;
    }

    @Override
    public List<KonvektoriDto> findAllK() {
        List<Konvektori> konvektoriList = new ArrayList<>(konvektoriRepository.findAll());
        List<KonvektoriDto> konvektoriDtoList = new ArrayList<>();
        if(!konvektoriList.isEmpty()){
            for(Konvektori konvektori:konvektoriList){
                konvektoriDtoList.add(priboriConverter.fromKoToKoDto(konvektori));
            }
            return konvektoriDtoList;
        }
        return null;
    }

    @Override
    public CommentDto saveComment(CommentDto commentDto) {
        try{
            validateComment(commentDto);
        } catch (ValidationException e){
            e.printStackTrace();
        }
        List<CommentDto> commentDtoList;
        Long a = (long)0;
        if (!isNull(findAllC())){
            commentDtoList = new ArrayList<>(findAllC());
            a = (long) commentDtoList.size();
        }
        commentDto.setId(a+1);
        Comment comment = priboriConverter.fromCDtoToC(commentDto);
        comment = commentRepository.save(comment);
        return priboriConverter.fromCToCDto(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto findByNameC(String name) {
        Comment comment = commentRepository.findByNameContains(name).get(0);
        if (comment != null){
            return priboriConverter.fromCToCDto(comment);
        }
        return null;
    }

    @Override
    public List<CommentDto> findAllC() {
        List<Comment> commentList = new ArrayList<>(commentRepository.findAll());
        List<CommentDto> commentDtoList = new ArrayList<>();
        if (!commentList.isEmpty()){
            for (Comment comment: commentList){
                commentDtoList.add(priboriConverter.fromCToCDto(comment));
            }
            return commentDtoList;
        }
        return null;
    }




    public void validatePriboriDto(ObogrevateliDto obogrevateliDto)
            throws ValidationException {
        if (isNull(obogrevateliDto)){
            throw new ValidationException("Объект обогревателя пуст");
        }

        if (isNull(obogrevateliDto.getName()) || obogrevateliDto.getName().isEmpty()) {
            throw new ValidationException("name обогревателя пуст");
        }
        if (isNull(obogrevateliDto.getPrice())) {
            throw new ValidationException("price обогревателя пуст");
        }
    }


    public void validatePriboriDto(KonvektoriDto konvektoriDto)
            throws ValidationException {
        if (isNull(konvektoriDto)){
            throw new ValidationException("Объект конвектора пуст");
        }

        if (isNull(konvektoriDto.getName()) || konvektoriDto.getName().isEmpty()) {
            throw new ValidationException("name конвектора пуст");
        }
        if (isNull(konvektoriDto.getPrice())) {
            throw new ValidationException("price конвектора пуст");
        }
    }

    public void validateComment(CommentDto commentDto) throws ValidationException {
        if (isNull(commentDto)){
            throw new ValidationException("Отзыв прибора пуст");
        }
        if (isNull(commentDto.getName()) || commentDto.getName().isEmpty()) {
            throw new ValidationException("Имя продукта отзыва пусто");
        }

    }

}
