<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div>
    <form method="post">
        <input type="text" name="name" placeholder="Input name">
        <input type="text" name="email" placeholder="Input email">
        <button type="submit">Add</button>

    </form>
</div>
<div>
    Список пользователей
</div>
{{#users}}
<div>
    <b>{{id}}</b>
    <b>{{name}}</b>
    <b>{{email}}</b>


</div>
</body>
</html>
