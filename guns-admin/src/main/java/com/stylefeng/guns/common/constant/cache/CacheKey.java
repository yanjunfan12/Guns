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
     * 根据父节点名称parentName，找出其所有字典（字典编号为主键，字典为内容的Map） 缓存key开头标识
     */
    String DICT_PNAME = "dict_pname_";

}
