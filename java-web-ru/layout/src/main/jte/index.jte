@import gg.jte.Content
@param Content content

@template.layout.page(
content  = @`
    <h1>Заголовок моего локал-сайта!</h1>
    <h2>Подзаголовок! Привет-списыватель! Если ты читаешь - пожалуйста, пользуйся</h2>
    <h4>Тут ты увидишь:</h4>
    <ul>
        <li>Главную страницу</li>
        <li>Список всех пользователей</li>
        <li>Инфу про каждого юзера</li>
    </ul>
`
    ,
footer = @`
    <div class="footer">
        <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
    </div>
`
)
