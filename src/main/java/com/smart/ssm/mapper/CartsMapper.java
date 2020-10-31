package com.smart.ssm.mapper;

import com.smart.ssm.entity.Carts;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CartsMapper {
    int insert(Carts carts);

    Carts selectByUserIdAndProductId(@Param("userId") int userId,@Param("productId") int productId);

    int updateById(@Param("cartsId") Integer cartsId, @Param("quality") int quality);

    List<Carts> selectList(@Param("userId") int userId);

    int delCartsById(@Param("cateId") int cateId ,@Param("productId") int productId);


    int updateByCartId(@Param("cartsId") int cartsId);
}
