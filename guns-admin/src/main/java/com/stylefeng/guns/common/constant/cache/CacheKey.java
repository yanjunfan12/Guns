package com.stylefeng.guns.common.constant.cache;

/**
 * 缓存的key集合
 *
 * @author fengshuonan
 * @date 2017-04-25 9:37
 */
public interface CacheKey {

    /**
     * ConstantFactory中的缓存
     */
    String ROLES_NAME = "roles_name_";

    String SINGLE_ROLE_NAME = "single_role_name_";

    String SINGLE_ROLE_TIP = "single_role_tip_";

    String DEPT_NAME = "dept_name_";

    /**
     * 根据字典名称和字典中的值获取对应的名称 缓存key开头标识
     */
    String DICT_PNAME_VAL = "dict_pname_val_";

}
