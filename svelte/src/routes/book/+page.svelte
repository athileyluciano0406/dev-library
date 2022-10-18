<script>
    async function response () {
        const response = await fetch('http://localhost:8080/book')
        if(response.status !== 200){
            throw new Error()
        }
        return await response.json()
    }
    const booksPromise = response()

    let title = ''
    let isbn = ''
    let result = null

    async function doPost () {
        const res = await fetch('http://localhost:8080/book', {
            method: 'POST',
            body: JSON.stringify({
                title,
                isbn
            }),
            headers: {"Content-Type": "application/json", Accept: "*/*"}
        })

        const json = await res.json()
        result = JSON.stringify(json)
    }
</script>

<input bind:value={title} />
<input bind:value={isbn} />
<button type="button" on:click={doPost}>
    Post book.
</button>
<p>
    Result:
</p>
<pre>
{result}
</pre>

<div>
    {#await booksPromise then listOfBooks}
        <div>
            {#each listOfBooks as book}
                <div class="book">
                    <h1>Title</h1>
                    <div class="book-title">{book.title}</div>
                    <h2>ISBN</h2>
                    <div class="book-isbn">{book.isbnId}</div>
                    <h2>Have you read this book?</h2>
                    <div class="book-is-read">
                        {#if book.isRead === true}
                            <p>Yes</p>
                            {:else } <p>No</p>
                        {/if}
                    </div>
                </div>
            {:else}
                <p>Sorry, you have no books to display :( </p>
            {/each}
        </div>
    {:catch error}
        <p style="color: red">Sorry, that's sad, something went wrong :( </p>
    {/await}
</div>

<style>
    .book {
        display: flex;
        margin: 20px;
        background-color: #d0b5ac;
    }
    .book-title {
        margin: 20px;
    }
    .book-isbn {
        margin: 20px;
    }
    .book-is-read {
        margin: 20px;
    }
</style>



