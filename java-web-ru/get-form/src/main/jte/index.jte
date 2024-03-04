@import gg.jte.Content
@param Content content

@template.layout.page(
    content = @`
        <a href="/users">Пользователи</a>
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
