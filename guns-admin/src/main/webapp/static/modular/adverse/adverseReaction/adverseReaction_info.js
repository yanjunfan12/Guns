/**
 * 初始化不良反应记录详情对话框
 */
var AdverseReactionInfoDlg = {
    adverseReactionInfoData : {},
	validateFields: {
	    name: {
	        validators: {
	            notEmpty: {
	                message: '姓名不能为空'
	            }
	        }
	    },
	    patientNumber: {
	        validators: {
	            notEmpty: {
	                message: '住院号不能为空'
	            }
	        }
	    }
	}
};

/**
 * 清除数据
 */
AdverseReactionInfoDlg.clearData = function() {
    this.adverseReactionInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdverseReactionInfoDlg.set = function(key, val) {
    this.adverseReactionInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdverseReactionInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AdverseReactionInfoDlg.close = function() {
    parent.layer.close(window.parent.AdverseReaction.layerIndex);
}

/**
 * 收集数据
 */
AdverseReactionInfoDlg.collectData = function() {
    this
    .set('id')
    .set('patientNumber')
    .set('name')
    .set('radiotherapyCount')
    .set('chemotherapyCount')
    .set('weight')
    .set('dietaryStatus')
    .set('weakStatus')
    .set('nauseaStatus')
    .set('vomitStatus')
    .set('diarrheaStatus')
    .set('constipationStatus')
    .set('muscleJointPainStatus')
    .set('nervousSystemStatus')
    .set('alopeciaStatus')
    .set('feverStatus')
    .set('coughStatus')
    .set('skinStatus')
    .set('hiccupStatus')
    .set('oralMucositisStatus')
    .set('hoarsenessStatus')
    .set('hearingStatus')
    .set('dizzyStatus')
    .set('headacheStatus')
    .set('pneumoniaStatus')
    .set('esophagitisStatus')
    .set('otherStatusesDesc')
    .set('photoPath')
    .set('createtime')
    .set('updatetime')
    ;
}

/**
 * 提交添加
 */
AdverseReactionInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/adverseReaction/add", function(data){
        Feng.success("添加成功!");
        window.parent.AdverseReaction.table.refresh();
        AdverseReactionInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.adverseReactionInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AdverseReactionInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/adverseReaction/update", function(data){
        Feng.success("修改成功!");
        window.parent.AdverseReaction.table.refresh();
        AdverseReactionInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.adverseReactionInfoData);
    ajax.start();
}

$(function() {
	Feng.initValidator("adverseReactionInfo", AdverseReactionInfoDlg.validateFields);

    //初始化目前饮食选项
    $("#dietaryStatus").val($("#dietaryStatusValue").val());
});
