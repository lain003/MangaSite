<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>comicViewer</title>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
	function getData(url) {
		  var req = new XMLHttpRequest();
		  req.open('GET',url,false);
		  req.overrideMimeType('text/plain; charset=x-user-defined');
		  req.send(null);
		  if (req.status != 200) return '';
		  return req.responseText;
	}

	function base64encode(str) {
		var base64EncodeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		var base64DecodeChars = new Array(
		    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
		    52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
		    -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
		    15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
		    -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
		    41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1);
	    var out, i, len;
	    var c1, c2, c3;

	    len = str.length;
	    i = 0;
	    out = "";
	    while(i < len) {
		c1 = str.charCodeAt(i++) & 0xff;
		if(i == len)
		{
		    out += base64EncodeChars.charAt(c1 >> 2);
		    out += base64EncodeChars.charAt((c1 & 0x3) << 4);
		    out += "==";
		    break;
		}
		c2 = str.charCodeAt(i++);
		if(i == len)
		{
		    out += base64EncodeChars.charAt(c1 >> 2);
		    out += base64EncodeChars.charAt(((c1 & 0x3)<< 4) | ((c2 & 0xF0) >> 4));
		    out += base64EncodeChars.charAt((c2 & 0xF) << 2);
		    out += "=";
		    break;
		}
		c3 = str.charCodeAt(i++);
		out += base64EncodeChars.charAt(c1 >> 2);
		out += base64EncodeChars.charAt(((c1 & 0x3)<< 4) | ((c2 & 0xF0) >> 4));
		out += base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >>6));
		out += base64EncodeChars.charAt(c3 & 0x3F);
	    }
	    return out;
	}

	$(window).load(function(){
		$('#tags').load('tool-packe.action' + '?comicId=' + <s:property value="comicId" />);
	});

    var pageCount = 1;
    function show() {
    	pageCount++;
    	var imageSrc = $("#ComicsImage").attr("src");
    	imageSrc = "image/comic/" + <s:property value="comicId" /> + "/" + pageCount + ".jpg";

    	var base64ImgData = sessionStorage.getItem(imageSrc);
    	if(base64ImgData == null){
    		base64ImgData = base64encode(getData(imageSrc));
    		sessionStorage.setItem(imageSrc,base64ImgData);
    	}

    	$("#ComicsImage").attr("src", 'data:image/gif;base64,'+ base64ImgData);
    };
</script>

</head>

<body>
<a onclick="show()">
<script type="text/javascript">
		var s = "image/comic/" + <s:property value="comicId" /> + "/1.jpg";
		document.open();
		document.write("<img id='ComicsImage' src=" + s + " alt='noimage'>");
		document.close();
</script>
</a><br>

<div id="tags">
</div>

</body>
</html>