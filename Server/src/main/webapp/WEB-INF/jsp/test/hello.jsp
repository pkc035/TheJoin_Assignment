<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board List</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style type="text/css">
a{
 text-decoration: auto;
}
</style>
</head>
<body>
    <br/>
    <h1 class="text-center">게시판</h1>
    <br/>
    <br/>
    <div class="container">
        <table class="table table-hover table-striped text-center" style="border:1px solid;">
            <colgroup>
                <col width="10%" />
                <col width="50%" />
                <col width="20%" />
                <col width="20%" />
            </colgroup>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일자</th>
                </tr>
            </thead>
 
            <tbody>
            <c:forEach items="${resultList}" var="result" varStatus="status">    
                <tr>
                    <td>${paginationInfo.totalRecordCount - (paginationInfo.pageSize * (paginationInfo.currentPageNo -1)) - status.count + 1}</td>
                    <td><a href="${result.boardId}/detailTest.do">${result.title}</a></td>
                    <td>로그인 미구현</td>
                    <td>${result.createdAt}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <hr/>
        <div>
            <ul id="page" class="pagination justify-content-center">
	            <c:if test="${paginationInfo.currentPageNo > 1 }">
			    <li style="margin-right:5px;" class="text-secondary">
	        		<a href="mainTest.do?pageIndex=${paginationInfo.currentPageNo-1 }">◀</a>
	    		</li>
			    </c:if>
			    <c:forEach begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" var="pageNum">
			    <li style="margin-right:5px;" class="text-secondary">
			        <a href="mainTest.do?pageIndex=${pageNum }">${pageNum }</a>
			    </li>
			    </c:forEach>
			    <c:if test="${paginationInfo.currentPageNo < paginationInfo.lastPageNoOnPageList }">
			    <li style="margin-right:5px;" class="text-secondary">
			        <a href="mainTest.do?pageIndex=${paginationInfo.currentPageNo+1 }">▶</a>
			    </li>
			    </c:if>
            </ul>
        </div>
        <a class="btn btn-outline-info" style="float:right" href="writeTest.do">글쓰기</a>
    </div>
    <br>
</body>
</html>
