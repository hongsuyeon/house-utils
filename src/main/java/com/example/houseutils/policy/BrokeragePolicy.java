package com.example.houseutils.policy;

import com.example.houseutils.exception.ErrorCode;
import com.example.houseutils.exception.HouseUtilException;

import java.util.List;

public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

   default Long calculate(Long price){
        BrokerageRule brokerageRules = getRules().stream()
                .filter(rule -> price < rule.getLessThan())
                .findFirst().orElseThrow(()-> new HouseUtilException(ErrorCode.INTERNAL_ERROR));
        return brokerageRules.calcuateMaxBrokerage(price);
    }

}
