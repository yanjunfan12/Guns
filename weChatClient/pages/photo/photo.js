// pages/photo/photo.js
const app = getApp();

Page({
  
  /**
   * 页面的初始数据
   */
  data: {
    text: '记录附件',
    name:null,
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    src: [],
    hints: '',
    modalHidden2: true
  },
  nameBindblur: function (event){
    console.log("event=" + JSON.stringify(event));
    this.setData({
      name: event.detail.value
    });
  },
  //弹出提示框
  modalTap2: function (msg) {
    this.setData({
      modalHidden2: false,
      hints: msg
    })
  },
  modalChange2: function (e) {
    this.setData({
      modalHidden2: true
    })
  },
  gotoShow: function () {
    var that = this;
    wx.chooseImage({
      count: 1, // 最多可以选择的图片张数，默认9
      sizeType: ['original', 'compressed'], // original 原图，compressed 压缩图，默认二者都有
      sourceType: ['album', 'camera'], // album 从相册选图，camera 使用相机，默认二者都有
      success: function (res) {
        // success
        console.log(res);
        that.setData({
          src: res.tempFilePaths
        })
      },
      fail: function () {
        console.log("gotoShow fail");
        that.modalTap2("图片选择失败");
      },
      complete: function () {
        // complete
      }
    })
  },
  uploadPhoto: function () {
    var that = this;
    var theId = this.data.userInfo.nickName;
    if (null == theId) {
      console.warn("未获得微信昵称");
      that.modalTap2("未获得微信昵称");
      return;
    }
    var name=this.data.name;
    if (null == name||name.trim().length<1) {
      console.warn("姓名不能为空" + name);
      that.modalTap2("姓名不能为空");
      return;
    }
    var theUrl = app.globalData.fanUrlHead + '/adverseReactionPhoto/upload/'+name+'/'+theId;
    console.log("theUrl=" + theUrl);
    var theSrc = that.data.src;
    console.log("theSrc=" + JSON.stringify(theSrc));
    if (theSrc.length<1){
      console.warn("未选择图片" + theUrl);
      that.modalTap2("未选择图片");
      return;
    }

    wx.uploadFile({
      url: theUrl, //仅为示例 
      filePath: theSrc[0],
      name: 'file',
      success: function (res) {        
        console.log("上传成功返回：" + JSON.stringify(res));
        var obj = JSON.parse(res.data);
        var resultCode = obj.code;
        var msg = obj.message;
        if (resultCode != 200) {
          console.warn(theUrl+"服务器返回结果不为200,为" + JSON.stringify(res));
          that.modalTap2('上传失败:' + msg);
        } else {
          that.setData({
            src: [],
            name: null
          });
          that.modalTap2("上传成功");
        }
      },
      fail: function () {
        console.error("上传失败 fail " + theUrl);
        that.modalTap2("上传失败,请确保网络可用,重新上传");
      },
      complete:function(){        
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      id: options.id
    })
    this.getUserInfo();
  },
  getUserInfo: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})