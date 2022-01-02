package com.example.houseutils.controller;

import com.example.houseutils.constants.ActionType;
import com.example.houseutils.policy.BrokeragePolicy;
import com.example.houseutils.policy.BrokeragePolicyFactory;
import com.example.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 중계수수료가 얼마인지 조회할하는 컨트롤러
 *
 */
@RestController
@AllArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType acitonType,@RequestParam Long price){
        BrokeragePolicy policy = BrokeragePolicyFactory.of(acitonType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(@PathVariable("apartmentId") Long apartmentId,
                                           @RequestParam ActionType actionType){
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(apartmentService.getPriceOrThrow(apartmentId));
    }
}
