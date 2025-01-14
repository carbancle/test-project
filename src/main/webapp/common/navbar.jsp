<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Member loginUserInfo = (Member) session.getAttribute("LOGIN_USER_INFO");
%>
<style>
	
</style>
<nav class="navbar navbar-expand-lg navbar-light bg-top">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbar-1">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					 <a class="navbar-brand" href="main.jsp">
				      <img src="/abcMart-app/resources/images/logo-sm.png" alt="" class="d-inline-block align-text-top">
				    </a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a href="/abcMart-app/loginform.jsp" class="nav-link " >로그인</a></li>
				<li class="nav-item"><a href="/abcMart-app/logout.jsp" class="nav-link ">로그아웃</a></li>
				<li class="nav-item"><a href="/abcMart-app/member/member-join.jsp" class="nav-link ">회원가입</a></li>
			</ul>
		</div>
	</div>
</nav>
<nav class="navbar navbar-expand-lg navbar-light bg-middle">
	<div class="container">
		<div class="collapse navbar-collapse row" id="navbar-1">
			<div class="col">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="navbar-brand" href="main.jsp">
					      <img src="/abcMart-app/resources/images/logo.png" alt="" class="d-inline-block align-text-top">
					    </a>
					</li>
				</ul>
			</div>
			<div class="col search-box">
				<form>
	     		 	<input class="form-control" type="search" placeholder="호킨슨 아기 상어 겨울 부츠" aria-label="Search">
	      			<button class="btn btn-outline-success btn-sm" type="submit"></button>
	    		</form>				
			</div>
			<div class="col">
				<ul class="navbar-nav util-list">
					<li class="nav-item">
						<a href="/abcMart-app/mypage/main.jsp?memberNo=<%=loginUserInfo.getNo() %>" class="nav-link util-mypage" ></a>
					</li>
					<li class="nav-item">
						<a href="/abcMart-app/cart.jsp" class="nav-link util-cart" ></a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</nav>
<nav class="navbar navbar-expand-lg navbar-ligth bg-bottom">
	<div class="container">
		<div class="collapse navbar-collapse" id="navbar-1">
			<ul class="navbar-nav">
				<li class="nav-item"><a href="/abcMart-app/mypage-main.jsp" class="nav-link active" >BRAND</a></li>
				<li class="nav-item"><a href="/abcMart-app/cart.jsp" class="nav-link " >SNEAKERS</a></li>
				<li class="nav-item"><a href="/abcMart-app/cart.jsp" class="nav-link ">SPORTS</a></li>
				<li class="nav-item"><a href="/abcMart-app/cart.jsp" class="nav-link ">SANDALS</a></li>
				<li class="nav-item"><a href="/abcMart-app/cart.jsp" class="nav-link ">LOAFERS</a></li>
			</ul>
		</div>
	</div>
</nav>