@import exercise.dto.users.UsersPage
@import exercise.model.User

@param UsersPage page


@template.layout.page(
content  = @`
    <body>
    <h1>${"Это лист со всеми доступными юзерами!"}</h1>
    <br>
    <h4>${"Вы можете найти юзера по имени"}</h4>
    <form action="/users" method="get">
        <label>
            <input type="search" name="term" value="${page.getTerm()}">
        </label>
        <input type="submit" value="Искать">
    </form>
    @for(var user : page.getUsers())
        <tr>
            <td>${user.getId()}</td>
            <td>
                <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()} ${user.getEmail()}</a>
                <br>
            </td>
        </tr>
    @endfor
    </body>

`
,
footer = @`
    <div class="footer">
        <a>Спасибо, что посетили мой сайт и страницу со всеми юзерами! Жду снова!</a>
        <br>
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)