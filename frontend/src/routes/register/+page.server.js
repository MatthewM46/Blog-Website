import { env } from '$env/dynamic/private';

export const actions = {
	register: async ({ cookies, request }) => {
		const formData = await request.formData();

		const registerRequestBody = {
			username: formData.get('username'),
			firstname: formData.get('firstname'),
			lastname: formData.get('lastname'),
			email: formData.get('email'),
			password: formData.get('password')
		};

		console.log(registerRequestBody);

		const registerResponse = await fetch(
			`${ env.ACCOUNT_SERVICE_URL }/api/v1/auth/register`,
			{
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(registerRequestBody)
			}
		);

		console.log(registerResponse);
	}
}
