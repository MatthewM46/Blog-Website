<script>
	export let data;
	import AuthorLabel from "$lib/components/AuthorLabel.svelte";
</script>

<h1 class="text-3xl">{data.post.title}</h1>

<h3 class="text-xl"><AuthorLabel authorId={data.post.author.id} authorName={data.post.author.username}/></h3>

<div>
	{#each data.post.text.split('\n') as line}
		<p class="pb-2">{line}</p>
	{/each}
</div>

<hr />

<h3 class="text-2xl">Comments</h3>

{#if data.comments.length === 0}
	<div class="m-0 text-center text-slate-700 italic">No comments yet.</div>
{/if}

{#each data.comments as comment}
	<div class="mb-3">
		<AuthorLabel prefix="" postfix=" said" authorId={comment.author.id} authorName={comment.author.username}/>
		<p>{comment.text}</p>
	</div>
{/each}
