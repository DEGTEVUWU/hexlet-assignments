@import exercise.model.Post
@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@import javax.naming.Name

@param PostsPage page


@template.layout.page(
content  = @`
    <body>
    <h1>${"Это лист со всеми доступными постами!"}</h1>
    <br>
    <a href="">На страницу с постами!</a>

    @if(page.getPostList().isEmpty())
        <p>Пока не добавлено ни одного поста</p>
    @else
        @for(var post : page.getPostList())
            <div>
                <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    @endif

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link"
                                     href="${NamedRoutes.postsPath()}?page=${page.getPreviousPage()}">Previous</a></li>
            <li class="page-item"><a class="page-link"
                                     href="${NamedRoutes.postsPath()}?page=${page.getNextPage()}">Next</a></li>
        </ul>
    </nav>
    </body>
`
)