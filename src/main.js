import { createApp } from 'vue'
import App from './App.vue'
import { axiosConfig } from './axios.config'

axiosConfig();
createApp(App).mount('#app')
