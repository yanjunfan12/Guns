package com.stylefeng.guns.rest.modular.adverse.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.rest.common.persistence.dao.AdverseReactionMapper;
import com.stylefeng.guns.rest.common.persistence.model.AdverseReaction;
import com.stylefeng.guns.rest.modular.adverse.service.IAdverseReactionService;

/**
 * <p>
 * 治疗过程中不良反应记录（病人填表） 服务实现类
 * </p>
 *
 * @author fanyj123
 * @since 2018-01-31
 */
@Service
public class AdverseReactionServiceImpl extends ServiceImpl<AdverseReactionMapper, AdverseReaction> implements IAdverseReactionService {

}
