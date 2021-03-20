/*
 * @class IQiYiCardService
 * @package org.mindidea.demo.design_01_FactoryMethod.d00.card
 * @date 2021年2月25日 22:44
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.design_01_FactoryMethod.fm00.card;

/**
 * 模拟爱奇艺会员卡服务
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 22:44
 * @blog https://mindidea.org
 */
public class IQiYiCardService {
    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
    }
}
