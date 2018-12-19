<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrap">
	<table>
		<thead>
			<th>No</th>
			<th>기업명</th>
			<th>관계</th>
			<th>주력업종</th>
			<th>담당자</th>
			<th>연락처</th>
			<th>이메일</th>
			<th>주소</th>
			<th>협약서 유무</th>	
		</thead>
			
		<tbody id="tbody_Target">
			<% int i = 1; %>
			<c:forEach var="mycp_list" items="${mycp_list}">
				<tr>
					<td style='width:5%'><%=i%></td>
					<td style='width:15%' id="mycp_list_name<%=i%>">${mycp_list.cpname}</td>
					<td style='width:8%'>${mycp_list.cprel}</td>
					<td style='width:10%'>${mycp_list.cpmajor}</td>
					<td style='width:7%'>${mycp_list.cpceo}</td>
					<td style='width:12%'>${mycp_list.cpphone}</td>
					<td style='width:15%'>${mycp_list.ceomail}</td>
					<td style='width:23%'>${mycp_list.cploc}</td>
					<td style='width:5%'>${mycp_list.cparrears}</td>	
				</tr>
				<tr>
					<td colspan="9">
						<table id="saramin_target<%=i++%>" style='width:100%' class="saramin_target">
							
						</table>
					</td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>

</div>

<script>
 	$(document).ready(function(){
		const arr =document.querySelectorAll("#tbody_Target > tr");
		arr.forEach(function(item, index){
			getsaramin_data($("#mycp_list_name"+(index+1)).text(),(index+1));
		});
		 function getsaramin_data(keyword,table_index){
			$.ajax({	
				url : "saramin?query="+keyword+"&start=0&count=5",
				dataType : "json",
				success : function(data){				
					let show ="";
					var total = 0;
					total = $(data["job-search"].jobs.total)[0];
					if(total>0){
						show += "<tr style='width:100%'><td style='width:20%'>total...</td><td style='width:80%'>"+total+"</td></tr>";
					}
					$(data["job-search"].jobs.job).each(function(index, item){
						show += "<tr style='width:100%'><td style='width:20%'>이름</td><td style='width:80%'>"+item.company.name.content+"</td></tr>";
						show += "<tr style='width:100%'><td style='width:20%'>분류</td><td style='width:80%'>"+item.keyword+"</td></tr>";
						show += "<tr style='width:100%'><td style='width:20%'>링크</td><td style='width:80%'><a href='"+item.url+"'>공고 페이지 이동</a></td></tr>";
					});
					$("#saramin_target"+table_index).html(show);
				}
			});
		} 
	});   
</script>