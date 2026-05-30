<template>
  <div class="login">
    <div class="login__left">
      <div class="login__logo">
        <span class="login__logo-icon">🧬</span>
        <span class="login__logo-text">智互药研</span>
      </div>
      <div class="login__hero">
        <h1 class="login__hero-title">智能药物研发平台</h1>
        <p class="login__hero-desc">基于多智能体协同技术，精准预测分子互作</p>
      </div>
      <div class="login__features">
        <div class="login__feature">
          <span class="login__feature-icon">🔬</span>
          <span class="login__feature-text">PPI/DTI/DDI预测</span>
        </div>
        <div class="login__feature">
          <span class="login__feature-icon">3️⃣D</span>
          <span class="login__feature-text">3D可视化</span>
        </div>
        <div class="login__feature">
          <span class="login__feature-icon">📊</span>
          <span class="login__feature-text">批量处理</span>
        </div>
      </div>
    </div>
    
    <div class="login__right">
      <div class="login__card">
        <router-link to="/" class="login__back-link">
          ← 返回首页
        </router-link>
        <h2 class="login__card-title">欢迎回来</h2>
        <p class="login__card-subtitle">登录您的账户</p>
        
        <form @submit.prevent="handleLogin" class="login__form">
          <div class="login__form-group">
            <label class="login__label">邮箱</label>
            <input 
              v-model="email"
              type="email" 
              class="login__input"
              placeholder="请输入邮箱"
              required
            />
          </div>
          
          <div class="login__form-group">
            <label class="login__label">密码</label>
            <input 
              v-model="password"
              type="password" 
              class="login__input"
              placeholder="请输入密码"
              required
            />
          </div>
          
          <div class="login__form-group login__form-group--remember">
            <input 
              v-model="rememberMe"
              type="checkbox" 
              id="remember"
              class="login__checkbox"
            />
            <label for="remember" class="login__remember-label">记住我</label>
            <a href="#" class="login__forgot-link">忘记密码?</a>
          </div>
          
          <button 
            type="submit" 
            class="login__btn login__btn--primary"
            :disabled="isLoading"
          >
            {{ isLoading ? '登录中...' : '登录' }}
          </button>
        </form>
        
        <div class="login__divider">
          <span class="login__divider-text">或</span>
        </div>
        
        <button 
          class="login__btn login__btn--outline"
          @click="handleGuestLogin"
        >
          游客模式
        </button>
        
        <p class="login__register">
          还没有账户? 
          <router-link to="/register" class="login__register-link">立即注册</router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useAuthStore } from '@/stores/auth'
import { useRouter } from 'vue-router'

const authStore = useAuthStore()
const router = useRouter()

const email = ref('')
const password = ref('')
const rememberMe = ref(false)
const isLoading = ref(false)

const handleLogin = async () => {
  isLoading.value = true
  
  const result = await authStore.login({
    email: email.value,
    password: password.value
  })
  
  if (result.success) {
    router.push('/dashboard')
  }
  
  isLoading.value = false
}

const handleGuestLogin = () => {
  authStore.setGuestUser({
    id: 'guest_user',
    email: 'guest@example.com',
    nickname: '游客',
    createdAt: new Date().toISOString()
  })
  
  router.push('/dashboard')
}
</script>

<style lang="scss" scoped>
.login {
  display: flex;
  min-height: 100vh;
}

.login__left {
  flex: 1;
  background: linear-gradient(135deg, $primary-color 0%, $accent-color 100%);
  padding: $spacing-2xl;
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: #ffffff;
}

.login__logo {
  display: flex;
  align-items: center;
  gap: $spacing-md;
  margin-bottom: $spacing-2xl;
}

.login__logo-icon {
  font-size: 32px;
}

.login__logo-text {
  font-size: 24px;
  font-weight: 700;
}

.login__hero {
  margin-bottom: $spacing-2xl;
}

.login__hero-title {
  font-size: 40px;
  font-weight: 700;
  margin-bottom: $spacing-md;
  line-height: 1.2;
}

.login__hero-desc {
  font-size: $font-size-lg;
  opacity: 0.8;
}

.login__features {
  display: flex;
  gap: $spacing-xl;
}

.login__feature {
  display: flex;
  align-items: center;
  gap: $spacing-sm;
}

.login__feature-icon {
  font-size: 20px;
}

.login__feature-text {
  font-size: $font-size-sm;
}

.login__right {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: $spacing-2xl;
  background: $bg-secondary;
}

.login__card {
  width: 100%;
  max-width: 400px;
  background: $bg-primary;
  border-radius: $border-radius-xl;
  padding: $spacing-2xl;
  box-shadow: $shadow-lg;
}

.login__back-link {
  display: inline-block;
  font-size: $font-size-sm;
  color: $text-secondary;
  text-decoration: none;
  margin-bottom: $spacing-lg;
  transition: color $transition-fast;
  
  &:hover {
    color: $primary-color;
    text-decoration: underline;
  }
}

.login__card-title {
  font-size: 24px;
  font-weight: 600;
  color: $text-primary;
  margin-bottom: $spacing-xs;
}

.login__card-subtitle {
  font-size: $font-size-sm;
  color: $text-muted;
  margin-bottom: $spacing-xl;
}

.login__form {
  display: flex;
  flex-direction: column;
  gap: $spacing-lg;
}

.login__form-group {
  display: flex;
  flex-direction: column;
  gap: $spacing-xs;
}

.login__form-group--remember {
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}

.login__label {
  font-size: $font-size-sm;
  font-weight: 500;
  color: $text-primary;
}

.login__input {
  padding: $spacing-md;
  border: 1px solid $border-color;
  border-radius: $border-radius-md;
  font-size: $font-size-base;
  background: $bg-secondary;
  transition: border-color $transition-fast;
  
  &:focus {
    outline: none;
    border-color: $primary-color;
  }
}

.login__checkbox {
  width: 18px;
  height: 18px;
  border-radius: $border-radius-sm;
}

.login__remember-label {
  font-size: $font-size-sm;
  color: $text-secondary;
  margin-left: $spacing-xs;
}

.login__forgot-link {
  font-size: $font-size-sm;
  color: $primary-color;
  text-decoration: none;
  
  &:hover {
    text-decoration: underline;
  }
}

.login__btn {
  padding: $spacing-md;
  border-radius: $border-radius-md;
  font-size: $font-size-base;
  font-weight: 500;
  cursor: pointer;
  border: none;
  transition: all $transition-fast;
  
  &--primary {
    background: $primary-color;
    color: #ffffff;
    
    &:hover:not(:disabled) {
      background: $primary-dark;
    }
    
    &:disabled {
      background: $border-color;
      cursor: not-allowed;
    }
  }
  
  &--outline {
    background: transparent;
    color: $text-primary;
    border: 1px solid $border-color;
    
    &:hover {
      background: $bg-secondary;
    }
  }
}

.login__divider {
  display: flex;
  align-items: center;
  gap: $spacing-md;
  margin: $spacing-lg 0;
}

.login__divider::before,
.login__divider::after {
  content: '';
  flex: 1;
  height: 1px;
  background: $border-color;
}

.login__divider-text {
  font-size: $font-size-xs;
  color: $text-muted;
}

.login__register {
  text-align: center;
  font-size: $font-size-sm;
  color: $text-secondary;
  margin-top: $spacing-lg;
}

.login__register-link {
  color: $primary-color;
  font-weight: 500;
  text-decoration: none;
  
  &:hover {
    text-decoration: underline;
  }
}
</style>