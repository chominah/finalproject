<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="warp">
	<div>
		<div id="addcomfileform">
			<form action="addExcel" method="post" enctype="multipart/form-data">
				<input type="file" id="m_file" name="m_file">
				
				<input type="submit" value="붙이기"> 
			</form>
				<button id="soondelete">곧지울꺼</button>
		</div>
	</div>
	
	<form action="addcomlist" method="post">
		<div id="addlist">
		
		</div>
		<div>
			기업번호 : <input type="text" id="" name="cplist[0].cpnum"/>
			기업명 : <input type="text" id="" name="cplist[0].cpname"/>
			기업위치 : <input type="text" id="" name="cplist[0].cploc"/>
			기업분류 : <input type="text" id="" name="cplist[0].keyword"/>
			홈페이지 : <input type="text" id="" name="cplist[0].cplink"/>
			<div id="plusaddform">
				
			</div>	
			<div>
				<img id="addbuttonimg" src="resources/img/kjh_addimg.png" alt="입력폼 추가"  width="25" height="25">
			</div>			
			<div>
				<input type="submit" value="추가"/>
			</div>
		</div>
	</form>
	
	<div>
		<div>
			<input type="text" name="query" id="query">
			<button id="searchBtn" title="To saramin">검색</button>
		</div>
		<table>
			<tbody id="saraminbody">
			
			</tbody>		
		</table>
		<div>
			<button id="aftBtn" >더보기</button>
			<div id="tfoottarget">
			
			</div>
		</div>
	</div>
	</div>
<script>
	$(document).ready(function(){
		var total = 100;
		var count = 10;
		var start = 0; 
		let cplistindex = 1;
		$("#searchBtn").click(function(){
			getCpListFromSaramin($("#query").val(),start,count);
		});
		
		
		$("#aftBtn").click(function(){
			if(count < total){
				count += 10;
				getCpListFromSaramin($("#query").val(),start,count);
			}
		});	
		
		$("#soondelete").click(function(){
			console.log("value:::"+$("#m_file").val());
		});
		
		$("#addbuttonimg").click(function(){
			console.log("addbuttonimg.event!!!");
			var htmlsource = "";
			htmlsource += ' 기업번호 : <input type="text" id="" name="cplist['+cplistindex+'].cpnum"/>';
			htmlsource += ' 기업명 : <input type="text" id="" name="cplist['+cplistindex+'].cpname"/>';
			htmlsource += ' 기업위치 : <input type="text" id="" name="cplist['+cplistindex+'].cploc"/>';
			htmlsource += ' 기업분류 : <input type="text" id="" name="cplist['+cplistindex+'].keyword"/>';
			htmlsource += ' 홈페이지 : <input type="text" id="" name="cplist['+cplistindex+'].cplink"/><br/>';
			cplistindex+=1;
			$("#plusaddform").append(htmlsource)
		});
		
		function getCpListFromSaramin(keyword, start, count){
			$.ajax({	
				url : "saramin?query="+keyword+"&start="+start+"&count="+count,
				dataType : "json",
				success : function(data){				
					console.log(data);
					let show ="";
					$(data).each(function(){
						console.log(data);
					});
					total = $(data["job-search"].jobs.total)[0];
					$("#tfoottarget").html("tatal:"+total+" ... current:"+count);
					$(data["job-search"].jobs.job).each(function(index, item){
						show += "<tr><td>"+(index+1)+"</td><td> <button class='formadd'>입력에 추가하기</button></td><tr/>";
						show += "<tr><td>번호::</td><td id='num"+index+"' value='"+item.id+"'>"+item.id+"</td><tr/>";
						show += "<tr><td>이름::</td><td id='name"+index+"' value='"+item.company.name.content+"'>"+item.company.name.content+"</td><tr/>";
						show += "<tr><td>위치::</td><td id='loc"+index+"' value="+item.position.location.content+">"+item.position.location.content+"</td><tr/>";
						show += "<tr><td>분류::</td><td id='word"+index+"' value="+item.keyword+">"+item.keyword+"</td><tr/>";
						show += "<tr><td>홈페이지::</td><td id='link"+index+"' value="+item.url+"><a href='"+item.url+"'>"+item.url+"</a></td></tr>";
					});
					$("#saraminbody").html(show);
					const arr =document.querySelectorAll(".formadd");
					arr.forEach(function(item, index) {
						console.log(item + ":::" + index);
						selectgroup(item, index);
					});
					function selectgroup(item, index) {
						item.addEventListener("click", function(evt) {
							
							let addnum= ($("#num"+(index))).text();
							let addname= ($("#name"+(index))).text();
							let addloc= $("#loc"+index).text();
							let addword= $("#word"+index).text();
							let addlink= $("#link"+index).text();							
							
							let htmlsource2 = "";
							htmlsource2 += ' 기업번호 : <input type="text" id="" name="cplist['+cplistindex+'].cpnum" value='+addnum+' />';
							htmlsource2 += ' 기업명 : <input type="text" id="" name="cplist['+cplistindex+'].cpname" value='+addname+' /><br/>';
							htmlsource2 += ' 기업위치 : <input type="text" id="" name="cplist['+cplistindex+'].cploc" value='+addloc+' />';
							htmlsource2 += ' 기업분류 : <input type="text" id="" name="cplist['+cplistindex+'].keyword" value='+addword+' />';
							htmlsource2 += ' 홈페이지 : <input type="text" id="" name="cplist['+cplistindex+'].cplink" value='+addlink+' /><br/>';
							cplistindex+=1;
							$("#addlist").append(htmlsource2);
						});
					}
				}
			});
		}		
	});
</script>
