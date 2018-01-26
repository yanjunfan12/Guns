package com.stylefeng.guns.modular.adverse.warpper;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.constant.state.ExpenseState;
import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

import java.util.Map;

/**
 * 报销列表的包装
 *
 * @author fengshuonan
 * @date 2017年12月4日21:56:06
 */
public class AdverseReactionWarpper extends BaseControllerWarpper {

    public AdverseReactionWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Integer dietaryStatus = (Integer) map.get("dietaryStatus");

        String dietaryStatusName=ConstantFactory.me().getDictsByName("目前饮食", dietaryStatus);
        map.put("dietaryStatusName", dietaryStatusName);
    }

}
