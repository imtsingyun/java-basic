/*
 * @class GoodsService
 * @package org.mindidea.demo.design_01_FactoryMethod.d00.goods
 * @date 2021年2月25日 23:04
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.demo.design_01_FactoryMethod.fm00.goods;

import com.alibaba.fastjson.JSON;

/**
 * 模拟实物商品服务
 *
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 23:04
 * @blog https://mindidea.org
 */
public class GoodsService {
    public Boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}
