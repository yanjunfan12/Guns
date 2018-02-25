package com.stylefeng.guns.modular.adverse.warpper;

import java.util.Map;

import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

/**
 * 报销列表的包装
 *
 * @author fanyj
 * @date 2018年01月28日21:56:06
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

        Integer weakStatus = (Integer) map.get("weakStatus");
        String weakStatusName=ConstantFactory.me().getDictsByName("乏力", weakStatus);
        map.put("weakStatusName", weakStatusName);

        Integer nauseaStatus = (Integer) map.get("nauseaStatus");
        String nauseaStatusName=ConstantFactory.me().getDictsByName("恶心", nauseaStatus);
        map.put("nauseaStatusName", nauseaStatusName);

        Integer vomitStatus = (Integer) map.get("vomitStatus");
        String vomitStatusName=ConstantFactory.me().getDictsByName("呕吐", vomitStatus);
        map.put("vomitStatusName", vomitStatusName);

        Integer diarrheaStatus = (Integer) map.get("diarrheaStatus");
        String diarrheaStatusName=ConstantFactory.me().getDictsByName("腹泻", diarrheaStatus);
        map.put("diarrheaStatusName", diarrheaStatusName);

        Integer constipationStatus = (Integer) map.get("constipationStatus");
        String constipationStatusName=ConstantFactory.me().getDictsByName("便秘", constipationStatus);
        map.put("constipationStatusName", constipationStatusName);

        Integer muscleJointPainStatus = (Integer) map.get("muscleJointPainStatus");
        String muscleJointPainStatusName=ConstantFactory.me().getDictsByName("肌肉关节痛", muscleJointPainStatus);
        map.put("muscleJointPainStatusName", muscleJointPainStatusName);

        Integer nervousSystemStatus = (Integer) map.get("nervousSystemStatus");
        String nervousSystemStatusName=ConstantFactory.me().getDictsByName("神经系统", nervousSystemStatus);
        map.put("nervousSystemStatusName", nervousSystemStatusName);

        Integer alopeciaStatus = (Integer) map.get("alopeciaStatus");
        String alopeciaStatusName=ConstantFactory.me().getDictsByName("脱发", alopeciaStatus);
        map.put("alopeciaStatusName", alopeciaStatusName);

        Integer feverStatus = (Integer) map.get("feverStatus");
        String feverStatusName=ConstantFactory.me().getDictsByName("发热", feverStatus);
        map.put("feverStatusName", feverStatusName);

        Integer coughStatus = (Integer) map.get("coughStatus");
        String coughStatusName=ConstantFactory.me().getDictsByName("咳嗽", coughStatus);
        map.put("coughStatusName", coughStatusName);


        Integer skinStatus = (Integer) map.get("skinStatus");
        String skinStatusName=ConstantFactory.me().getDictsByName("放射性皮肤损伤", skinStatus);
        map.put("skinStatusName", skinStatusName);

        Integer hiccupStatus = (Integer) map.get("hiccupStatus");
        String hiccupStatusName=ConstantFactory.me().getDictsByName("打嗝", hiccupStatus);
        map.put("hiccupStatusName", hiccupStatusName);

        Integer oralMucositisStatus = (Integer) map.get("oralMucositisStatus");
        String oralMucositisStatusName=ConstantFactory.me().getDictsByName("口腔黏膜炎", oralMucositisStatus);
        map.put("oralMucositisStatusName", oralMucositisStatusName);

        Integer hoarsenessStatus = (Integer) map.get("hoarsenessStatus");
        String hoarsenessStatusName=ConstantFactory.me().getDictsByName("声嘶", hoarsenessStatus);
        map.put("hoarsenessStatusName", hoarsenessStatusName);

        Integer hearingStatus = (Integer) map.get("hearingStatus");
        String hearingStatusName=ConstantFactory.me().getDictsByName("听力损伤", hearingStatus);
        map.put("hearingStatusName", hearingStatusName);

        Integer dizzyStatus = (Integer) map.get("dizzyStatus");
        String dizzyStatusName=ConstantFactory.me().getDictsByName("头晕", dizzyStatus);
        map.put("dizzyStatusName", dizzyStatusName);

        Integer headacheStatus = (Integer) map.get("headacheStatus");
        String headacheStatusName=ConstantFactory.me().getDictsByName("头痛", headacheStatus);
        map.put("headacheStatusName", headacheStatusName);

        Integer pneumoniaStatus = (Integer) map.get("pneumoniaStatus");
        String pneumoniaStatusName=ConstantFactory.me().getDictsByName("肺炎", pneumoniaStatus);
        map.put("pneumoniaStatusName", pneumoniaStatusName);

        Integer esophagitisStatus = (Integer) map.get("esophagitisStatus");
        String esophagitisStatusName=ConstantFactory.me().getDictsByName("进食痛", esophagitisStatus);
        map.put("esophagitisStatusName", esophagitisStatusName);

        Integer category = (Integer) map.get("category");
        String categoryName=ConstantFactory.me().getDictsByName("分类", category);
        map.put("categoryName", categoryName);
        
    }

}
