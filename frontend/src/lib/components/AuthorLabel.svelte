<script>
	export let authorName;
	export let authorId;
	export let prefix = "by ";
	export let postfix = "";
</script>

<span class="text-slate-600 dark:text-slate-400">{prefix}<a href="/user/{authorId}"><span class="underline-offset-2 underline hover:text-slate-800 dark:hover:text-slate-600">{authorName}</span></a>{postfix}</span>
