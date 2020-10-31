package com.smart.ssm.service;

import com.smart.ssm.request.CartsRequestParams;
import com.smart.ssm.vo.CartsVo;

import java.util.List;

public interface CartsService {
    int saveCarts(CartsRequestParams cartsRequestParams);
    List<CartsVo> findAll(int uid);

    int delCarts(CartsRequestParams cartsRequestParams);

    int update(int cartsId);
}
