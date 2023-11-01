import { error } from '@sveltejs/kit';
import { posts, comments } from '$lib/data.js';

export function load({ params }) {

	// find the post with the given id
	const post = posts.find((post) => post.id === parseInt(params.id));

	if (post === undefined) {
		throw error(404, `Post not found`);
	}

	const coms = comments.filter( comment => comment.postid === post.id );

	return {
		post,
		comments: coms
	};
}