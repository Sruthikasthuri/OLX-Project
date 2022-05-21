package com.zensar.coupon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.coupon.entity.Coupon;
import com.zensar.coupon.entity.CouponDto;
import com.zensar.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CouponDto> getAllCoupons() {
		List<Coupon> findAll = couponRepository.findAll();
		List<CouponDto> listCouponResponse = new ArrayList<CouponDto>();
		for (Coupon coupon : findAll) {
			CouponDto map = modelMapper.map(coupon, CouponDto.class);
			listCouponResponse.add(map);
		}
		return listCouponResponse;

	}

	@Override
	public CouponDto createCoupon(CouponDto coupon, String token) {
		Coupon newCoupon = modelMapper.map(coupon, Coupon.class);
		if (token.equalsIgnoreCase("NP66472")) {
			Coupon save = couponRepository.save(newCoupon);
			return modelMapper.map(save, CouponDto.class);

		} else {
			return null;
		}
	}

	@Override
	public String deleteCoupon(long id) {
		couponRepository.deleteById((int) id);
		return "Deleted  " + id;
	}

	@Override
	public CouponDto updateCoupon(long couponId, CouponDto coupon) {
		Optional<Coupon> findById = couponRepository.findById((int) couponId);
		Coupon coupon2 = findById.get();
		coupon2.setCouponCode(coupon.getCouponCode());
		coupon2.setDiscount(coupon.getDiscount());
		coupon2.setExpDate(coupon.getExpDate());
		return modelMapper.map(couponRepository.save(coupon2), CouponDto.class);
	}

	@Override
	public String deleteAllCoupons() {
		couponRepository.deleteAll();
		return "All Coupons Deleted";
	}
	
	@Override
	public CouponDto findByCouponCode(String couponCode) {
		System.out.println("Hello");
		
		return modelMapper.map(couponRepository.findByCouponCode(couponCode), CouponDto.class);
	
	}
}
