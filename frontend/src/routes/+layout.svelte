<script>
	import '../app.css';
	export let data;
</script>

<div class="max-w-prose mx-auto px-1">
	<div class="flex my-3 justify-between items-center">
		<h1 class="text-4xl font-semibold"><a href="/">MAJAM</a></h1>
		{#if data.loggedIn === false}
			<a href="/login"><button class="p-2 px-4 rounded-xl bg-slate-500 hover:bg-slate-600 text-slate-50">Login</button></a>
		{:else}
			<form method="POST" action="/login?/logout">
				Welcome back, {data.username}. <input class="underline text-slate-600 hover:text-slate-800 dark:text-slate-400 dark:hover:text-slate-600" value="Logout" type="submit" name="logout" />
			</form>
		{/if}
	</div>
	<slot />
</div>