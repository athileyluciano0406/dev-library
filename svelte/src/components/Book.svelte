<script>
    import {onMount} from "svelte";

    let books;

    onMount(async () => {
        async function response() {
            const response = await fetch('http://localhost:8080/book')
            if (response.status !== 200) {
                return null
            }
            return await response.json()
        }

        books = await response()
    })

    let title = ''
    let isbn = ''

    async function doPost() {
        const res = await fetch('http://localhost:8080/book', {
            method: 'POST',
            body: JSON.stringify({
                title,
                isbn
            }),
            headers: {"Content-Type": "application/json", Accept: "*/*"}
        })

        const newBook = await res.json()
        books.push(newBook)
        books = books
    }
</script>

<div class="add-new-book">
    <h1>Would you like to add a new book to your list?</h1>
    <input bind:value={title}/>
    <input bind:value={isbn}/>
    <button type="button" on:click={doPost}>
        Post book.
    </button>
</div>

<div>
    {#if books}
        {#each books as book}
            <div class="book-element">
                <div>
                    <h1>Title</h1>
                    <div>{book.title}</div>
                    <h2>ISBN</h2>
                    <div>{book.isbnId}</div>
                    <h2>Have you read this book?</h2>
                    <div>
                        {#if book.isRead === true}
                            <p>Yes</p>
                        {:else } <p>No</p>
                        {/if}
                    </div>
                </div>
            </div>
            {:else}
            <p>Sorry, you have no books to display :( </p>
        {/each}
    {/if}
</div>

<style>
    .book-element {
        margin: 20px;
        padding: 20px;
        background-color: #d0b5ac;
        display: inline-block;
    }

    .add-new-book {
        padding: 20px;
    }
</style>
