<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <h1>E-Mail </h1>

 
 
      <form action="sendmail" method="post" enctype="multipart/form-data">
      <table>
      <tr>
      <td>Email To : </td>
  
      <td><input type="email" name="mailTo" value="${ceomail }" required="required"></td>
     
      </tr>
      <tr>
      <td>Subject : </td>
      <td><input type="text" name="subject"></td>
      </tr>
      <tr>
      <td>Message : </td>&nbsp;&nbsp;&nbsp;
      <td><textarea cols="50" rows="10" name="text"></textarea></td>
      </tr>
      <tr>
      <td><input type="file" name="file"></td>
      </tr>
      <tr>
      <td>
      <input type="submit" value="Send E-mail">
      </td>
      </tr>
      
      </table>
      </form>

<script>
   $(function(){
      
   });
</script>