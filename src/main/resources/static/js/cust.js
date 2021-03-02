
<!-- 自动加载背景图片开始 -->
function load(){
    document.getElementById("setting-save").onclick();
}
window.onload=function(){
	alert("123")
      document.getElementById("setting-save").click();
}

var $i=function(id){return document.getElementById(id);};
var $n=function(name,target){return (target||document).getElementsByTagName(name);};
var $c=function(name,target){return (target||document).getElementsByClassName(name);};

var CHECK_PRO={
services:{
	server65 :"http://192.168.168.65:8081/ish",
	server66 :"http://192.168.168.66:8081/ish",
	server80 :"http://192.168.168.80:8081/ish",
	server68 :"http://192.168.168.68:8081/ish",
	server69 :"http://192.168.168.69:8081/ish",
	server105 :"http://192.168.168.105:8081/ish",
	server106 :"http://192.168.168.106:8081/ish",
	server82 :"http://192.168.168.82:8081/ish",
	server83 :"http://192.168.168.83:8081/ish",
	server160_51 :"http://192.168.160.51:6110/eportal/",
	server168_51 :"http://192.168.168.51/eportal",
	server168_52 :"http://192.168.168.52:6110/eportal",
	server64_bjgjj :"http://192.168.216.64:8010/bjgjj/user/outLogin_cs.do",
	server65_bjgjj :"http://192.168.216.65:8010/bjgjj/user/outLogin_cs.do",
	server51_gj:"http://192.168.216.51:8075/gjzf",
	server52_gj:"http://192.168.216.52:8075/gjzf",
	server51_dk:"http://192.168.216.51:8076/dk",
	server52_dk:"http://192.168.216.52:8076/dk",
	server53_pl:"http://192.168.216.53:8073/pl",
	server54_pl:"http://192.168.216.54:8073/pl",
	server53_im:"http://192.168.216.53:8074/im",
	server54_im:"http://192.168.216.54:8074/im",
	//OA
    server72_oa:"http://192.168.216.72:4633/jsoa/gslogin.jsp",
    server73_oa:"http://192.168.216.73:4633/jsoa/gslogin.jsp",
    //呼叫中心
    server53_call:"http://192.168.224.53/",
    //单位网上
    server65_dw:"http://192.168.168.65:8081/ish/org.jsp",
    //决策jenkins
    server22_jc:"http://192.168.216.22:9527/jenkins/",
    server27_jc:"http://192.168.216.27:9527/jenkins/",
    //客服平台运营监控
    server_spm:"http://192.168.216.84:8081/spm/beijing-service-monitor/index.html"
	
},
_check:{
	 WSYW:{
		server65 :"http://192.168.168.65:8081/ish",
		server66 :"http://192.168.168.66:8081/ish",
		server80 :"http://192.168.168.80:8081/ish",
		server68 :"http://192.168.168.68:8081/ish",
		server69 :"http://192.168.168.69:8081/ish"
	},
	ZWWZ:{
		server160_51 :"http://192.168.160.51:6110/eportal/",
		server168_51 :"http://192.168.168.51/eportal",
		server168_52 :"http://192.168.168.52:6110/eportal"
	},
	NBMH:{
		server64_bjgjj :"http://192.168.216.64:8010/bjgjj/user/outLogin_cs.do",
		server65_bjgjj :"http://192.168.216.65:8010/bjgjj/user/outLogin_cs.do",
		server_bjgjj :"http://zhfwxt.bjgjj/logon/cert.jsp",
	},
	NGGJ:{
		server51_gj:"http://192.168.216.51:8075/gjzf",
		server52_gj:"http://192.168.216.52:8075/gjzf"
	},
	NGDK:{
		server51_dk:"http://192.168.216.51:8076/dk",
		server52_dk:"http://192.168.216.52:8076/dk"
	},
	NGPL:{
		server53_pl:"http://192.168.216.53:8073/pl",
		server54_pl:"http://192.168.216.54:8073/pl"
	},
	NGXX:{
		server53_im:"http://192.168.216.53:8074/im",
		server54_im:"http://192.168.216.54:8074/im"
	},
	JCZC:{
		server_jczc01:"http://192.168.216.27:9527/jenkins",
		server_jczc02:"http://192.168.216.22:9527/jenkins"
	},
	JKPT:{
		server84_jk:"http://192.168.216.84:8081/spm/beijing-service-monitor/index.html"
	}
},
val:0,
blank:00,
maxt:6000,
mint:200,
isopen:true,
open:function(url,id){
	if(this.isopen){
		setTimeout(function(){CHECK_PRO.message(url,id);window.open(url);},this.time());
	}else{
		this.message(url,id);
	}
},
time:function(){this.val+=this.blank;return this.val;},
start:function(item){
	var t=Number($i("blank-time").value);
	this.blank=t?t<this.mint?this.mint:t>this.maxt?this.maxt:t:this.mint;
	this.val=100-this.blank;
	$i("blank-time").value=this.blank;
	this.isopen=$i("isopen").checked;
	var checkItems=(item&&this._check[item])||this.services;
	for(var s in checkItems){
		this.open(checkItems[s],s);
	}
},
message:function(s,id){
	var prefix="open-";
	if(!$i(prefix+id)){
		var el=document.createElement("li");
		el.innerHTML=" OPEN ：<a target='_blank' href='"+s+"'>"+s+"</a>";
		el.id=prefix+id;
		$i("footer").appendChild(el);
	}
}
};

