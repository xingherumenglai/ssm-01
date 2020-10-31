package com.smart.ssm.service.impl;

import com.smart.ssm.entity.Carts;
import com.smart.ssm.exception.ServiceException;
import com.smart.ssm.mapper.CartsMapper;
import com.smart.ssm.request.CartsRequestParams;
import com.smart.ssm.service.CartsService;
import com.smart.ssm.utils.ColaBeanUtils;
import com.smart.ssm.vo.CartsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.smart.ssm.utils.ErrorStatus.SERVICE_ERROR;

@Service
public class CartServiceImpl implements CartsService {
    @Resource
    CartsMapper cartsMapper;

    @Override
    public int saveCarts(CartsRequestParams cartsRequestParams) {
        int temp = 0;
        try {
         Carts carts = new Carts();
        if (carts!=null){
            int quality=carts.getQuality() +cartsRequestParams.getQuality();
            temp = cartsMapper.updateById(carts.getCartsId(), quality);
        }else {
            carts =new Carts();
            /**
             * 将对象的属性拷贝到另一个对象
             * 1. 属性类型名称要保持一致
             * 参数
             * 参数 要拷贝的的对象
             * 参数  目标对象
             */
            BeanUtils.copyProperties(cartsRequestParams,carts);
            temp = cartsMapper.insert(carts);
        }
        }catch (Exception e){
         throw new ServiceException(SERVICE_ERROR.getMessage(),SERVICE_ERROR.getStatus());
        }
        return temp;

    }

    @Override
    public List<CartsVo> findAll(int uid) {
        List<Carts> carts = cartsMapper.selectList(uid);
        List<CartsVo> cartsVos = ColaBeanUtils.copyListProperties(carts, CartsVo::new);
        return cartsVos;
    }

    @Override
    public int delCarts(CartsRequestParams cartsRequestParams) {
        Carts carts = new Carts();
        int count = cartsMapper.delCartsById(carts.getCartsId(),carts.getProductId());
        return count;

    }

    @Override
    public int update(int cartsId) {
        int i= cartsMapper.updateByCartId(cartsId);
        return i;
    }


}
