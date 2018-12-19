<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrap">
	<div>
		<h2>조건 넣을 공간</h2>
	</div>

	<div>
		<table>
			<tr>	
				<td><button id="preMonth"><img src="resources/img/kjh_prev.png" style="width:20px;height:20px"></button></td>
				<td style="margin:auto; width:100%"><p id="year_target"></p></td>
				<td><button id="aftMonth"><img src="resources/img/kjh_next.png" style="width:20px;height:20px"></button></td>
			</tr>
		</table>
	
		<table id="cal">
			<thead>
				<tr>
					<th>일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토</th>
				</tr>
			</thead>
			<tbody id="schedual_body">
				
			</tbody>
			<tfoot>
			
			</tfoot>		
		</table>	
	</div>
</div>

<script>
$(document).ready(function(){
	var date = new Date();
	var date_Present_Year = date.getFullYear();
	var date_Present_Month = date.getMonth();
	var date_Present_Day = date.getDate();
	
	create_cal(date,date_Present_Year,date_Present_Month,date_Present_Day);	
	
	$("#preMonth").click(function(){
		date_Present_Month -= 1;
		if(date_Present_Month === -1){
			date_Present_Year -= 1;
			date_Present_Month = 11;
		}
		create_cal(date,date_Present_Year,date_Present_Month,date_Present_Day);	
	});
	$("#aftMonth").click(function(){
		date_Present_Month += 1;
		if(date_Present_Month === 12){
			date_Present_Year += 1;
			date_Present_Month = 0;
		}
		create_cal(date,date_Present_Year,date_Present_Month,date_Present_Day);	
	});
});

function create_cal(date,year,month,day){	
	var start_Day = new Date(year,month,1);
	var end_Day = new Date(year,month+1,0);
	var after_Day = new Date(year,month+1,1);
	var text = "<tr colspan='2'>";
	var week = start_Day.getDay();
	var Before_Day = new Date(year,month,0-week);	
	
	$("#schedual_body").html("");
	
	 $.ajax({
		url : "data/getScheduleData_month?day="+year+"-"+(month+1),
		success : function(data){
			var temp_DayORTime;
			var temp_YearMonthDay;
			var html_text = "";
			var temp_day = 1;
			var count_day = 0;
			$(data).each(function(index, items){	
				temp_DayORTime = items.shdate.split(" ");
				temp_YearMonthDay = temp_DayORTime[0].split("-");
				
				if(temp_day !== temp_YearMonthDay[2]){
					temp_day = temp_YearMonthDay[2];
					count_day = 0;
				}
				if(count_day<2){
					count_day++;
					html_text += "<div>";
					html_text += temp_DayORTime[1];				
					html_text += "</div>";
					
					html_text += "<div>";
					html_text += "["+items.shloc+"]";				
					html_text += "</div>";
					html_text += "<div>";
					html_text += items.shname;				
					html_text += "</div>";
					html_text += "<hr>";
				
				}else if(count_day === 2){
					html_text+= "<div style='text-align:right;'>";
					html_text+= ".......";
					html_text+= "</div>";
				}else{
					
				}
				$("#day_"+temp_YearMonthDay[2]).append(html_text);
				html_text="";
				
			});
		}
		
	}); 
	
	
	for(let before_d = 1; before_d <= week ; before_d++ ){
		text+="<td class='false_days'><h6>"+(Before_Day.getDate()+before_d)+"</h6></td>";
	}
	
	for(let d = 1; d <= end_Day.getDate(); d++){
		if( week%7 === 0 ){
			text+="<tr colspan='2'>";
		} 
		text+="<div><td class='true_days'>";
		text+="<table><tr><td class='div_schedule_day'>"+d+"</td></tr><tr class='div_schedule_content'><td id='day_"+d+"'></td></tr></table>";
		text+="</td></div>";
		if( week%7 === 6 ){
			text+="</tr>";
		}
		week++;
	} 
	
	for(let after_d = 0; after_d < 7-(week%7); after_d++ ){
		text+="<td class='false_days'><h6>"+(after_Day.getDate()+after_d)+"</h6></td>";
	}
	text+="</tr>"; 	
	
	
	$("#year_target").html(year+"년"+(month+1)+"월");
	$("#schedual_body").append(text);
	
	
	const arr =document.querySelectorAll(".true_days");
	arr.forEach(function(item, index) {
		selectDay(item, index);
	});
	
	function selectDay(item, index) {
		item.addEventListener("click", function(evt) {
			location = "getScheduleDetail?day="+year+"-"+(month+1)+"-"+(index+1);
			
		});
	}	
	
	
	
}
</script>