var CHECK_IP={
ips:["192.168.160.54","192.168.160.55","192.168.160.56","192.168.160.57",
     "192.168.168.58","192.168.168.59","192.168.168.61","192.168.168.62",
     "192.168.168.65","192.168.168.66","192.168.168.68","192.168.168.69","192.168.168.80",
	 "192.168.168.82","192.168.168.83","192.168.168.105","192.168.168.106",
	 "192.168.160.51","192.168.168.51","192.168.168.52","192.168.216.64","192.168.216.65",
	 "192.168.216.51","192.168.216.52","192.168.216.53","192.168.216.54","192.168.232.66","192.168.232.67"
	  ],
ip_sort:{
    "FSP":"192.168.160.54,192.168.160.55",
    "移动内容发布":"192.168.160.56,192.168.160.57",
    "支付宝&APP":"192.168.168.58,192.168.168.59",
    "微信":"192.168.168.61,192.168.168.62",
	"单位网上业务":"192.168.168.65,192.168.168.66",
	"个人网上业务":"192.168.168.68,192.168.168.69",
	"政务网站":"192.168.160.51,192.168.168.51,192.168.168.52",
	"内部门户":"192.168.216.64,192.168.216.65",
	"归集&贷款":"192.168.216.51,192.168.216.52",
	"综合&信息":"192.168.216.53,192.168.216.54",
	"中直个人网上业务":"192.168.168.105,192.168.168.106",
	"中直单位网上业务":"192.168.168.82,192.168.168.83",
	"OA":"192.168.216.72,192.168.216.73",
	"短信中心":"192.168.232.66,192.168.232.67",
	"中心服务监控":"192.168.216.57",
	"客服平台运营监控":"192.168.216.84",
	"服务事件":"192.168.216.55,192.168.216.56",
	"服务事件":"192.168.216.55,192.168.216.56",
},
getIpDesc:function(ip){
	for(var desc in this.ip_sort){
		if(this.ip_sort[desc].indexOf(ip)>-1){
			return desc+":"+ip;
		}
	}
	return ip;
},
index:0,
lastindex:0,
_tab:$i("ips"),
ssh:"ssh admin@",
showAll:function(t,ip){
	this.index=0;
	this.lastindex=0;
	if(ip&&ip.length>0)this.ips =ip; 
	$i("ips").innerHTML="";
	for(var i=0;i<this.ips.length;i++){
		if(t>0){
			setTimeout(function(){CHECK_IP.next()},(t||600)*i);
		}else{
			CHECK_IP.next()
		}
	}
},
getTd:function(ip){
	if(!this._tab)this._tab=$i("ips");
	var tds=$n("td",this._tab);
	for(var i=0;i<tds.length;i++){
		if(ip==tds[i].innerText){
			return tds[i];
		}
	}
},
next:function(){
if(this.lastindex==this.index){
	if(this.index<this.ips.length){
		var tab=$i("ips");
		var tr=this.index%4==0?tab.insertRow(tab.rows.length):tab.rows.item(tab.rows.length-1);
		var curip=this.ips[this.index++];
		tr.insertCell().innerHTML=curip;
		this.copy(curip);
	}else{
		this.copy(this.ips[this.index-1]);
		MSG.show("ip-msg","已经是最后一个");
	}
	this.lastindex=this.index;
}else{
	this.copy(this.ips[this.lastindex++]);
}
},
last:function(){
	if(this.lastindex>1){
		this.lastindex--;
	}else{
		MSG.show("ip-msg","已经是第一个");
	}
	this.copy(this.ips[this.lastindex<1?0:this.lastindex-1]);
},
copy:function(val,next){
	this.color(val);
	$i("ssh").value=this.ssh+val;
	if(cp(this.ssh+val)){
		if(TAIL.ips.indexOf(val)>-1){
			MSG.show("ip-msg","需要检查线程数,数据库连接数,80端口占用数。",3000);
			this.color(val,"istail");
		}else{
			!next&&MSG.show("ip-msg","已复制。");
		}
	}else{
		MSG.show("ip-msg","复制失败:请在IE或者Google浏览器进行操作");
	}
},
sshcount:function(){
	var tds=$n("td",this._tab);
	$i("ssh-count").innerHTML='（<em>'+tds.length+'</em>/'+this.ips.length+'）';
},
color:function(ip ,istail){
	if(!this._tab)this._tab=$i("ips");
	this.sshcount();
	var tds=$n("td",this._tab);
	for(var i=0;i<tds.length;i++){
		var cls=tds[i].className.replace("current","").trim();
		if(ip==tds[i].innerText){
			cls=(istail?"istail":cls) +" current";
		}
		tds[i].className=cls;
		if(cls.indexOf("istail")>-1)tds[i].title="需要检查线程数,数据库连接数,80端口占用数"
	}
}
};
var TAIL={
ips:["192.168.168.65","192.168.168.66","192.168.168.68","192.168.168.69","192.168.168.80"
	,"192.168.160.54","192.168.160.55","192.168.160.56","192.168.160.57","192.168.168.58"
	,"192.168.168.59","192.168.168.61","192.168.168.62"],
copy:function(){
var cmd="tail -f /home/admin/script/xcjk.txt";
$i("tail").value=cmd;
MSG.show("tail-c",cp(cmd)?"已复制。":"复制失败。");
}
};
var MSG={
	ids:{},
	show:function(id,m,t){
		if(this.ids[id])clearTimeout(this.ids[id]);
		$i(id).innerHTML=m;
		this.ids[id]=setTimeout(function(){$i(id).innerHTML="";},t||1000);
	}
};
var cp=function(val){

	return true;
};

