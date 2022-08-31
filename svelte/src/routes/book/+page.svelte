<script>
    async function response () {
        const response = await fetch('http://localhost:8080/book')
        return await response.json()
    }
    const booksPromise = response()

</script>
{#await booksPromise then listOfBooks}
    {#each listOfBooks as book}
        <p>{book.name}</p>
        <p>{book.isbnId}</p>
        <p>{book.isRead}</p>
    {/each}

{/await}



