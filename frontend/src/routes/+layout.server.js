import { jwtDecode } from "jwt-decode";

export function load({ cookies }) {

	let token = cookies.get('token');
	let loggedIn = false;
	let username = "";

	if (token) {
		const decoded = jwtDecode(token);
		username = decoded.sub;
		loggedIn = true;
	}

	return {
		loggedIn,
		username
	}
}