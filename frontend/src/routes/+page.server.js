import { posts } from '$lib/data.js';

export function load() {
	posts.forEach((post) => {
		post.summary = post.text.split('\n')[0];
	});

	return {
		posts: posts
	};
}