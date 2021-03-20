/*
 * @class CardCommodityService
 * @package org.mindidea.demo.design_01_FactoryMethod.fm01.store.impl
 * @date 2021年2月25日 23:18
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.design_01_FactoryMethod.fm01.store.impl;

import org.mindidea.demo.design_01_FactoryMethod.fm01.store.ICommodity;

import java.util.Map;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 23:18
 * @blog https://mindidea.org
 */
public class CardCommodityService implements ICommodity {
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId,
                              Map<String, String> extMap) throws Exception {

    }
}
