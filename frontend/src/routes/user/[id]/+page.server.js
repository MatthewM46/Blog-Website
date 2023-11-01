import { authors } from '$lib/data.js';
import { error } from "@sveltejs/kit";

export function load({ params }) {

	// find the username associated with the author with the given id
	const author = authors.find(author => author.id === parseInt(params.id));

	if (!author) {
		throw error(404, 'Author not found');
	}

	return {
		authorName: author.username
	};
}