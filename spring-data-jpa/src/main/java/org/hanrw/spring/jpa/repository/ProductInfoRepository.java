package org.hanrw.spring.jpa.repository;

import org.hanrw.spring.jpa.entity.ProductInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {
  @Query("update ProductInfo pi set pi.store=pi.store-1 where pi.productId=:productId")
  void updateProductInfo(@Param("productId") Integer productId);
}
