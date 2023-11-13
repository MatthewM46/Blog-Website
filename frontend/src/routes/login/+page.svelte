<script>
	export let form;
</script>

{#if form != null && form.loggedOut === true}
	<div class="rounded bg-emerald-50 ring-1 ring-emerald-300 p-3 mb-4 max-w-md mx-auto">
		You have been logged out.
	</div>
{:else if form != null && form.badLogin === true}
	<div class="rounded bg-red-50 ring-1 ring-red-300 p-3 mb-4 max-w-md mx-auto">
		There was a problem with your credentials. Try again?
	</div>
{/if}

<form class="max-w-md mx-auto" method="post" action="?/login">
	<label class="w-full">Username<br />
		<input class="w-full" type="text" name="username" />
	</label>

	<label class="w-full">Password<br />
		<input class="w-full" type="password" name="password" />
	</label>

	<input class="mt-2 mr-0 p-3 rounded hover:bg-slate-600 text-slate-50 bg-slate-500" type="submit" value="Login" />
</form>

<div class="max-w-md mx-auto mt-3">
	No account? No problem! <a href="/register" class="underline text-slate-500 hover:text-slate-700">Register here.</a>
</div>