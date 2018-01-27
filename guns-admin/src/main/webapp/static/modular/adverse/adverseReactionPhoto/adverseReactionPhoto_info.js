/**
 * 初始化治疗过程中不良反应记录（病人填表）的图片附件详情对话框
 */
var AdverseReactionPhotoInfoDlg = {
    adverseReactionPhotoInfoData : {},
	validateFields: {
		photoPath: {
	        validators: {
	            notEmpty: {
	                message: '图片附件不能为空'
	            }
	        }
	    },
	    adverseReactionId: {
	        validators: {
	            notEmpty: {
	                message: '治疗过程中不良反应记录（病人填表）主键id不能为空'
	            }
	        }
	    }
	}
};

/**
 * 清除数据
 */
AdverseReactionPhotoInfoDlg.clearData = function() {
    this.adverseReactionPhotoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdverseReactionPhotoInfoDlg.set = function(key, val) {
    this.adverseReactionPhotoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AdverseReactionPhotoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AdverseReactionPhotoInfoDlg.close = function() {
    parent.layer.close(window.parent.AdverseReaction.layerIndex);
}

/**
 * 收集数据
 */
AdverseReactionPhotoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('adverseReactionId')
    .set('photoPath')
    ;
}

$(function() {

	var uploadUrl='/adverseReactionPhoto/upload/'+$("#adverseReactionId").val();
	Feng.log('uploadUrl'+uploadUrl);

    // 初始化附件图片上传
    var photoPathUp = new $WebUpload("photoPath");
    photoPathUp.setUploadBarId("progressBar");
    photoPathUp.setUploadUrl(uploadUrl);
    photoPathUp.init();
});
