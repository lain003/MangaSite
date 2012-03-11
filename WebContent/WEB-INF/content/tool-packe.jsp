<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
function pageJumpClick() {
	$('#tags').load("page-jump.action");
}
function tagViewClick(){
	$('#tags').load("tags-view.action?comicId=" + <s:property value="comicId" />);
}
</script>
<button id="tagView" onclick="tagViewClick()">タグの表示</button><br>
<button id="pageJump" onclick="pageJumpClick()">ページジャンプ</button><br>