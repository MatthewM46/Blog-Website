export function load({ cookies }) {
	let loggedIn = cookies.get('loggedIn');

	if (loggedIn === undefined || loggedIn === '') {
		loggedIn = false;
	} else {
		loggedIn = true;
	}

	return {
		loggedIn
	}
}