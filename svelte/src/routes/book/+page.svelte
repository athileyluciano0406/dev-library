<script>
    async function response () {
        const response = await fetch('http://localhost:8080/book')
        return await response.json()
    }

    response().then(
        function(data) { data.forEach(book => (console.log(book.name))) }
    );
</script>


