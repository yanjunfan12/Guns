package com.stylefeng.guns.modular.adverse.service.impl;

import com.stylefeng.guns.common.persistence.model.AdverseReaction;
import com.stylefeng.guns.common.persistence.dao.AdverseReactionMapper;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 治疗过程中不良反应记录（病人填表） 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-01-26
 */
@Service
public class AdverseReactionServiceImpl extends ServiceImpl<AdverseReactionMapper, AdverseReaction> implements IAdverseReactionService {

}
