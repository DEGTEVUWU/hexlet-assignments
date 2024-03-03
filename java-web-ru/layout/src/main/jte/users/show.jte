@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
userList = @`
    <div>
        ${page.getUser().getFirstName()} ${page.getUser().getLastName()}
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
    )