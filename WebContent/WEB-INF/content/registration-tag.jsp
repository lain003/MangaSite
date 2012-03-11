<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>


読み込み中
<script type="text/javascript">
$('#tags').load("tool-packe.action?comicId=" + <s:property value="comicId" />);
</script>