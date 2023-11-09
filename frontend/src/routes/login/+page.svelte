<script>
	export let form;
</script>

{#if form != null && form.loggedOut === true}
	<div class="rounded bg-emerald-50 ring-1 ring-emerald-300 p-3 mb-4 max-w-md mx-auto">
		You have been logged out.
	</div>
{/if}

<form class="max-w-md mx-auto" method="post" action="?/login">
	<label class="w-full">Email<br />
		<input class="w-full" type="text" />
	</label>

	<label class="w-full">Password<br />
		<input class="w-full" type="password" />
	</label>

	<input class="mt-2 mr-0 p-3 rounded hover:bg-slate-600 text-slate-50 bg-slate-500" type="submit" value="Login" />
</form>

<div class="max-w-md mx-auto mt-3">
	or <a href="/register">register</a>
</div>