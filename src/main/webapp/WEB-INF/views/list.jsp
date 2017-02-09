<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script type="text/javascript">
function move_page(page){
	var frm = document.pageFrom;
	frm.page.value = page;
	frm.submit();
}
</script>

	
<div class="tablebox board">
	<form name="pageFrom" method="get">
		<input type="text" style="display: none;">
		<input type="hidden" name="page">
		<select name="searchType">
			<option value="title">제목</option>
			<option value="contents">내용</option>
		</select>
		<input type="text" name="searchText">
		<input type="button" value="검색" onclick="move_page(1)">
	</form>
	
	<div class="board_body">
		<table>
			<colgroup>
				<col width="*">
				<col width="100px">
				<col width="100px">
			</colgroup>
			<thead class="mNot">
				<tr>
					<th scope="col">제목</th>
					<th scope="col">등록일</th>
					<th scope="col">조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${testList}" varStatus="status">
					<tr>
						<td><a href="info.do?test_no=${vo.test_no }">${vo.test_title }</a></td>
						<td>
							<fmt:parseDate var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss.SSS" value="${vo.reg_date }"/>
							<fmt:formatDate var="formatDate" pattern="yyyy-MM-dd HH:mm:ss" value="${dateFmt }"/>
							${formatDate }
						</td>
						<td>${vo.test_cnt }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="pager">
		${paging.getPagingHtml() }
	</div>
</div>	
