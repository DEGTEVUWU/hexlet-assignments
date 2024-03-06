@import exercise.util.NamedRoutes
@import gg.jte.Content
@param Content content

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                  <a href="${NamedRoutes.postsPath()}">Все посты</a>
            </main>
        </div>
    `
)
