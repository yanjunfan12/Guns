//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    text: '治疗记录',
    weakStatusIndex: 0,
    weakStatusArray: [
      {
        id: 5,
        text: '无'
      },
      {
        id: 6,
        text: '乏力'
      }
    ],
    dietaryStatusIndex: 0,
    dietaryStatusArray: [
      {
        id: 1,
        text: '正常饮食'
      },
      {
        id: 2,
        text: '半流质'
      },
      {
        id: 3,
        text: '流质'
      },
      {
        id: 4,
        text: '完全梗阻'
      }
    ],
    toast1Hidden: true,
    modalHidden: true,
    modalHidden2: true,
    notice_str: '',
    formData:{} 
  },
  toast1Change: function (e) {
    this.setData({ toast1Hidden: true });
  },
  //弹出确认框
  modalTap: function (e) {
    this.setData({
      modalHidden: false
    })
  },
  confirm_one: function (e) {
    console.log(e);
    var formData = this.data.formData;
    console.log('formData为', JSON.stringify(formData));
    var that=this;
    wx.request({
      url: 'http://localhost/adverseReaction/add',
      data: formData,
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function (res) {
        console.log(JSON.stringify(res));
        that.setData({
          modalHidden: true,
          toast1Hidden: false,
          notice_str: '提交成功',
          formData: {}
        });
        var theUrl = '/pages/photo/photo?id=' + res.data.message;
        console.log( "theUrl=" + theUrl);
        wx.navigateTo({
          url: theUrl,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })
      }
    })

  },
  cancel_one: function (e) {
    console.log(e);
    this.setData({
      modalHidden: true,
      toast1Hidden: false,
      notice_str: '取消成功'
    });
  },
  //弹出提示框
  modalTap2: function (e) {
    this.setData({
      modalHidden2: false
    })
  },
  modalChange2: function (e) {
    this.setData({
      modalHidden2: true
    })
  },
  bindPickerChangeDietaryStatusIndex: function (e) {
    console.log('DietaryStatus picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      dietaryStatusIndex: e.detail.value
    })
  },
  bindPickerChangeWeakStatusIndex: function (e) {
    console.log('WeakStatus picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      weakStatusIndex: e.detail.value
    })
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  formSubmit: function (e) {
    console.log('formSubmit e=', e);
    this.setData({
      formData : e.detail.value
    });
    this.modalTap();
  },
  formReset: function () {
    console.log('form发生了reset事件');
    this.modalTap2();
  }
})
