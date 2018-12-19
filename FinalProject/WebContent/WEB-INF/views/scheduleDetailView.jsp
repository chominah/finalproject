<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrap">
	<table id="schedule_Target">
		<thead>
			<tr>
				<th>시간</th>
				<th>1강의실</th>
				<th>2강의실</th>
				<th>3강의실</th>
				<th>4강의실</th>
				<th>5강의실</th>
				<th>6강의실</th>
				<th>7강의실</th>
				<th>8강의실</th>
				<th>9강의실</th>			
				<th>기타</th>
			</tr>
		</thead>
		<tbody>
		<% for(int  i = 0; i<24 ; i++){ %>
			<tr>
				<td><%=i%>:00</td>
				<% for(int j = 1 ; j < 11 ; j++){ %>
				<td id="content<%=i%>_<%=j%>">id:content<%=i %>_<%=j %></td>
				<% } %>
			</tr>
		<% }%>
		</tbody>
	</table>
</div>

<script>
	$(document).ready(function(){
		console.log("day->:::${day}");
		$.ajax({
			url:"data/getScheduleData_oneday?day=${day}",
			success : function(data){
				$(data).each(function(index, items){	
					console.log("time::"+(((items.shdate).split(" ")[1]).split(":")[0]).split("0")[1]);
					$("#content"+(((items.shdate).split(" ")[1]).split(":")[0]).split("0")[1]+"_"+(items.shloc).split(" ")[1]).css("background-color","red");
					console.log("강의실::"+(items.shloc).split(" ")[1]);	
					
				
					
				});
			}
			
		});
		
	});

</script>