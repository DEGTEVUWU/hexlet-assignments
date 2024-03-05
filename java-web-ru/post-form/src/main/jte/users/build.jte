@import exercise.dto.users.UsersPage

@param UsersPage page


@template.layout.page(
content  = @`
    <form action="/users" method="post">
        <div>
            <label>
                Имя пользователя
                <input type="text" name="name" />
            </label>
        </div>
        <div>
            <label>
                Фамилия пользователя
                <input type="text" name="name" />
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="email" required name="email" />
            </label>
        </div>
        <div>
            <label>
                Пароль
                <input type="password" required name="password" />
            </label>
        </div>
        <div>
            <label>
                Подтверждение пароля
                <input type="password" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
)