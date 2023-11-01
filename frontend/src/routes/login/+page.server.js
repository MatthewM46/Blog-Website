import {error, redirect} from '@sveltejs/kit';

export const actions = {
	login: async ({ cookies, request }) => {
		const loggedIn = cookies.get('loggedIn');

		// if loggedIn cookie does not exist, set it
		if (loggedIn === undefined || loggedIn === '') {
			cookies.set('loggedIn', 'true', { path: '/'});
			throw redirect(303, '/');
		} else {
			throw error(420, 'Enhance your calm');
		}
	},
	logout: async ({ cookies, request }) => {
		const loggedIn = cookies.get('loggedIn');

		// if loggedIn cookie exists, delete it
		if (loggedIn === 'true') {
			cookies.set('loggedIn', '', { path: '/' });
		} else {
			throw error(500, 'Enhance your calm');
		}

		return {
			loggedOut: true
		};
	}
}