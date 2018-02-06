package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 治疗过程中不良反应记录（病人填表）
 * </p>
 *
 * @author fanyj123
 * @since 2018-01-31
 */
@TableName("tbl_adverse_reaction")
@ApiModel(value="治疗过程中不良反应记录的请求数据对象AdverseReaction",description="治疗过程中不良反应记录的请求数据对象")
public class AdverseReaction extends Model<AdverseReaction> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键id",required=false,hidden=true)
    private Integer id;
    /**
     * 住院号
     */
    @ApiModelProperty(value="住院号",required=true)
    @TableField("patient_number")
    private String patientNumber;
    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名",required=true)
    private String name;
    /**
     * 放疗次数
     */
    @TableField("radiotherapy_count")
    @ApiModelProperty(value="放疗次数",required=true)
    private Integer radiotherapyCount;
    /**
     * 化疗次数
     */
    @TableField("chemotherapy_count")
    @ApiModelProperty(value="化疗次数",required=true)
    private Integer chemotherapyCount;
    /**
     * 体重，单位kg
     */
    @ApiModelProperty(value="体重，单位kg",required=true)
    private BigDecimal weight;
    /**
     * 目前饮食：○ 1 正常饮食  ○ 2 半流质  ○ 3 流质  ○ 4 完全梗阻
     */
    @TableField("Dietary_status")
    @ApiModelProperty(value="目前饮食：○ 1 正常饮食  ○ 2 半流质  ○ 3 流质  ○ 4 完全梗阻",required=true)
    private Integer dietaryStatus;
    /**
     * 乏力  ○ 0 无  ○ 1 休息后可缓解  ○ 2 休息后不能缓解，影响日常生活  ○ 3 生活无法自理
     */
    @TableField("weak_status")
    @ApiModelProperty(value="乏力  ○ 0 无  ○ 1 休息后可缓解  ○ 2 休息后不能缓解，影响日常生活  ○ 3 生活无法自理",required=true)
    private Integer weakStatus;
    /**
     * 恶心  ○ 0 无  ○ 1 食欲降低但进食量不变  ○ 2 进食量减少   ○ 3 静脉或鼻饲营养
     */
    @TableField("nausea_status")
    @ApiModelProperty(value="恶心  ○ 0 无  ○ 1 食欲降低但进食量不变  ○ 2 进食量减少   ○ 3 静脉或鼻饲营养",required=true)
    private Integer nauseaStatus;
    /**
     * 呕吐  ○ 0 无  ○ 1 每天 1-2 次      ○ 2 每天 3-5 次       ○ 3 每天 6 次及以上
     */
    @TableField("Vomit_status")
    @ApiModelProperty(value="呕吐  ○ 0 无  ○ 1 每天 1-2 次      ○ 2 每天 3-5 次       ○ 3 每天 6 次及以上",required=true)
    private Integer vomitStatus;
    /**
     * 腹泻  ○ 0 无  ○ 1 与治疗前相比增加少于 4 次/天   ○ 2 4-6 次/天  ○ 3 7 次/天及以上
     */
    @TableField("diarrhea_status")
    @ApiModelProperty(value="腹泻  ○ 0 无  ○ 1 与治疗前相比增加少于 4 次/天   ○ 2 4-6 次/天  ○ 3 7 次/天及以上",required=true)
    private Integer diarrheaStatus;
    /**
     * 便秘  ○ 0 无  ○ 1 偶尔需用药物    ○ 2 持续使用药物     ○ 3 需手工疏通
     */
    @TableField("constipation_status")
    @ApiModelProperty(value="便秘  ○ 0 无  ○ 1 偶尔需用药物    ○ 2 持续使用药物     ○ 3 需手工疏通",required=true)
    private Integer constipationStatus;
    /**
     * 肌肉关节痛  ○ 0 无  ○ 1 轻微，无须处理  ○ 2 影响日常生活     ○ 3 生活无法自理
     */
    @TableField("Muscle_joint_pain_status")
    @ApiModelProperty(value="肌肉关节痛  ○ 0 无  ○ 1 轻微，无须处理  ○ 2 影响日常生活     ○ 3 生活无法自理",required=true)
    private Integer muscleJointPainStatus;
    /**
     * 神经系统  ○ 0 无  ○ 1 手脚麻木，不影响日常生活  ○ 2 影响日常生活  ○ 3 生活无法自理
     */
    @TableField("nervous_system_status")
    @ApiModelProperty(value="神经系统  ○ 0 无  ○ 1 手脚麻木，不影响日常生活  ○ 2 影响日常生活  ○ 3 生活无法自理",required=true)
    private Integer nervousSystemStatus;
    /**
     * 脱发  ○ 0 无  ○ 1 较治疗前头发减少少于一半  ○ 2 头发减少大于一半或需佩戴假发
     */
    @TableField("Alopecia_status")
    @ApiModelProperty(value="脱发  ○ 0 无  ○ 1 较治疗前头发减少少于一半  ○ 2 头发减少大于一半或需佩戴假发",required=true)
    private Integer alopeciaStatus;
    /**
     * 发热 ○ 0 无  ○ 1 38.0－39.0 度             ○ 2 39.1-40.0 度   ○ 3 高于 40.0 度小于 24 小时    ○ 4 高于 40.0 度大于 24 小时
     */
    @TableField("fever_status")
    @ApiModelProperty(value="发热 ○ 0 无  ○ 1 38.0－39.0 度             ○ 2 39.1-40.0 度   ○ 3 高于 40.0 度小于 24 小时    ○ 4 高于 40.0 度大于 24 小时",required=true)
    private Integer feverStatus;
    /**
     * 咳嗽 ○ 0 无  ○ 1 症状轻微，仅需非处方药（如甘草口服液）          ○ 2 影响日常生活，需处方药（如可待因）      ○ 3 生活无法自理
     */
    @TableField("cough_status")
    @ApiModelProperty(value="咳嗽 ○ 0 无  ○ 1 症状轻微，仅需非处方药（如甘草口服液）          ○ 2 影响日常生活，需处方药（如可待因）      ○ 3 生活无法自理",required=true)
    private Integer coughStatus;
    /**
     * 放射性 皮肤损伤 ○ 0 无  ○ 1 点状红斑或干性脱皮  ○ 2 片状红斑或小块湿性脱皮或水肿       ○ 3 大片湿性脱皮        ○ 4 溃疡、出血
     */
    @TableField("skin_status")
    @ApiModelProperty(value="放射性 皮肤损伤 ○ 0 无  ○ 1 点状红斑或干性脱皮  ○ 2 片状红斑或小块湿性脱皮或水肿       ○ 3 大片湿性脱皮        ○ 4 溃疡、出血",required=true)
    private Integer skinStatus;
    /**
     * 打嗝  ○ 0 无  ○ 1 症状轻微不需药物  ○ 2 影响日常生活，需要药物  ○ 3 影响睡眠
     */
    @TableField("Hiccup_status")
    @ApiModelProperty(value="打嗝  ○ 0 无  ○ 1 症状轻微不需药物  ○ 2 影响日常生活，需要药物  ○ 3 影响睡眠",required=true)
    private Integer hiccupStatus;
    /**
     * 口腔黏膜炎  ○ 0 无  ○ 1 稍有疼痛  ○ 2 因口腔黏膜需要调整饮食  ○ 3 因口腔黏膜进食困难
     */
    @TableField("Oral_mucositis_status")
    @ApiModelProperty(value="口腔黏膜炎  ○ 0 无  ○ 1 稍有疼痛  ○ 2 因口腔黏膜需要调整饮食  ○ 3 因口腔黏膜进食困难",required=true)
    private Integer oralMucositisStatus;
    /**
     * 声嘶  ○ 0 无  ○ 1 话语不影响理解   ○ 2 需偶尔重复   ○ 3 症状持续且话语难以理解
     */
    @TableField("Hoarseness_status")
    @ApiModelProperty(value="声嘶  ○ 0 无  ○ 1 话语不影响理解   ○ 2 需偶尔重复   ○ 3 症状持续且话语难以理解",required=true)
    private Integer hoarsenessStatus;
    /**
     * 听力损伤  ○ 0 无  ○ 1 感觉听力下降，无须处理    ○ 2 需用助听器
     */
    @TableField("hearing_status")
    @ApiModelProperty(value="听力损伤  ○ 0 无  ○ 1 感觉听力下降，无须处理    ○ 2 需用助听器",required=true)
    private Integer hearingStatus;
    /**
     * 头晕  ○ 0 无  ○ 1 轻微，无须处理   ○ 2 影响日常生活   ○ 3 生活无法自理
     */
    @TableField("Dizzy_status")
    @ApiModelProperty(value="头晕  ○ 0 无  ○ 1 轻微，无须处理   ○ 2 影响日常生活   ○ 3 生活无法自理",required=true)
    private Integer dizzyStatus;
    /**
     * 头痛  ○ 0 无  ○ 1 轻微，无须处理   ○ 2 影响日常生活   ○ 3 生活无法自理
     */
    @TableField("headache_status")
    @ApiModelProperty(value="头痛  ○ 0 无  ○ 1 轻微，无须处理   ○ 2 影响日常生活   ○ 3 生活无法自理",required=true)
    private Integer headacheStatus;
    /**
     * 肺炎 ○ 0 无  ○ 1 轻度干咳，无需处理或仅需口服药 ○ 2 持续性咳嗽需静脉用药（激素）  ○ 3 止咳药无作用或休息时呼吸困难、需吸氧        ○ 4 需呼吸机
     */
    @TableField("pneumonia_status")
    @ApiModelProperty(value="肺炎 ○ 0 无  ○ 1 轻度干咳，无需处理或仅需口服药 ○ 2 持续性咳嗽需静脉用药（激素）  ○ 3 止咳药无作用或休息时呼吸困难、需吸氧        ○ 4 需呼吸机",required=true)
    private Integer pneumoniaStatus;
    /**
     * 进食痛 （食管炎） ○ 0 无  ○ 1 疼痛轻微，无须处理或仅需口服药  ○ 2 疼痛中等，需静脉输液治疗  ○ 3 疼痛严重，需鼻饲（经管道进食）或肠外营养    ○ 4 食管穿孔
     */
    @TableField("Esophagitis_status")
    @ApiModelProperty(value="进食痛 （食管炎） ○ 0 无  ○ 1 疼痛轻微，无须处理或仅需口服药  ○ 2 疼痛中等，需静脉输液治疗  ○ 3 疼痛严重，需鼻饲（经管道进食）或肠外营养    ○ 4 食管穿孔",required=true)
    private Integer esophagitisStatus;
    /**
     * 其他症状，请在下面详细描述：
     */
    @TableField("other_statuses_desc")
    @ApiModelProperty(value="其他症状",required=true)
    private String otherStatusesDesc;
    /**
     * 填表日期
     */
    @ApiModelProperty(value="填表日期",required=false,hidden=true)
    private Date createtime;
    /**
     * 修改日期
     */
    @ApiModelProperty(value="修改日期",required=false,hidden=true)
    private Date updatetime;
    /**
     * 保留字段
     */
    @ApiModelProperty(value="保留字段",required=false,hidden=true)
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRadiotherapyCount() {
        return radiotherapyCount;
    }

    public void setRadiotherapyCount(Integer radiotherapyCount) {
        this.radiotherapyCount = radiotherapyCount;
    }

    public Integer getChemotherapyCount() {
        return chemotherapyCount;
    }

    public void setChemotherapyCount(Integer chemotherapyCount) {
        this.chemotherapyCount = chemotherapyCount;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getDietaryStatus() {
        return dietaryStatus;
    }

    public void setDietaryStatus(Integer dietaryStatus) {
        this.dietaryStatus = dietaryStatus;
    }

    public Integer getWeakStatus() {
        return weakStatus;
    }

    public void setWeakStatus(Integer weakStatus) {
        this.weakStatus = weakStatus;
    }

    public Integer getNauseaStatus() {
        return nauseaStatus;
    }

    public void setNauseaStatus(Integer nauseaStatus) {
        this.nauseaStatus = nauseaStatus;
    }

    public Integer getVomitStatus() {
        return vomitStatus;
    }

    public void setVomitStatus(Integer vomitStatus) {
        this.vomitStatus = vomitStatus;
    }

    public Integer getDiarrheaStatus() {
        return diarrheaStatus;
    }

    public void setDiarrheaStatus(Integer diarrheaStatus) {
        this.diarrheaStatus = diarrheaStatus;
    }

    public Integer getConstipationStatus() {
        return constipationStatus;
    }

    public void setConstipationStatus(Integer constipationStatus) {
        this.constipationStatus = constipationStatus;
    }

    public Integer getMuscleJointPainStatus() {
        return muscleJointPainStatus;
    }

    public void setMuscleJointPainStatus(Integer muscleJointPainStatus) {
        this.muscleJointPainStatus = muscleJointPainStatus;
    }

    public Integer getNervousSystemStatus() {
        return nervousSystemStatus;
    }

    public void setNervousSystemStatus(Integer nervousSystemStatus) {
        this.nervousSystemStatus = nervousSystemStatus;
    }

    public Integer getAlopeciaStatus() {
        return alopeciaStatus;
    }

    public void setAlopeciaStatus(Integer alopeciaStatus) {
        this.alopeciaStatus = alopeciaStatus;
    }

    public Integer getFeverStatus() {
        return feverStatus;
    }

    public void setFeverStatus(Integer feverStatus) {
        this.feverStatus = feverStatus;
    }

    public Integer getCoughStatus() {
        return coughStatus;
    }

    public void setCoughStatus(Integer coughStatus) {
        this.coughStatus = coughStatus;
    }

    public Integer getSkinStatus() {
        return skinStatus;
    }

    public void setSkinStatus(Integer skinStatus) {
        this.skinStatus = skinStatus;
    }

    public Integer getHiccupStatus() {
        return hiccupStatus;
    }

    public void setHiccupStatus(Integer hiccupStatus) {
        this.hiccupStatus = hiccupStatus;
    }

    public Integer getOralMucositisStatus() {
        return oralMucositisStatus;
    }

    public void setOralMucositisStatus(Integer oralMucositisStatus) {
        this.oralMucositisStatus = oralMucositisStatus;
    }

    public Integer getHoarsenessStatus() {
        return hoarsenessStatus;
    }

    public void setHoarsenessStatus(Integer hoarsenessStatus) {
        this.hoarsenessStatus = hoarsenessStatus;
    }

    public Integer getHearingStatus() {
        return hearingStatus;
    }

    public void setHearingStatus(Integer hearingStatus) {
        this.hearingStatus = hearingStatus;
    }

    public Integer getDizzyStatus() {
        return dizzyStatus;
    }

    public void setDizzyStatus(Integer dizzyStatus) {
        this.dizzyStatus = dizzyStatus;
    }

    public Integer getHeadacheStatus() {
        return headacheStatus;
    }

    public void setHeadacheStatus(Integer headacheStatus) {
        this.headacheStatus = headacheStatus;
    }

    public Integer getPneumoniaStatus() {
        return pneumoniaStatus;
    }

    public void setPneumoniaStatus(Integer pneumoniaStatus) {
        this.pneumoniaStatus = pneumoniaStatus;
    }

    public Integer getEsophagitisStatus() {
        return esophagitisStatus;
    }

    public void setEsophagitisStatus(Integer esophagitisStatus) {
        this.esophagitisStatus = esophagitisStatus;
    }

    public String getOtherStatusesDesc() {
        return otherStatusesDesc;
    }

    public void setOtherStatusesDesc(String otherStatusesDesc) {
        this.otherStatusesDesc = otherStatusesDesc;
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
        return "AdverseReaction{" +
        "id=" + id +
        ", patientNumber=" + patientNumber +
        ", name=" + name +
        ", radiotherapyCount=" + radiotherapyCount +
        ", chemotherapyCount=" + chemotherapyCount +
        ", weight=" + weight +
        ", dietaryStatus=" + dietaryStatus +
        ", weakStatus=" + weakStatus +
        ", nauseaStatus=" + nauseaStatus +
        ", vomitStatus=" + vomitStatus +
        ", diarrheaStatus=" + diarrheaStatus +
        ", constipationStatus=" + constipationStatus +
        ", muscleJointPainStatus=" + muscleJointPainStatus +
        ", nervousSystemStatus=" + nervousSystemStatus +
        ", alopeciaStatus=" + alopeciaStatus +
        ", feverStatus=" + feverStatus +
        ", coughStatus=" + coughStatus +
        ", skinStatus=" + skinStatus +
        ", hiccupStatus=" + hiccupStatus +
        ", oralMucositisStatus=" + oralMucositisStatus +
        ", hoarsenessStatus=" + hoarsenessStatus +
        ", hearingStatus=" + hearingStatus +
        ", dizzyStatus=" + dizzyStatus +
        ", headacheStatus=" + headacheStatus +
        ", pneumoniaStatus=" + pneumoniaStatus +
        ", esophagitisStatus=" + esophagitisStatus +
        ", otherStatusesDesc=" + otherStatusesDesc +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", version=" + version +
        "}";
    }
}
