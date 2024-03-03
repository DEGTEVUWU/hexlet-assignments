@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content  = @`
    <div>
        ${page.getUser().getFirstName()} ${page.getUser().getLastName()} ${page.getUser().getEmail()}
    </div>
<%--    <table>--%>
<%--        <caption>ABOUT USER</caption>--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>Id</th>--%>
<%--            <th>FirstName</th>--%>
<%--            <th>LastName</th>--%>
<%--            <th>Email</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <tr>--%>
<%--            <td>${page.getUser().getId()}</td>--%>
<%--            <td>${page.getUser().getFirstName()}</td>--%>
<%--            <td>${page.getUser().getLastName()}</td>--%>
<%--            <td>${page.getUser().getEmail()}</td>--%>
<%--        </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
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