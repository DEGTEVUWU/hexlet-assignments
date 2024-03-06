
@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content  = @`
    <div>
        ${page.getPost().getId()} ${page.getPost().getName()} ${page.getPost().getBody()}
    </div>

    <div>
        <a href="${NamedRoutes.rootPath()}">Вернуться на главную!</a>

    </div>
`
)