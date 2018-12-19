<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<style>
.menubar li ul {
display:none;  

}

.menubar li:hover ul {
display:block;   
</style>
<script>
function logout(){
	alert('로그아웃 되었습니다.');
}
</script>
	        <div class="menubar">
<ul>
	<li><a href="resume">이력서</a></li>
	<li><a href="company">포트</a></li>
	<li><a href="jobsearch">80%이상</a></li>
	<li><a href="logout" onclick="logout()">로그아웃</a></li>
	
	
                <ul>
                   
                   <li><a href="classlist">전체강좌</a>
                      <ul>
                        <li><a href="clogin">내 강좌</a></li>
                        
                        </ul>
                      
                   </li>
            
                </ul>
             </div>
	
  
</ul>