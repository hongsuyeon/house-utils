package com.example.houseutils.service;

import com.example.houseutils.exception.ErrorCode;
import com.example.houseutils.exception.HouseUtilException;
import com.example.houseutils.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId){
        return apartmentRepository.findById(apartmentId)
                .orElseThrow(() -> new HouseUtilException(ErrorCode.DATA_NOT_FOUND)).getPrice();
    }



}
