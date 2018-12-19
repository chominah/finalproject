<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="wrap">


 <div class="container kt-pb-60" id="lecturesContainer" class="hide">
	        <div class="row" >
	           <div class="col-md-12 ">
					<div class="">
						<table class="table table-hover table-striped  lecture-table bd-top-3px">
				            <colgroup>
								<col width="10%">
								<col width="20%">
								<col width="10%">
								<col width="30%">
								<col width="30%">
							</colgroup>
				            <thead>
				                <tr>
				                    <th scope="col" class="text-center">�����ȣ</th>
				                    <th scope="col" class="text-center">����̸�</th>
				                    <th scope="col" class="text-center">�����ġ</th>
				                    <th scope="col" class="text-center">�з�</th>
				                    <th scope="col" class="text-center">Ȩ������</th>
				                </tr>
				            </thead>
				            <tbody>
					        	<c:forEach var="e" items="${list}">
									<tr>
										<td>${e.cpnum}</td>
										<td>${e.cpname}</td>
										<td>${e.cploc}</td>
										<td>${e.keyword}</td>
										<td>${e.cplink}</td>
									</tr>
								</c:forEach>
				        		<tr ng-hide="items.length">
					        		<td colspan="5" class="text-center">����� �����ϴ�.</td>
				        		</tr>
				            </tbody>
				        </table>
				    </div>
			    </div>
	        </div>




	<%-- <table>
		<thead>
		</thead>
		<tbody>
			<c:forEach var="e" items="${list}">
				<tr>
					<td>${e.cpnum}</td>
					<td>${e.cpname}</td>
					<td>${e.cploc}</td>
					<td>${e.keyword}</td>
					<td>${e.cplink}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table> --%>
	<a href="exceldown"><button>Down</button></a>
	<a href="addcomform">Goaddform</a>
</div>
</div>

