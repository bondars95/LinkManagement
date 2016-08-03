<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring MVC - CM</title>
<style> /* put it here because met problems connecting css in eclipse */
     body{ margin-top:20px; margin-bottom:20px;}
   h1 {text-align: center; color: #CB4528;}
table a:link {
	color: #6495ED;
	font-weight: bold;
	text-decoration:none;
}
table a:visited {
	color: #999999;
	font-weight:bold;
	text-decoration:none;
}
/* table a:active,
table a:hover {
	color: #bd5a35;
	text-decoration:underline;
} */
table {
	 margin: auto; 
           border-collapse: collapse;
	font-family:Arial, Helvetica, sans-serif;
	color:#666;
	font-size:14px;
	text-shadow: 1px 1px 0px #fff;
	background:#eaebec;
	border:#ccc 1px solid;

	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;

	-moz-box-shadow: 0 1px 2px #d1d1d1;
	-webkit-box-shadow: 0 1px 2px #d1d1d1;
	box-shadow: 0 1px 2px #d1d1d1;
}
table th {
	padding:21px 25px 22px 25px;
	border-top:1px solid #fafafa;
	border-bottom:1px solid #e0e0e0;

	background: #ededed;
	background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
	background: -moz-linear-gradient(top,  #ededed,  #ebebeb);
}
table th:first-child {
	text-align: left;
	padding-left:20px;
}
table tr:first-child th:first-child {
	-moz-border-radius-topleft:3px;
	-webkit-border-top-left-radius:3px;
	border-top-left-radius:3px;
}
table tr:first-child th:last-child {
	-moz-border-radius-topright:3px;
	-webkit-border-top-right-radius:3px;
	border-top-right-radius:3px;
}
table tr {
	text-align: center;
	padding-left:10px;
}
table td:first-child {
	text-align: left;
	padding-left:20px;
	border-left: 0;
}
table td {
	padding:10px;
	border-top: 1px solid #ffffff;
	border-bottom:1px solid #e0e0e0;
	border-left: 1px solid #e0e0e0;

	background: #fafafa;
	background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
	background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
}
table tr.even td {
	background: #f6f6f6;
	background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
	background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
}
table tr:last-child td {
	border-bottom:0;
}
table tr:last-child td:first-child {
	-moz-border-radius-bottomleft:3px;
	-webkit-border-bottom-left-radius:3px;
	border-bottom-left-radius:3px;
}
table tr:last-child td:last-child {
	-moz-border-radius-bottomright:3px;
	-webkit-border-bottom-right-radius:3px;
	border-bottom-right-radius:3px;
}
/* table tr:hover td {
	background: #f2f2f2;
	background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
	background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);
} */
 
 input[type="text"] {
   border: 1px solid #cccccc; 
   border-radius: 3px;
   -webkit-border-radius: 3px; 
   -moz-border-radius: 3px;
   -khtml-border-radius: 3px; 
   background: #ffffff !important; 
   outline: none; 
   height: 24px; 
   width: 180px;
   color: #cccccc; 
   font-size: 14px; 
   font-family: Tahoma; 
}

input[type="text"]:focus {
  color: #000000;
  border: 1px solid #000000
}

input[type=submit] {
    padding:5px 15px; 
    background:#ccc; 
    border:1 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
}

button {
    padding:5px 15px; 
    background:#ccc; 
    border:1 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
}

select {

   border-radius: 3px;
   -webkit-border-radius: 3px; 
   -moz-border-radius: 3px;
   -khtml-border-radius: 3px; 
   background: #ffffff !important; 
   outline: none; 
   color: black; 
   font-size: 14px; 
   font-family: Tahoma; 
}
</style>


</head>
<body>
    <div style="border: #C1C1C1 solid 1px; background-color:#FCFCFC;">
        <tiles:insertAttribute name="header" />
        <div style="height:25px;background-color:#CFD5D4  ;">
            <tiles:insertAttribute name="menu" /> 
        </div>
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" /> 
    </div>
</body>
</html>
