package com.stylefeng.guns.rest.modular.adverse.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.rest.common.persistence.dao.AdverseReactionPhotoMapper;
import com.stylefeng.guns.rest.common.persistence.model.AdverseReactionPhoto;
import com.stylefeng.guns.rest.modular.adverse.service.IAdverseReactionPhotoService;

/**
 * <p>
 * 治疗过程中不良反应记录（病人填表）的图片附件 服务实现类
 * </p>
 *
 * @author fanyj123
 * @since 2018-01-31
 */
@Service
public class AdverseReactionPhotoServiceImpl extends ServiceImpl<AdverseReactionPhotoMapper, AdverseReactionPhoto> implements IAdverseReactionPhotoService {

}
