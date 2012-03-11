<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
function tagEdit() {
	$('#tags').load("tags-edit.action?comicId=" + <s:property value="comicId" />);
}
</script>

<s:iterator value="tags">
	<s:property />,
</s:iterator>
<br />

<button onclick="tagEdit()">タグ編集</button>