<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrap">
	<table id="schedule_Target">
		<thead>
			<tr>
				<th>�ð�</th>
				<th>1���ǽ�</th>
				<th>2���ǽ�</th>
				<th>3���ǽ�</th>
				<th>4���ǽ�</th>
				<th>5���ǽ�</th>
				<th>6���ǽ�</th>
				<th>7���ǽ�</th>
				<th>8���ǽ�</th>
				<th>9���ǽ�</th>			
				<th>��Ÿ</th>
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
					console.log("���ǽ�::"+(items.shloc).split(" ")[1]);	
					
				
					
				});
			}
			
		});
		
	});

</script>