

function addTitleClickAction(){
	$("a.click-title").click(function(){
		var data=PAGE_CACHE.getData( $(this).attr("name") );
		if(data){
			for(var p in data){
			  if(p){
				if(p.endsWith("time")){
					var d=new Date(data[p]);
					var date=d.getFullYear()+"-"+d.getMonth()+"-"+d.getDate();
					var time=d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
					$("#detail-"+p).html(date+" "+time);
				}else{
					$("#detail-"+p).html(data[p]);
				}
			  }
			}
			$("#display-frame").show();
		}else{
			console.log("没有数据"+$(this).attr("name"))
		}
	});
}

var CACHE_CONDITION={
		_data:{},
		_history:[],
		ischange:function(data){
			for(var p in this._data){
				if(this._data[p]!=data[p]){
					return true;
				}
			}
			for(var p in data){
				if(p!="page" && data[p]!=this._data[p]){
					return true;
				}
			}
			return false;
		},
		cache:function(data){
			this._data={};
			for(var p in data){
				if(p!="page")
				this._data[p]=data[p];
			}
			if(data.condition){
				if(this._history.indexOf(data.condition)<0){
					if(this._history.length>10){
						this._history.shift();
					}
					this._history.push(data.condition);
				}
				
			}
		},
		clearHistory:function(){
			this._history=[];
			showHistory();
		},
		init:function(){this._data={};}
};
function searchQuestion(page){
	var data=$("#keyword").val()?{condition:$("#keyword").val()}:{};
	var ins=$(".supper-condition input");
	for(var i=0;i<ins.length;i++){
		var obj=$(ins[i]);
		if(obj.val()){
			var name=obj.attr("name");
			data[name]=obj.val()+((name&&name.endsWith("time"))?" 00:00:00":"");
		}
	}
	data.page=page||0;
	if(data.page!=0 && CACHE_CONDITION.ischange(data)){
		data.page=0;
	}
	CACHE_CONDITION.cache(data);
	var waiting='<div align="center" id="search-waiting"><i class="icon-spinner wait-icon"></i>&nbsp;正在查询中....</div>';
	if(data.page==0){
		PAGE_CACHE.init();
		$("#search-result-frame").html(waiting);
	}else{
		$("#div-more-data").remove();
		$("#search-result-frame").append(waiting);
	}
	$.ajax({
		url:"/help/solution/query",
		data:data,
		type:"POST",
		 dataType:"json",
		success:function(t){
			showResult(t);
			PAGE_CACHE.cache(t||[]);
			addTitleClickAction();
		},
		error:function(e,r){
		PAGE_CACHE.init();
		$("#search-result-frame").html("<p class='empty-result'>系统发生异常["+r+"]</p>");
		}
	});
	showHistory();
}
function showHistory(){
	var his=CACHE_CONDITION._history;
	$("#history-info").html("");
	for(var h=his.length-1;h>-1;h--){
		$("#history-info").append('<p>'+his[h]+'</p>');
	}
	$("#history-info p").click(function(){
		$("#keyword").val($(this).text());
		searchQuestion(0);
	});
}
var COLOR=["#a7f1f1","#c8cece","#77ca95","#abeeef","#b8efab","rgba(251, 161, 108, 0.31)","#fbd273","#f1e0f9","#76b7ae"];
function showResult(datas){
	var $el=$("#search-result-frame");
	$("#search-waiting").remove();
	if(datas.length>0){
		var len=PAGE_CACHE.data.length;
		var col_idx=-1;
		for(var i=0;i<datas.length;i++){
			index= len+i;
			var str='<div class="result-info info-idx-'+i+'"><p class="info-title"><i class="icon-leaf leaf-icon">'
			+'</i><a class="click-title" name='+index+' id="result-'+datas[i].mailid+'">'+datas[i].title+'</a></p><p class="info-answercontent">'
			+sub1(datas[i].answercontent)+'</p><a class="info-type">'+datas[i].deanmailcategoryname
			+'</a><a title="浏览量" class="info-views"><i class="icon-eye-open views-icon"></i>'+random(19999,200)
			+'</a><a title="赞一个" class="info-zhan"><i class="icon-thumbs-up zhan-icon"></i>'+random(19999,200)
			+'</a></div>';
			$el.append(str);
			 col_idx=getColor(col_idx);
			$(".info-idx-"+i).css("background",COLOR[col_idx]);
		}
		if(datas.length>=15){//每次只查询15条数据
			PAGE_CACHE.page=PAGE_CACHE.page+1;
			$el.append('<div id="div-more-data" align="center"><p class="more-data">查看更多数据...</p><p class="more-data-icon"><i class="icon-double-angle-down"</i></p></div>');
			$("#div-more-data p").click(function(){searchQuestion(PAGE_CACHE.page);});
		}
	}else{
		if(PAGE_CACHE.page==0){
			$el.html("<p class='empty-result'>未找到相关话题。</p>");
		}else{
			$el.append("<p >没有更多相关话题。</p>");
		}
	}
}
function getColor(v){
	while(true){
		var index=random(COLOR.length-1);
		if(v!=index){
			return index;
		}
	}
}

function random(max,min){
return parseInt(Math.random()*(max+(min||0)-1)-(min||0));
}
function sub1(str){
	var ret="&nbsp;&nbsp;&nbsp;&nbsp;";
	if(str && str.length>100){
		return ret+str.substr(0,100);
	}else{
		return ret+str;
	}
}