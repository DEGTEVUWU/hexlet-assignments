@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="ru">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>List with users!</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    <table>
        <caption>Users List</caption>
        <thead>
        <tr>ID</tr>
        <tr>FirstName</tr>
        <tr>LastName</tr>
        <tr>Email</tr>
        </thead>
        @for(var user : page.getUsers())
        <tbody>
        <tr>
            <div>
                <td>${user.getId()}</td>
                <td><a href="/users/${user.getId()}"> ${user.getFirstName()}</a></td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>

            </div>
        @endfor
        </tr>
        </tbody>
    </table>

@endif
</body>
</html>