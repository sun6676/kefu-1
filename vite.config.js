import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { fileURLToPath, URL } from 'node:url'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue()
  ],
  server: {
    // 添加允许访问的主机
    port: 5274,
    host: '0.0.0.0',
    allowedHosts: [
      'localhost',
      'b758c25.r40.cpolar.top'  // 允许这个主机访问
    ],
    proxy: {
      '/api': {
        target: ' http://localhost:8090',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''), // 去掉 /api 前缀
      },
    },
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
})
