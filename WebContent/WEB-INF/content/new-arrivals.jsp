<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC
 "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<title>Zero</title>
</head>

<body>

<form method="GET" action="comic-list.action">
<input name="searchWord" type="text" maxlength=10><input type="submit" value="検索">
</form>

<td>
<ul>
<s:iterator value="comicDataList">
	<li>
	<s:property value="title" /><br />
	<s:iterator value="tags" >
		<s:property/>,
	</s:iterator><br />
	<a id = <s:property value="comicId" /> href="comic-viewer.action">
		<script type="text/javascript">
		var aTag = document.getElementById(<s:property value="comicId" />);
		aTag.href += "?comicId=" + <s:property value="comicId" />;
		aTag.href.innerHTML = aTag.herf;

		var s = "image/comic/" + <s:property value="comicId" /> + "/1.jpg";
		document.open();
		document.write("<img src=" + s + " alt='noimage' width=100 height=100 />");
		document.close();
		</script>
	</a>
	</li>
</s:iterator>
</ul>
</td>


<script type="text/javascript">
	$(document).ready(function(){
		var nextPageLink = "comic-list.action?page=1";
		$("#nextPageLink").attr("href", nextPageLink);
	 });
</script>

<a id="nextPageLink">
next page
</a>
</body>
</html>