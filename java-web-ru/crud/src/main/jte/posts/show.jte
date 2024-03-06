@import exercise.dto.posts.PostPage
@import exercise.model.Post
@param PostPage page

@template.layout.page(
content  = @`
    <div>
        ${page.getPost().getId()} ${page.getPost().getName()} ${page.getPost().getBody()}
    </div>
`
)