var alert=function(v,o){
	var random=Math.random();
	var div=document.createElement("div");
	div.id="div"+random;
	div.align="center"
	div.style.position="absolute";
	div.style.width="100%";
	div.style.height="100%";
	div.style.top=0;
	div.style.left=0;
	div.style.background="rgba(113, 236, 113, 0.5)";
	var h=document.body.clientHeight/2-100;
	var indiv='<div class="alert-body" style="font-size:32px;color:red;min-height:200px;width:400px;min-width:400px;margin-top:';
	indiv+=(h>0?h:10)+'px;"><p>';
	indiv+=v+'</p><br/><button id="btn'+random+'">确定</button></div>';
	document.body.appendChild(div);
	div.innerHTML=indiv;
	$i("btn"+random).onclick=function(){div.innerHTML="";div.removeNode&&div.removeNode()||div.remove();};
};

(function(w){var ins=document.getElementsByTagName("input");
	for(var i=0;i<ins.length;i++){
		ins[i].onfocus=function(){this.select()};
	}
	w.onkeydown=function(e){
		var code=(e||event).keyCode;
		if(code==38||code==37){//上一个
			CHECK_IP.last();
		}else if(code==40||code==39){//下一个
		CHECK_IP.next();
		}else if(code==16){//shift
		//TAIL.copy();
		}
	}
	var allstep=$c("step-box");
	for(var i=0;i<allstep.length;i++){
		var h4s=$n("h4",allstep[i]);
		if(h4s.length){
			var h4=h4s[0];
			h4.onclick=function(){
				var isopen=this.className.indexOf("h4close")>-1;
				this.className=isopen?"":"h4close";
				this.title=isopen?"关闭":"展开";
				var children=this.parentElement.children;//[0].nodeName
				for(var index=0;index<children.length;index++){
					if(children[index].nodeName!='H4'){
						var display=MAP.get(children[index]);
						if(!display){
							var sty=(children[index].currentStyle||getComputedStyle(children[index]))['display'];
							MAP.put(children[index],sty);
						}
						children[index].style.display=isopen?(display||"block"):"none";
					}
				}
			}
		}
	
	}
})(window);
var ajax =function(url,callback,callerror,type) {
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function () {
    if ( xmlhttp.readyState == 4 ) {
	  if( xmlhttp.status == 200){
		if(callback)callback(xmlhttp);  
	  }else {
		if(callerror)callerror();
	  }
    }
  };
  xmlhttp.open(type||'POST',url); 
  xmlhttp.send();
};

