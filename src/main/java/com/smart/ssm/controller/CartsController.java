package com.smart.ssm.controller;


import com.smart.ssm.entity.Carts;
import com.smart.ssm.request.CartsRequestParams;
import com.smart.ssm.service.CartsService;
import com.smart.ssm.utils.ResponseEntity;
import com.smart.ssm.vo.CartsVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    CartsService cartsService;

    /**
     * 通过id查询购物车信息
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<CartsVo>>list(@RequestParam("userId") int userId){
      try {
          List<CartsVo>  allCarts = cartsService.findAll(userId);
          return ResponseEntity.success(allCarts);
      }catch (Exception e){
          return ResponseEntity.error();
      }
    }

    /**
     * 添加购物车
     * @param cartsRequestParams
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Object>add(CartsRequestParams cartsRequestParams){
        boolean flag =false;
        try {
           int count = cartsService.saveCarts(cartsRequestParams);
           if (count>0){
               return ResponseEntity.success(true);
           }
           else {
               return ResponseEntity.error();
           }
        }catch (Exception e){
           return ResponseEntity.error();
        }
    }
    /**
     *删除购物车
     */
    @PutMapping("/del")
    public ResponseEntity<Object> del(CartsRequestParams cartsRequestParams) {
        int i = cartsService.delCarts(cartsRequestParams);
        try {
            if (i>0){
                return ResponseEntity.success(true);
            }else {
                return ResponseEntity.error();
            }

        }catch (Exception e){
            return ResponseEntity.error();
        }
    }
    /**
     * 修改购物车数量
     */
    @PutMapping("/update")
    public List<Carts>update(@RequestParam int cartsId){
        int update = cartsService.update(cartsId);
        return (List<Carts>) list(update);
    }
}
