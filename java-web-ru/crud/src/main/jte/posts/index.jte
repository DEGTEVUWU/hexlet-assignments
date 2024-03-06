@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page


@template.layout.page(
content  = @`
    <body>
    <nav aria-label="Все посты">
        !{int startIndex;}
        !{int pageNumber;}
        @if(page.getPageNumber() == null)
            !{startIndex = 0;}
            !{pageNumber = 1;}
        @else
            !{startIndex = (Integer.parseInt(page.getPageNumber()) - 1) * 5;}
            !{pageNumber = Integer.parseInt(page.getPageNumber());}
        @endif
        <table>
            <tr>
                <td>
                    @for(int i = startIndex; i < page.getPostsList().size() && i < startIndex + 5; i++)
                        <li>
                            <a href="/posts/${page.getPostsList().get(i).getId()}">${page.getPostsList().get(i).getName()}</a>
                        </li>
                    @endfor
                </td>
            </tr>
        </table>

        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/posts?page=${Math.max(pageNumber - 1, 1)}">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/posts?page=${Math.min(pageNumber + 1, page.getPostsList().size())}">Next</a></li>
        </ul>
    </nav>
    </body>
`
)
<%--    <nav aria-label="Все посты">--%>
<%--        !{int postIndex;}--%>
<%--        !{int pageNumber;}--%>

<%--        @if(page.getPadeNumber() == null)--%>
<%--            !{postIndex = 0;}--%>
<%--            !{pageNumber = 1;}--%>
<%--        @else--%>
<%--        !{postIndex = Integer.parseInt(page.getPadeNumber() - 1) * 5;}--%>
<%--        !{pageNumber = Integer.parseInt(page.getPadeNumber());}--%>
<%--    @endif--%>

<%--            @for(var i = postIndex; i < page.getPostsList().size() && i < pageNumber * 5; i++)--%>
<%--            <div>--%>
<%--            <h2><a href="${NamedRoutes.postPath(page.getPostsList().get(i).getId())}">--%>
<%--            ${page.getPostsList().get(i).getName()} </a></h2>--%>
<%--            </div>--%>
<%--            @endfor--%>

<%--                <ul class="pagination">--%>
<%--                    <li class="page-item"><a class="page-link" href="/posts?page=${Math.max(pageNumber - 1, 1)}">--%>
<%--                            Назад</a></li>--%>
<%--                    <li class="page=item"><a class="page-link"--%>
<%--                                             href="/posts?page=${Math.min(pageNumber + 1, page.getPostsList().size())}">--%>
<%--                                            Далее</a></li>--%>
<%--                </ul>--%>

<%--    </nav>--%>
