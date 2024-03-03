@import exercise.dto.users.UsersPage
@import exercise.model.User

@param UsersPage page


@template.layout.page(
    content  = @`
<body>
<h1>${"Это лист со всеми доступными пользователями!"}</h1>
    @for(var user : page.getUsers())
        <tr>
            <td>${user.getId()}</td>
            <td>
                <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                <br>
            </td>
        </tr>
        @endfor
<%--    <table>--%>
<%--        <caption>Users List</caption>--%>
<%--        <thead>--%>
<%--        <tr>ID</tr>--%>
<%--        <tr>FirstName</tr>--%>
<%--        <tr>LastName</tr>--%>
<%--        <tr>Email</tr>--%>
<%--        </thead>--%>
<%--        @for(var user : page.getUsers())--%>
<%--        <tbody>--%>
<%--        <tr>--%>
<%--            <div>--%>
<%--                <td>${user.getId()}</td>--%>
<%--                <td><a href="/users/${user.getId()}"> ${user.getFirstName()}</a></td>--%>
<%--                <td>${user.getLastName()}</td>--%>
<%--                <td>${user.getEmail()}</td>--%>
<%--            </div>--%>
<%--            @endfor--%>
<%--        </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
</body>

`
    ,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)
