<%@ page language="java" contentType="text/css; charset=UTF-8"
	pageEncoding="UTF-8"%>
body {
	/* background-color: #2d3436; */
	font-family: 'Open Sans', sans-serif;
	color: black;
	overflow-x: hidden;
}

header {
	background-color: #2d3436;
	text-align: center;
	color: white;
}

header>p>i {
	color: orange;
}

.list {
	float: left;
	list-style-type: none;
	padding-right: 3rem;
}

.ft-lst {
	float: left;
	list-style-type: none;
	padding-right: 2rem;
}

.fab, .fab2 {
	color: white;
}

.navbar-brand {
	font-weight: bold;
	margin: 0;
	padding: 0;
}

.sub-title {
	color: black;
}

.sub-title>h5 {
	font-weight: bold;
	color: #e74c3c;
}

.dropdown:hover>.dropdown-menu {
	display: block;
}

.footer-form {
	width: 100%;
	height: 35px;
	background-color: white;
}

.footer-form>input {
	width: 80%;
}

.btn-outline-secondary {
	color: white;
	background-color: #e74c3c;
}

.hr {
	width: 70px;
	height: 5px;
	background-color: #e74c3c;
	margin: auto;
}

.text-line {
	text-align: center;
	border-bottom: 1px solid #8395a7;
	line-height: 0.1em;
}

.text-line span {
	background-color: white;
	padding: 0 10px;
	color: #8395a7;
}

.login:hover {
	background-color: #e74c3c;
	cursor: pointer;
}

.btn-login {
	background-color: #e74c3c;
}

.navbar {
	background-color: #fff;
}

.nav-item {
	padding-right: 12px;
}

.fa-magnifying-glass {
	color: black;
	background-color: #f8f8f8;
}

#button-addon2 {
	background-color: #f8f8f8;
	padding: 0px 20px 0px 20px;
	border: none;
}

.search-form {
	border: 1px solid #ddd;
	margin: 0px;
	padding: 0px;
}

.article {
	background-color: #fff;
	height: 85vh;
	overflow-y: scroll;
}

.article::-webkit-scrollbar-thumb {
	height: 6px !important;
	background: grey !important;
	border-radius: 10px !important;
	visibility: hidden !important;
}

.article:hover::-webkit-scrollbar-thumb {
	visibility: visible !important;
}

::-webkit-scrollbar {
	width: 10px !important;
}

::-webkit-scrollbar-thumb {
	background-color: grey !important;
	border-radius: 5px !important;
}

.aside {
	background-color: #f9f9f9;
}

.test-btn {
	display: none;
}

.list-group-item {
	padding: 5px 5px;
	margin: 10px 10px;
	border-bottom-left-radius: 25% 100% !important;
	border-bottom-right-radius: 25% 100% !important;
	border-top-left-radius: 25% 100% !important;
	border-top-right-radius: 25% 100% !important;
	background-color: #f2f2f2;
}

.list-group-item:hover {
	background-color: #d4d4d4;
	cursor: pointer;
}

.card {
	padding: 5px;
}

.video-title {
	height: 40px;
	text-align: center;
	overflow: hidden;
}

.btn-like {
	margin-right: 5px;
}
.btn-like:hover{
	background-color: #2980b9;
}
.btn-share:hover{
	background-color: #2ecc71;
}
.btn-share {
	margin-left: 5px;
}

@media only screen and (max-width: 600px) {
	.article {
		display: none;
	}
}
.like {
	color: white;
}

.like:hover {
	color: white;
	text-decoration: none;
}

a {
	color: black !important;
}

a:hover {
	text-decoration: none;
}
.comment-name{
font-weight: bold;	
}