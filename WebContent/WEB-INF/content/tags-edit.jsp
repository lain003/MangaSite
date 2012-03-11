<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>

<script type="text/javascript">
	function addTag(){
		$('#tags').load("registration-tag.action?addTag=" + document.getElementById("addTag").value +"&"+"comicId=" + <s:property value="comicId" />);
	}
</script>

<input id="addTag" type="text" maxlength=10><button onclick="addTag()">追加</button>
<s:iterator value="tags" status="st">
	<s:property /> <button id="<s:property value="#st.index"/>" >削除</button><br/>

	<script type="text/javascript">
	$("#" + <s:property value="#st.index"/>).bind("click", function(){
		$('#' + <s:property value="#st.index"/>).load("delete-tag.action?deleteTagNumber=" + <s:property value="#st.index"/> + "&" + "comicId=" + <s:property value="comicId" />);
	});
	</script>
</s:iterator>
