package com.stylefeng.guns.rest.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 治疗过程中不良反应记录（病人填表）的图片附件
 * </p>
 *
 * @author fanyj123
 * @since 2018-01-31
 */
@TableName("tbl_adverse_reaction_photo")
public class AdverseReactionPhoto extends Model<AdverseReactionPhoto> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 治疗过程中不良反应记录（病人填表）主键id
     */
    @TableField("adverse_reaction_id")
    private Integer adverseReactionId;
    /**
     * 图片路径
     */
    @TableField("photo_path")
    private String photoPath;
    /**
     * 填表日期
     */
    private Date createtime;
    /**
     * 修改日期
     */
    private Date updatetime;
    /**
     * 保留字段
     */
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdverseReactionId() {
        return adverseReactionId;
    }

    public void setAdverseReactionId(Integer adverseReactionId) {
        this.adverseReactionId = adverseReactionId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AdverseReactionPhoto{" +
        "id=" + id +
        ", adverseReactionId=" + adverseReactionId +
        ", photoPath=" + photoPath +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", version=" + version +
        "}";
    }
}
