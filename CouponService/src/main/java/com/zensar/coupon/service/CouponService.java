package com.zensar.coupon.service;

import java.util.List;

import com.zensar.coupon.entity.CouponDto;

public interface CouponService {

	List<CouponDto> getAllCoupons();

	CouponDto createCoupon(CouponDto coupon, String token);

	String deleteCoupon(long id);

	CouponDto updateCoupon(long couponId, CouponDto coupon);

	String deleteAllCoupons();

	CouponDto findByCouponCode(String couponCode);

}
