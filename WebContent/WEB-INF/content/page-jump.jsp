<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<SCRIPT language="JavaScript">
<!--
// 数値のみを入力可能にする
function numOnly() {
  m = String.fromCharCode(event.keyCode);
  if("0123456789\b\r".indexOf(m, 0) < 0) return false;
  return true;
}
//-->
</SCRIPT>

数値を入力してください：<input id="jumpNum"type="text"  style="ime-mode: disabled;"  onkeyDown="return numOnly()"><button id="jumpButton">ジャンプ</button><br>

<script language="JavaScript">
$("#jumpButton").bind("click", function(){
	pageCount = $("#jumpNum").attr('value') -1;//showメソッド内部でインクリメントされるため、１を引く
	show();

	$('#tags').load("tool-packe.action");
});
</script>