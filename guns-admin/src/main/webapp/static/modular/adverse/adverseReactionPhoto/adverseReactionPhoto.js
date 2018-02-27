/**
 * 不良反应记录附件管理初始化
 */
var AdverseReactionPhoto = {
    id: "AdverseReactionPhotoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
AdverseReactionPhoto.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '图片路径', field: 'photoPath', visible: true, align: 'center', valign: 'middle'},
            {title: '上传人', field: 'createUser', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '填表日期', field: 'createtime', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '修改日期', field: 'updatetime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
AdverseReactionPhoto.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        AdverseReactionPhoto.seItem = selected[0];
        return true;
    }
};

/**
 * 下载符合条件的不良反应附件列表
 *
 * ajax方式请求的数据只能存放在javascipt内存空间，可以通过javascript访问，但是无法保存到硬盘
 * 故换为
 * 模拟表单提交同步方式下载文件
 * 能够弹出保存文件对话框
 */
AdverseReactionPhoto.exportAll = function () {
    //提交信息
	var downloadUrl= Feng.ctxPath + "/adverseReactionPhoto/exportAll";

    Feng.log("downloadUrl="+downloadUrl);

    var nameCon = $("#name").val();

    var form = $("<form></form>").attr("action", downloadUrl).attr("method", "post");
    form.append($("<input></input>").attr("type", "hidden").attr("name", "name").attr("value", nameCon));
    form.appendTo('body').submit().remove();
};

/**
 * 下载符合条件的不良反应附件zip包
 *
 * ajax方式请求的数据只能存放在javascipt内存空间，可以通过javascript访问，但是无法保存到硬盘
 * 故换为
 * 模拟表单提交同步方式下载文件
 * 能够弹出保存文件对话框
 */
AdverseReactionPhoto.downloadAll = function () {
    //提交信息
	var downloadUrl= Feng.ctxPath + "/adverseReactionPhoto/downloadAll";

    Feng.log("downloadUrl="+downloadUrl);

    var nameCon = $("#name").val();

    var form = $("<form></form>").attr("action", downloadUrl).attr("method", "post");
    form.append($("<input></input>").attr("type", "hidden").attr("name", "name").attr("value", nameCon));
    form.appendTo('body').submit().remove();
};

/**
 * 下载某一条不良反应附件
 */
AdverseReactionPhoto.exportOne = function () {
    if (this.check()) {
        //提交信息
    	var downloadUrl=Feng.ctxPath + "/adverseReactionPhoto/exportOne/" + AdverseReactionPhoto.seItem.id;

        Feng.log("downloadUrl="+downloadUrl);

        var form = $("<form></form>").attr("action", downloadUrl).attr("method", "post");
        form.appendTo('body').submit().remove();
    }
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
AdverseReactionPhoto.formParams = function() {
    var queryData = {};
    queryData['name'] = $("#name").val();

    return queryData;
}

/**
 * 查询不良反应记录附件列表
 */
AdverseReactionPhoto.search = function () {

    AdverseReactionPhoto.table.refresh({query: AdverseReactionPhoto.formParams()});
};

$(function () {
    var defaultColunms = AdverseReactionPhoto.initColumn();
    var table = new BSTable(AdverseReactionPhoto.id, "/adverseReactionPhoto/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(AdverseReactionPhoto.formParams());
    AdverseReactionPhoto.table = table.init();
});
