/*
 * @class ICommodity
 * @package org.mindidea.design_01_FactoryMethod.fm01.store
 * @date 2021年2月25日 23:17
 * Copyright (c) 2021 MindIdea.org, All Rights Reserved.
 */
package org.mindidea.design_01_FactoryMethod.fm01.store;

import java.util.Map;

/**
 * @author Tsingyun(青雲)
 * @version V1.0
 * @createTime 2021年2月25日 23:17
 * @blog https://mindidea.org
 */
public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId,
                       Map<String, String> extMap) throws Exception;
}
