Frontend Service
================

The frontend service is a web application that provides a user interface for
the application. It is written in Javascript using the SvelteKit framework.

## Incremental Construction

### Sprint 1

- [x] Create a basic foundational project using SvelteKit
- [x] Create a basic UI with a header and content area
- [x] Add some static content to be rendered
- [x] Create a login page that stores state with a cookie
- [x] Add comments section to each post
- [ ] Add sponsored posts

### Sprint 2

- [ ] Add functional login
- [ ] Add functional post creation
- [ ] Add functional commenting
- [ ] Add comment reporting

## Design Pattern

An example of a design pattern implemented by the SvelteKit framework is the
Observer pattern. The Observer pattern is used to update the UI when the
application state changes. Application state is stored in the store module
or in individual components. When the application state changes, the UI is
updated automatically.

This is accomplished using SvelteKit's reactive variables. A reactive variable
is a variable that can be used in a component's markup. When the value of a
reactive variable changes, the component is re-rendered. When SvelteKit stores
are used instead, the store's subscribe method is used to register a callback
function that is called when the store's value changes.


