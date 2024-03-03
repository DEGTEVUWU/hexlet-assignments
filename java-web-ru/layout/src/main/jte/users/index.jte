@import exercise.dto.users.UsersPage
@import exercise.model.User

@param UsersPage page


@template.layout.page(
    userList = @`
<body>
<h1>${"Это лист со всеми доступными пользователями!"}</h1>
    @for(var user : page.getUsers())
    <div>${user.getFirstName()} ${user.getLastName()}</div>
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
)
