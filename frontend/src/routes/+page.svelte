
<script>
	export let data;
	import AuthorLabel from "$lib/components/AuthorLabel.svelte";
</script>

{#each data.posts as post}
	<a href="post/{post.id}">
		<div class="bg-slate-100 dark:bg-slate-800 mb-3 rounded-md p-3">
			<h2 class="text-xl font-medium">{post.title}</h2>
			<AuthorLabel authorName={post.author.username} authorId={post.author.id} />
			<p>{post.summary}</p>
		</div>
	</a>
{/each}