var MAP={
_data:[],
get:function(key){
	for(var i=0;i<this._data.length;i++){
		if(this._data[i].key===key){
			return this._data[i].value;
		}
	}
},
put:function(key,value){
	this._data.push({key:key,value:value});
}
}
</script>

<script src="<%=request.getContextPath()%>/script/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript"> 
var rootPath="<%=request.getContextPath()%>";

function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期
    var d = dd.getDate();
	if(m<10)m='0'+m;
	if(d<10)d='0'+d;
    return y+"-"+m+"-"+d;
}

$(window).ready(function(){
	var tom = GetDateStr(1);
	var dutyCalender = null;
	var src = "rili.jsp?_r="+Math.random();
	$("#riliframe").attr("src",src);
	var _month=""+(new Date().getFullYear())+(new Date().getMonth()+1);
	$.ajax({
		url:rootPath+'/calender/duty',
		type: "post",
        dataType: "json",
        data:{month:_month},
		success: function(data){
			for(var key in data){
				if(key==tom){
					var gg ="<i class='icon icon-volume-up'></i>巡检完毕，<em>大厅</em>签字！明日<em>"+data[key]+"</em>巡检";
				    $("#remind-box").append(gg);
				}
			}
		},
		error: function(error){
			alert("加载巡检日历失败");
		}
	});
	/*
	for(var key in data){
				if(key==getNowFormatDate())
					name = data[key];
				//alert(name)
			}*/
	
	$.waiting=function(isstart){
		if(isstart){
			if($("#alert-frame").length){
				$("#alert-frame").show();
			}else{
				$("body").append("<div id='alert-frame'><div class='range-text'>Waiting</div><div class='range'></div><div class='range range-t3'></div><div class='range range-t5'></div></div>");
				$("#alert-frame").css({position:'fixed',top:0,left:0,width:'100%',height:$(window).height()+'px',background:'rgba(234,247,244,0.65)'});
				var top=document.body.clientHeight/2;
				var left=document.body.clientWidth/2;
				$("#alert-frame .range").css({top:top+'px',left:left+'px'});
				$("#alert-frame .range-text").css({top:top-20+'px',left:left-20+'px'});
			}
		}else{
			$("#alert-frame").remove();
		}
	}
	$.ajaxSetup({
		beforeSend:function(result){
            $.waiting(true);
        },
        complete:function(r,s){
        	$.waiting(false);
            if(r.status==518){
            	alert("timeout!")
            }else if(r.status==500){
            	var index=r.responseText.indexOf("<html");
            	if(index>10){
            		var msg=r.responseText.substr(0,index);
            		alert(msg);
            	}
            }
        }
    });
	window.CACHE_DATA={
	    _server:[],
	    add:function(d){
	    	this._server=d;
	    },
	    getServer:function(ip){
	    	for(var i=0;i<this._server.length;i++){
	    		if(this._server[i].ip==ip){
	    			return this._server[i];
	    		}
	    	}
	    },
	    serverCheck:function(d){
	    	var datas=d||this._server;
	    	var errorcount=0;
			var ingorcount=0;
	    	for(var i=0;i<datas.length;i++){
	    		if(datas[i].error||!datas[i].conn){
	    			errorcount+=1;
	    		}
	    		var td=CHECK_IP.getTd(datas[i].ip);
	    		if(td){
	    			if(datas[i].error||!datas[i].conn){
						var isError=true;
						if(datas[i].ip=="192.168.168.105"||datas[i].ip=="192.168.168.106"){
							var errs=datas[i].error||[];
							if(errs.length==1&&errs.join("").indexOf("media/SLES")>-1){
								isError=false;//中直两台服务器的磁盘使用率有一个达到100%，不影响使用
							}
						}
						if(isError){
							td.style.background="red";
							td.title="服务器状态异常";
						}else{
							ingorcount++;
						}
	    			}
	    			td.onclick=function(){
	    				$("table#ips td").removeClass("current");
	    				$(this).addClass("current");
	    				$i("server-status-content").style.display="block";
	    				var server=CACHE_DATA.getServer(this.innerText);
	    				var keys={top:"admin@/home/admin~~> top",df:"admin@/home/admin~~> df -h",tail:"admin@/home/admin~~> tail -f *.xcjk.txt",error:"警告信息"};
	    				$i("server-status-ip").innerHTML=CHECK_IP.getIpDesc(server.ip)+(server.conn?"":"(connect fail)");
	    				for(var p in keys){
	    					//var arr=server[p]&&server[p].length>0?server[p]:['【'+keys[p]+'】没有数据'];
	    					var arr=server[p]||[];
	    					if(arr.length){
	    						$i("server-status-"+p).style.display="block";
	    						$i("server-status-"+p).innerHTML=keys[p]+"<li>"+arr.join("</li><li>").replace(/\s/g,'&nbsp;')+"</li>";
	    					}else{
	    						$i("server-status-"+p).style.display="none";
	    					}
	    				}
	    			}
	    		}else{
	    			//alert(datas[i].ip+'没有在检查列表中,'+(datas[i].error?"服务器状态异常":""));
	    		}
	    		
	    	}
			errorcount=errorcount-ingorcount;
	    	if(errorcount>0){
	    		//alert(errorcount+"个服务器的状态异常。");
	    	}else{
	    		//alert('服务器状态都正常！');
	    	}
	    }
			
	};
	
	$.ajax({url:rootPath+"/server/getAllServer?_t="+Math.random(),
		dataType:"json",
		contentType : "application/json",
		type:"post",            
		success:function(data){
			if(data&&data.length>0){
				CHECK_IP.ips=data;
			}
		},
		error:function(r,t){
		}
	});
	$.ajax({url:rootPath+'/server/getconfig?_t='+Math.random(),success:function(data){
		$("#showimagepath").text(data.imagePath);
	}});
	
	$(".server-status-close").click(function(){
		$i("server-status-content").style.display="none";
	});
	$("#check-server").click(function(){
		startcheckserver();
	});
	$("#main-btn-start").click(function(){
		startcheckserver();
		CHECK_PRO.start();
	});
	var startcheckserver=function(){
		$.ajax({url:rootPath+"/checkAll/check?_t="+Math.random(),
			dataType:"json",
			contentType : "application/json",
			type:"post",            
			success:function(data){
				if(data&&data.length>0){
					var ips=[];
					for(var i=0;i<data.length;i++){
						ips.push(data[i].ip);
					}
					CHECK_IP.showAll(0,ips);
					CACHE_DATA.add(data);
					CACHE_DATA.serverCheck();
				}else{
					alert("result is empty");
				}
			},
			error:function(r,t){
					alert("system error!"+t);
				window.console&&console.log(r);
			}
		});
	}
	$("#download-log,#main-btn-download").click(function(){
		var $frame=$("#main-download-frame");
		var url=rootPath+'/server/download/logger?_t='+Math.random();
		if($frame.length){
			$frame.attr("src",url);
		}else{
			$("body").append('<iframe id="main-download-frame" src="'+url+'" style="display:none"></iframe>');
		}
	});
	$("#main-btn-download-image").click(function(){
		var $frame=$("#main-download-frame");
		var url=rootPath+'/download/rcxjimage?_t='+Math.random();
		if($frame.length){
			$frame.attr("src",url);
		}else{
			$("body").append('<iframe id="main-download-frame" src="'+url+'" style="display:none"></iframe>');
		}
	});
	
	$("#dxpt-close").click(function(){
		$("#dxpt-query").hide();
	});
	$("#main-btn-dxpt").click(function(){
		$("#dxpt-query").show();
		$("#dxpt-query-body").css({top:"100px",left:($("body").width()-500)/2+"px"});
		$.ajax({url:rootPath+'/dxpt/queryCount?_t='+Math.random(),success:function(data){
			data=data[0]||{};
			for(var p in data){
				$("#dxpt-query td#dxpt-"+p).html(data[p]||0);
			}
		},error:function(e,r){
			alert(r);
		}
		});
	});

	$("#fjgl-close").click(function(){
		$("#fjgl-query").hide();
	});
	$("#main-btn-fjgl").click(function(){
		$("#fjgl-query").show();
		$("#fjgl-query-body").css({top:"100px",left:($("body").width()-500)/2+"px"});
		$.ajax({url:rootPath+'/fjgl/query?_t='+Math.random(),success:function(data){
			data=data||[];
			$("#fjgl-query-body table tr").remove();
			$("#fjgl-query-body table").append("<tr><td>状态</td><td>数量</td></tr>");
			var SCZT={_data:{'00':'初始化',ups:'开始上传',upe:'上传完毕',upf:'上传失败',zips:'压缩开始',zipe:'压缩结束',zipf:'压缩失败',unzips:'解压开始',unzipe:'解压结束',unzipf:'解压失败',not:'文件不存在'}
				,get:function(id){return this._data[id]||""}};
			for(var i=0;i<data.length ;i++){
				if(data[i].cjsjc){
					$("#fjgl-msg").text("附件上传任务的守护线程可能挂掉了，最后上传时间:"+data[i].cjsjc);
				}else{
					$("#fjgl-query-body table").append("<tr><td>"+SCZT.get(data[i].fjsczt)+"</td><td>"+data[i].byzd5+"</td></tr>");
				}
			}
		},error:function(e,r){
			alert(r);
		}
		});
	});
	
	$("#main-btn-ivr").click(function(){
		$.ajax({url:rootPath+"/server/checkivr?_t="+Math.random(),
			dataType:"json",
			contentType : "application/json",
			type:"post",            
			success:function(data){
				if(data&&data.length>0){
					var ips=[];
					for(var i=0;i<data.length;i++){
						ips.push(data[i].ip);
					}
					CHECK_IP.showAll(0,ips);
					CACHE_DATA.add(data);
					CACHE_DATA.serverCheck();
				}else{
					alert("result is empty");
				}
			},
			error:function(r,t){
					alert("system error!"+t);
				window.console&&console.log(r);
			}
		});
	});
	
	
	$("#max-close").click(function(){
		$("#check-config").hide();
	});
	$("#max-edit").click(function(){
		$("#check-config").show();
		
		$("#check-config-body").css({top:"100px",left:($("body").width()-500)/2+"px"});
		
		$("#check-config table i.icon").remove();
		$.ajax({url:rootPath+'/server/getconfig?_t='+Math.random(),success:function(data){
			for(var p in data){
				$("#check-config input[name="+p+"]").val(data[p]);
			}
			$("#showimagepath").text(data.imagePath);
		}});
	});
	$("#max-save").click(function(){
		$("#check-config table i.icon").remove();
		var json={};
		$("#check-config input").each(function(){
			if(this.name){
				if(/^\d+$/.test($(this).val())){
					json[this.name]=$(this).val();
				}else{
					var title="必须是正整数";
					if(this.name=="imagePath"){
						if(!$(this).val()){
							title="存储路径不能为空";
						}else{
							json[this.name]=$(this).val();
							title="";
						}
					}

					if(title&&!$(this).next().length){
						$(this).after('<i class="icon icon-warning-sign" title="'+title+'"></i>');
					}
				}
			}else{
				$(this).after('<i class="icon icon-warning-sign" title="没有name属性"></i>');
			}
		});
		if($("#check-config table i.icon").length){
			return alert('数据不正确');
		}
		$.ajax({url:rootPath+'/server/saveconfig?_t='+Math.random(),data:json,success:function(d){
			alert("success");
			$("#max-edit").click();
		},error:function(){alert("fail");}});
		
	});
	$("#check-config input").change(function(){
		$("i.icon",$(this).parent()).remove();
	});
	$(".server-content-tools i.icon-room-in").click(function(){
		zoomInOut($("#server-status-content ol"),1);
		zoomInOut($("#server-status-content ol li"),1);
	});
   $(".server-content-tools i.icon-room-out").click(function(){
	   zoomInOut($("#server-status-content ol"),-1);
		zoomInOut($("#server-status-content ol li"),-1);
	});
   var zoomInOut=function($el,num){
	   var size=$el.css("font-size").replace("px","")*1+num;
	   $el.css({"font-size":size+"px"});
   };
   $("#ip-edit").click(function(){
		$("#check-ip-config").show();
		$("#check-ip-config-body").css({top:"100px",left:($("body").width()-500)/2+"px"});
		$.ajax({url:rootPath+"/server/getAllServer?_t="+Math.random(),
			dataType:"json",
			contentType : "application/json",
			type:"post",            
			success:function(data){
				if(data&&data.length>0){
					CHECK_IP.ips=data;
					IP_CONFIG.init(data);
				}else{
					alert("result is empty");
				}
			},
			error:function(r,t){
				alert("fail");
			}
		});
	});
   var IP_CONFIG={
		   _max_td:4,
		   addTd:function(ip){
			   var tr=this.getTr();
			   $(tr).append('<td><input type="text" value="'+(ip||'')+'"><i class="icon icon-remove"></i></td>');
			   var $tds=$("td" ,tr);
			   $("i" ,$tds[$tds.length-1]).click(function(){
				   var $ptr=$(this).parent().parent();
				   $(this).parent().remove();
				   if(!$("td",$ptr).length){
					   $($ptr).remove();
				   }
			   });
		   },
		   getTr:function(){
			   var $trs=$("#tab-iplist tr");
			   if(!$trs.length){
				   $("#tab-iplist").append("<tr></tr>");
				   $trs=$("#tab-iplist tr");
			   }
			   for(var i=0;i<$trs.length;i++){
				   if($("td",$trs[i]).length<this._max_td){
					   return $trs[i];
				   }
			   }
			   $("#tab-iplist").append("<tr></tr>");
			   $trs=$("#tab-iplist tr");
			   return $trs[$trs.length-1];
		   },
		   init:function(ips){
			   $("#tab-iplist").html("");
			   for(var i=0;i<ips.length;i++){
				   this.addTd(ips[i]);
			   }
		   }
   };
   $("#ip-add").click(function(){
	   IP_CONFIG.addTd();
	});
   $("#ip-save").click(function(){
	   var list=[];
	   $("#tab-iplist input").each(function(){
		   if(this.value){
			   if(/^\d{1,3}(\.\d{1,3}){3}$/.test(this.value)){
				   list.push(this.value);
				   $(this).removeClass("error-ip");
			   }else{
				   $(this).addClass("error-ip");
			   }
		   }
	   });
	   if($("#tab-iplist input.error-ip").length||!list.length){
	   	 return alert("必须是x.x.x.x格式的IP");
   	   }
	   console.log(list);
	   $.ajax({url:rootPath+"/server/saveServer?_t="+Math.random(),
		   data:{list:list},
		   dataType:"json",
			traditional:true,
			type:"post",            
			success:function(data){
				alert("success");
				if(data&&data.length>0){
					CHECK_IP.ips=data;
					IP_CONFIG.init(data);
				}
			},
			error:function(r,t){
				alert("fail");
			}
		});
	});
   $("#ip-recover").click(function(){
	   $.ajax({url:rootPath+"/server/getOldServer?_t="+Math.random(),
		   dataType:"json",
			type:"post",            
			success:function(data){
				if(data&&data.length>0){
					CHECK_IP.ips=data;
					IP_CONFIG.init(data);
				}else{
					alert("result is empty");
				}
			},
			error:function(r,t){
				alert("fail");
			}
		});
	});
   $("#ip-close").click(function(){
		$("#check-ip-config").hide();
	});
   $(".step-box h4").click();
   $("#step1 h4").click();
});
$("#btn-sys-setting").click(function(){
	$("#sys-setting").show();
});
$("#setting-save").click(function(){
	if(!$("#ischange").prop("checked")){
		SET_BODY_BG.stop();
		if($("#sys-bg").val()){
			$(".step-box").css({border:"solid 1px #ddd"});
			$("body").css({"background":$("#sys-bg").val()});
		}
	}else{
			var time=$("#change-time").val()*999999;
		 	SET_BODY_BG.start(time||3);
		
	}
});
$("#sys-bg").keyup(function(){
	var color=$(this).val();
	if(color){
		if(/^#[0-9abcdefABCDEF]{3,6}$/.test(color)){
			$(this).parent().prev().css({"background":color});
			//$("body").css({"background":$(this).val()});
			$(this).next().hide();
		}else{
			$(this).next().show();
		}
	}
});
$("#setting-close").click(function(){
	$("#sys-setting").hide();
});
var SET_BODY_BG={
	_bgs:["1"],
	_index:0,
	_timeids:[],
	_isstart:false,
	getIndex:function(){
		this._index++;
		if(this._index>=this._bgs.length){
			this._index=0;
		}
		return this._index;
	},
	getUrl:function(){
		return rootPath+"/images/body_bg/bg-"+this._bgs[this.getIndex()]+".jpg";
	},
	setBG:function(){
		$(".step-box").css({border:"none"});
		$("body").css({"background":"url("+this.getUrl()+") no-repeat","background-size":"100% 100%"});
	},
	start:function(t){
		if(this._isstart){
			this.stop();
		}
		this._isstart=true;
		this.setBG();
		var id=setInterval(function(){SET_BODY_BG.setBG();	},(t||3)*999999);
		this._timeids.push(id);
	},
	stop:function(){
		this._isstart=false;
		for(var i=0;i<this._timeids.length;i++){
			clearInterval(this._timeids[i]);
		}
	},
	isstart:function(){return this._isstart;}
};
//SET_BODY_BG.start();
