# finalproject
## 박주형
### 폴더 설정
<pre>
1. Mapper : FeedBackMapper.xml 추가
2. dao : AdminDao.java 추가
3. Controller
 1) FeedBackController.java 추가
 2) FeedBackRestController.java 추가
4. WebContent/resources/upload 폴더 생성(이력서&포트폴리오 파일을 올려서 저장해둘 폴더)
5. WeB-INF/spring/sub : sub-pjh.xml 추가
6. views
 1) Edu_Company_wirte.jsp
 2) Edu_Company.jsp
 3) Edu_Resume.jsp
 </pre>
 ### 내용
  1. 학생관리_이력서&포트폴리오 피드백
 <pre>
  - 이력서&포트폴리오 피드백 요청이 들어온 학생들의 정보 View(학생이름, 이메일, 폰 번호, 강좌이름, 기수)
  - 학생의 정보를 누르게 되면 해당 학생에 대한 이력서&포트폴리오 리스트 View(이력서&포트폴리오 파일명, 입력일, 파일 다운로드, 파일 업로드)
  </pre>
 2. 학생관리_관심기업 피드백
 <pre>
  - 관심기업에 대한 피드백 요청이 들어온 학생들의 정보 View(피드백 요청 날짜, 기업이름, 강좌이름, 기수, 학생이름)
  - 학생의 정보를 누르게 되면 오른쪽 피드백 요청내용 화면에 요청사항에 대한 내용이 간략하게 보여진다.
  - 피드백 요청 내용에 대한 상세보기를 클릭하게 되면 요청사항에 대한 내용이 뜨게 되고 그 내용에 대해 
    글을 재 업로드 하는 형식으로 피드백을 할 수 있게 만듦
 </pre>
 ### tiles 설정
<pre>
 1. WEB-INF/tiles : tiles-definitions.xml
 2. WEB-INF/template/default
  1) footer.jsp
  2) header.jsp
  3) menu.jsp
  4) template.jsp
</pre>
