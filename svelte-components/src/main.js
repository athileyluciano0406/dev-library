import App from './App.svelte';
import HelloWorld from './HelloWorld.svelte';

new HelloWorld({
	target: document.querySelector('#hello-world-container'),
});
const app = new App({
	target: document.body,
	props: {
		name: 'world'
	}
});

export default app;
