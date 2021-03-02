/*
 * @class CouponCommodityService
 * @package org.mindidea.design_01_FactoryMethod.fm01.store.impl
 * @date 2021年2月25日 23:18
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design_01_FactoryMethod.fm01.store.impl;

import com.alibaba.fastjson.JSON;
import org.mindidea.design_01_FactoryMethod.fm00.coupon.CouponResult;
import org.mindidea.design_01_FactoryMethod.fm00.coupon.CouponService;
import org.mindidea.design_01_FactoryMethod.fm01.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 23:18
 * @blog https://mindidea.org
 */
public class CouponCommodityService implements ICommodity {

    private Logger log = LoggerFactory.getLogger(CouponCommodityService.class);
    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId,
                              Map<String, String> extMap) throws Exception {

        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId:{} commodityId:{} bizId:{} extMap:{}",
                uId, commodityId, JSON.toJSON(extMap));
    }
}
