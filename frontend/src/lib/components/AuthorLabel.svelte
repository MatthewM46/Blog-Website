<script>
	export let authorName;
	export let authorId;
	export let prefix = "by ";
	export let postfix = "";
</script>

<span class="text-slate-600">{prefix}<a href="/user/{authorId}"><span class="underline-offset-2 underline hover:text-slate-800">{authorName}</span></a>{postfix}</span>
