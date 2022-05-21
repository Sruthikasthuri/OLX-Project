package com.zensar.couponController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.coupon.entity.CouponDto;
import com.zensar.coupon.service.CouponService;

@RestController

@RequestMapping(value = "/coupons")
public class CouponController {

	@Autowired
	private CouponService couponService;

	@GetMapping(value = "/coupon/{couponCode}")
	public CouponDto findByCouponCode(@PathVariable String couponCode) {
		System.out.println("Server Instance 1");
		return couponService.findByCouponCode(couponCode);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CouponDto> getAllCoupons() {
		return couponService.getAllCoupons();
	}

	@PostMapping("/create")
	public ResponseEntity<CouponDto> createCoupons(@RequestBody CouponDto coupon,
			@RequestHeader("auth-token") String token) {

		CouponDto createCoupon = couponService.createCoupon(coupon, token);
		if (createCoupon == null) {
			return new ResponseEntity<CouponDto>(createCoupon, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<CouponDto>(createCoupon, HttpStatus.CREATED);
		}

	}

	@DeleteMapping("/coupon/{couponId}")
	public String deleteProduct(@PathVariable("couponId") long id) {
		return couponService.deleteCoupon(id);
	}

	@PutMapping("/update/{productId}")
	public CouponDto updateCoupon(@PathVariable Integer couponId, @RequestBody CouponDto coupon) {
		return couponService.updateCoupon(couponId, coupon);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteAllCoupons() {
		String returnResult = couponService.deleteAllCoupons();

		return new ResponseEntity<String>(returnResult, HttpStatus.OK);

	}
}
