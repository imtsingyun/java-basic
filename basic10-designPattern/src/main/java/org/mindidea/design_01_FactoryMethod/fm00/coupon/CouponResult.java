/*
 * @class CouponResult
 * @package org.mindidea.design_01_FactoryMethod.d00.coupon
 * @date 2021年2月25日 23:03
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design_01_FactoryMethod.fm00.coupon;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 23:03
 * @blog https://mindidea.org
 */
public class CouponResult {
    private String code; // 编码
    private String info; // 描述

    public CouponResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
