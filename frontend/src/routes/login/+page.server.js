import { env } from '$env/dynamic/private';
import {error, redirect} from '@sveltejs/kit';

export const actions = {
	login: async ({ cookies, request }) => {

		const formData = await request.formData();

		const authenticateRequestBody = {
			username: formData.get('username'),
			password: formData.get('password')
		};

		const authenticateResponse = await fetch(
			`${ env.ACCOUNT_SERVICE_URL }/api/v1/auth/authenticate`,
			{
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(authenticateRequestBody)
			}
		);

		if (authenticateResponse.ok) {
			const json = await authenticateResponse.json();
			cookies.set('token', json.token, { path: '/' });
			throw redirect(303, '/');
		} else {
			return {
				loggedOut: false,
				badLogin: true
			}
		}

	},
	logout: async ({ cookies, request }) => {
		cookies.delete('token');

		return {
			loggedOut: true,
			badLogin: false
		};
	}
}