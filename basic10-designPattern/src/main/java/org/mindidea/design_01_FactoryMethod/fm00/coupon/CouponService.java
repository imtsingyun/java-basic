/*
 * @class CouponService
 * @package org.mindidea.design_01_FactoryMethod.d00.coupon
 * @date 2021年2月25日 23:03
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design_01_FactoryMethod.fm00.coupon;

/**
 * 模拟优惠券服务
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 23:03
 * @blog https://mindidea.org
 */
public class CouponService {

    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }

}
