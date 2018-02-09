<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>获取OpenId</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="/getOpenId/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body>
	<button id="tijiao">提交</button>
	<div class="container">获取openId</div>
	<script>
/* var jsonStr = {"id":"1","accesstoken":"111","expires_in":"3123123","date":"2017-07-30 23:10:59"};
console.log(JSON.stringify(jsonStr));
$.ajax({
                url: "http://www.ylswdl.com/getOpenId/get/updatetoken",
                type: "POST",
                contentType: 'application/json',
                data: JSON.stringify(jsonStr),
                success: function(data){
                    alert(data);
                },
                error: function(res){
                    alert(res.responseText);
                }
            }); */
            
            $(function(){
        	    /* var result;
        	    alert(window.location.href);
        	    var url = encodeURIComponent(window.location.href.split('#')[0]);
        		$.ajax({
        			url:"get/getSignature?requrl="+url,
        			dataType:"json",
        			async:false,
        			success:function(data){
        				wx.config({

        				    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        				
        				    appId: 'wx243442c19d980f0b', // 必填，公众号的唯一标识
        				
        				    timestamp: data.timestamp, // 必填，生成签名的时间戳
        				
        				    nonceStr: data.nonceStr, // 必填，生成签名的随机串
        				
        				    signature: data.signature,// 必填，签名，见附录1
        				
        				    jsApiList: [
        				    	   'checkJsApi',
        					        'onMenuShareTimeline',
        					        'onMenuShareAppMessage',
        					        'onMenuShareQQ',
        					        'onMenuShareWeibo',
        					        'hideMenuItems',
        					        'showMenuItems',
        					        'hideAllNonBaseMenuItem',
        					        'showAllNonBaseMenuItem',
        					        'translateVoice',
        					        'startRecord',
        					        'stopRecord',
        					        'onRecordEnd',
        					        'playVoice',
        					        'pauseVoice',
        					        'stopVoice',
        					        'uploadVoice',
        					        'downloadVoice',
        					        'chooseImage',
        					        'previewImage',
        					        'uploadImage',
        					        'downloadImage',
        					        'getNetworkType',
        					        'openLocation',
        					        'getLocation',
        					        'hideOptionMenu',
        					        'showOptionMenu',
        					        'closeWindow',
        					        'scanQRCode',
        					        'chooseWXPay',
        					        'openProductSpecificView',
        					        'addCard',
        					        'chooseCard',
        					        'openCard'
        					        
        				    ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        			
        				});
        			},
        			error:function(data){
        				alert("error");
        				alert(JSON.stringify(data));
        			}
        		});
        		
        		wx.ready(function () {
                
        	        //alert("config ok...");
        	        
        	    });
        	    
        	     var images = {
        		    localId: [],
        		    serverId: []
        		  }; */
        	    
        		$("#tijiao").click(function(){
        			 /* wx.chooseImage({
        				    count: 1, // 默认9
        				    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
        				    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
        				    success: function (res) {
        				        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
        				    }
        				}); */
        				//var json = {base64: "1111asdasd"};
        				var json = {"touser":"ovrp5jstB3GrH6gRGlBkUojiGrpo","template_id":"5na8_B5V3P7uPljpIVAvtXtwq1R61LrwC9Gu8yIlOuU","url":"","topcolor":"#FF0000","data":{"first":{"value":"尊敬的客户：您已成功绑定中国光大银行微信银行"},"keyword1":{"value":"2017-08-19"},"keyword2":{"value":"2017-08-19"},"keyword3":{"value":"测试"},"remark":{"value":"即刻享受微信银行服务吧！"}}};
        				$.ajax({
                			url:"http://www.wegoaldx.com/getOpenId//get/Send",
                			dataType:"json",
                            type: "POST",
                            contentType: 'application/json',
                			data: JSON.stringify(json),
                			async:false,
                			success:function(data){
                				alert(data);
                			}
        				});
        		});
        		
        		
        	});
</script>
</body>
</html>
