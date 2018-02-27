/**
 * 不良反应记录管理初始化
 */
var AdverseReaction = {
    id: "AdverseReactionTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
AdverseReaction.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '住院号', field: 'patientNumber', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '分类', field: 'categoryName', visible: true, align: 'center', valign: 'middle', sortable: true},            
            {title: '放疗次数', field: 'radiotherapyCount', visible: true, align: 'center', valign: 'middle'},
            {title: '化疗次数', field: 'chemotherapyCount', visible: true, align: 'center', valign: 'middle'},
            {title: '体重', field: 'weight', visible: true, align: 'center', valign: 'middle'},
            {title: '目前饮食', field: 'dietaryStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '乏力', field: 'weakStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '恶心', field: 'nauseaStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '呕吐', field: 'vomitStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '腹泻', field: 'diarrheaStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '便秘', field: 'constipationStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '肌肉关节痛', field: 'muscleJointPainStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '神经系统', field: 'nervousSystemStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '脱发', field: 'alopeciaStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '发热', field: 'feverStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '咳嗽', field: 'coughStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '放射性皮肤损伤', field: 'skinStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '打嗝', field: 'hiccupStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '口腔黏膜炎', field: 'oralMucositisStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '声嘶', field: 'hoarsenessStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '听力损伤', field: 'hearingStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '头晕', field: 'dizzyStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '头痛', field: 'headacheStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '肺炎', field: 'pneumoniaStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '进食痛', field: 'esophagitisStatusName', visible: true, align: 'center', valign: 'middle'},
            {title: '其他症状', field: 'otherStatusesDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '填表人', field: 'createUser', visible: true, align: 'center', valign: 'middle', sortable: false},
            {title: '更新人', field: 'updateUser', visible: true, align: 'center', valign: 'middle', sortable: false},
            {title: '填表日期', field: 'createtime', visible: true, align: 'center', valign: 'middle', sortable: true},
            {title: '修改日期', field: 'updatetime', visible: true, align: 'center', valign: 'middle', sortable: true},
    ];
};

/**
 * 检查是否选中
 */
AdverseReaction.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        AdverseReaction.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加不良反应记录
 */
AdverseReaction.openAddAdverseReaction = function () {
    var index = layer.open({
        type: 2,
        title: '添加不良反应记录',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/adverseReaction/adverseReaction_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看不良反应记录详情
 */
AdverseReaction.openAdverseReactionDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '不良反应记录详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/adverseReaction/adverseReaction_update/' + AdverseReaction.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 下载符合条件的不良反应列表
 *
 * ajax方式请求的数据只能存放在javascipt内存空间，可以通过javascript访问，但是无法保存到硬盘
 * 故换为
 * 模拟表单提交同步方式下载文件
 * 能够弹出保存文件对话框
 */
AdverseReaction.exportAll = function () {
    //提交信息
	var downloadUrl= Feng.ctxPath + "/adverseReaction/exportAll";

    Feng.log("downloadUrl="+downloadUrl);

    var nameCon = $("#name").val();
    var patientNumberCon = $("#patientNumber").val();
    var categoryCon=$("#category").val();

    var form = $("<form></form>").attr("action", downloadUrl).attr("method", "post");
    form.append($("<input></input>").attr("type", "hidden").attr("name", "name").attr("value", nameCon));
    form.append($("<input></input>").attr("type", "hidden").attr("name", "patientNumber").attr("value", patientNumberCon));
    form.append($("<input></input>").attr("type", "hidden").attr("name", "category").attr("value", categoryCon));
    form.appendTo('body').submit().remove();
};

/**
 * 跳转到给某一条不良反应分类页面
 */
AdverseReaction.openCategoryAdverseReaction = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '分类不良反应记录',
            area: ['460px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/adverseReaction/adverseReaction_category/' + AdverseReaction.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
AdverseReaction.formParams = function() {
    var queryData = {};
    queryData['name'] = $("#name").val();
    queryData['patientNumber'] = $("#patientNumber").val();
    queryData['category'] = $("#category").val();

    return queryData;
}

/**
 * 查询不良反应记录列表
 */
AdverseReaction.search = function () {

    AdverseReaction.table.refresh({query: AdverseReaction.formParams()});
};

$(function () {
    var defaultColunms = AdverseReaction.initColumn();
    var table = new BSTable(AdverseReaction.id, "/adverseReaction/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(AdverseReaction.formParams());
    AdverseReaction.table = table.init();
    
	//下拉框中有loadData属性的selectOptions封装
    var fanSelectOptions=new FanSelectOptions();
    fanSelectOptions.init();
});
