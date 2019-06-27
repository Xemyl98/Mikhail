<%--
  Created by IntelliJ IDEA.
  User: Michail
  Date: 14.04.2019
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>$Title$</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            var url = "http://localhost:8082/web_war_exploded/MyServlet";
            $("#calculate").click(function () {
                $.ajax({
                    method: "POST",
                    url: url,
                    data: {
                        "firstOperand": $("#firstOperand").val(),
                        "secondOperand": $("#secondOperand").val(),
                        "operation": $("#operation").val()
                    },
                    success: function (json) {
                        if (json.error === 0)
                            $("#result").val(json.result);
                        else
                            $("#result").val("Incorrect Data Input");
                    },
                    error: function () {
                        $("#result").val("Connection error");
                    }
                });
            });
        });
    </script>
</head>
<body>
<h1>Calculator</h1>
<br/>

<span><b>Formula: </b></span>
<br/>

<input type="text" id="firstOperand" value="8.78"/>
<br/>

<select id="operation">
    <option>+</option>
    <option>-</option>
    <option>*</option>
    <option>/</option>
</select>
<br/>
<input type="text" id="secondOperand" value="4.15"/>
<br/>
<input type="button" id="calculate" value="Calculate">

<br/>
<br/>
<span><b>Result: </b></span>
<br/>
<input type="text" id="result"/>

</body>
</html>
