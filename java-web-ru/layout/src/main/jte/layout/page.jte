@import gg.jte.Content
@param Content mainPage = null
@param Content userList = null
@param Content lonelyUser = null

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
<div class="header">
    <a href="/">Главная страница</a>
    <a href="/users" title="All users, list">Все пользователи</a>
</div>

<main>

    ${mainPage}
    ${userList}
    ${lonelyUser}

</main>
<div class="footer">
    <a href="https://github.com/DEGTEVUWU">Дёгтев Иван - профиль на GitHub</a>
</div>
</body>
</html>