<script>
    async function response () {
        const response = await fetch('http://localhost:8080/book')
        if(response.status !== 200){
            throw new Error()
        }
        return await response.json()
    }
    const booksPromise = response()


</script>

{#await booksPromise then listOfBooks}
    {#each listOfBooks as book}
        <p>{book.name}</p>
        <p>{book.isbnId}</p>
        <p>{book.isRead}</p>
    {:else}
        <p>Sorry, you have no books to display :( </p>
    {/each}
{:catch error}
    <p style="color: red">Sorry, that's sad, something went wrong</p>
{/await}



