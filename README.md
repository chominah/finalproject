# finalproject
## 박주형
> 폴더 설정
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
 > 내용
 <pre>
 1. 학생관리_이력서&포트폴리오 피드백
  - 이력서&포트폴리오 피드백 요청이 들어온 학생들의 정보 View(학생이름, 이메일, 폰 번호, 강좌이름, 기수)
  - 학생의 정보를 누르게 되면 해당 학생에 대한 이력서&포트폴리오 리스트 View(이력서&포트폴리오 파일명, 입력일, 파일 다운로드, 파일 업로드)
 2. 학생관리_관심기업 피드백
  - 관심기업에 대한 피드백 요청이 들어온 학생들의 정보 View(피드백 요청 날짜, 기업이름, 강좌이름, 기수, 학생이름)
  - 학생의 정보를 누르게 되면 오른쪽 피드백 요청내용 화면에 요청사항에 대한 내용이 간략하게 보여진다.
  - 피드백 요청 내용에 대한 상세보기를 클릭하게 되면 요청사항에 대한 내용이 뜨게 되고 그 내용에 대해 
    글을 재 업로드 하는 형식으로 피드백을 할 수 있게 만듦
 </pre>
 > tiles 설정
<pre>
 1. WEB-INF/tiles : tiles-definitions.xml
 2. WEB-INF/template/default
  1) footer.jsp
  2) header.jsp
  3) menu.jsp
  4) template.jsp
  
</pre>
 * **menu.jsp** 부분에 링크 넣어주시면 됩니다~
 >> 예시
 ```html
 <ul>
  <li><a href="resume">이력서&포트폴리오 관리</a></li>
  <li><a href="company">관심기업 관리</a></li>
 </ul>
```
>> 결과화면
<pre><div><ul><li><a href="resume">이력서&포트폴리오 관리</a></li>
<li><a href="company">관심기업 관리</a></li></ul></div></pre>

## 김윤재
<pre>
1. Mappler : jobinfo.xml
2. dao : jobSearchDao.java
3. controller : DefaultController.java
                EmailController.java
                EmplymentController.java

4. src/myinfo.properties : 이메일 계정/비밀번호

5. views : list.jsp
           list2.jsp
           kTotalList.jsp
           cTotalList.jsp
           jobinfo.jsp
           email.jsp
           index.jsp

 > 내용
1) index 초기화면엔 두 가지 주제로 기업을 조회할 수 있다. 첫번째로 나의 관심 키워드를
    항목에서 선택하여 기업리스트를 검색하여 볼 수 있고, 두번째로는 개설된 강좌를 선택하여
    관련 기업을 검색할 수 있다

2) 검색하여 나온 기업리스트는 처음엔 간략한 리스트로 나오게 되는데 "더보기" 버튼을 클릭하면
   전체 리스트를 볼 수 있다.

3) 전체리스트에서 기업마다 상세보기 버튼이 있고 버튼을 누르면 기업정보를 볼 수 있는 페이지로 이동

4) 기업정보페이지에서는 그 기업에 해당 링크를 걸어 홈페이지로 이동이 가능하고 대표자에게 이메일을
   전송할 수 있는 기능이 있고 파일을 첨부할 수 있는 기능도 추가할 예정이다
