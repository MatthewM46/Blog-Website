FROM node:21 AS build

COPY package-lock.json package-lock.json
COPY package.json package.json

RUN npm install

COPY postcss.config.js postcss.config.js
COPY tailwind.config.js tailwind.config.js
COPY svelte.config.js svelte.config.js
COPY vite.config.js vite.config.js

COPY src/ src/

RUN npm run build
RUN npm ci --omit dev

FROM node:21-alpine

COPY --from=build build/ build/
COPY --from=build node_modules/ node_modules/
COPY --from=build package.json package.json

EXPOSE 3000

CMD node build