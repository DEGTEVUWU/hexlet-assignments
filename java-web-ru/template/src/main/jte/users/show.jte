@import exercise.dto.users.UserPage
@param UserPage page

<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Information about only unic user!</title>
</head>
<body>
<div>

    <h1 link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    >${page.getDescription()}</h1>
    <br>
    <table>
        <caption>ABOUT USER</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${page.getUser().getId()}</td>
            <td>${page.getUser().getFirstName()}</td>
            <td>${page.getUser().getLastName()}</td>
            <td>${page.getUser().getEmail()}</td>
        </tr>
        </tbody>
    </table>
<%--    <h2><a href="/users/${page.getUser().getId()}">${page.getUser().getFirstName()}</a></h2>--%>
</div>

</body>
</html>