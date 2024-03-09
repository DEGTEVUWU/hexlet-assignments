@import exercise.util.NamedRoutes
@import gg.jte.Content
@param Content content  

@template.layout.page(
    content = @`
        <h2>Welcome to Hexlet</h2>
    <ul>
    <li><a href="${NamedRoutes.buildPostPath()}">Создайте пост!</a> </li>
    </ul>
`
)


