<template>
  <div class="profile">
    <Sidebar />
    <main class="profile__content">
      <header class="profile__header">
        <div>
          <h1 class="profile__title">个人中心</h1>
          <p class="profile__subtitle">管理您的账户和偏好设置</p>
        </div>
      </header>
      
      <section class="profile__main">
        <div class="profile__card profile__card--info">
          <div class="profile__avatar">
            <span class="profile__avatar-text">{{ avatarText }}</span>
          </div>
          <div class="profile__user-info">
            <span class="profile__user-name">{{ authStore.userNickname }}</span>
            <span class="profile__user-email">{{ authStore.user?.email }}</span>
            <span class="profile__user-role">{{ authStore.isGuest ? '游客账号' : '已认证用户' }}</span>
          </div>
          <button class="profile__edit-btn" @click="editProfile">编辑资料</button>
        </div>
        
        <div class="profile__card">
          <h3 class="profile__card-title">账户安全</h3>
          <div class="profile__card-content">
            <button class="profile__card-item">
              <span class="profile__card-icon">🔐</span>
              <span class="profile__card-text">修改密码</span>
              <span class="profile__card-arrow">→</span>
            </button>
            <button class="profile__card-item">
              <span class="profile__card-icon">📧</span>
              <span class="profile__card-text">绑定邮箱</span>
              <span class="profile__card-arrow">→</span>
            </button>
            <button class="profile__card-item">
              <span class="profile__card-icon">📱</span>
              <span class="profile__card-text">绑定手机号</span>
              <span class="profile__card-arrow">→</span>
            </button>
            <button class="profile__card-item">
              <span class="profile__card-icon">🔑</span>
              <span class="profile__card-text">API密钥管理</span>
              <span class="profile__card-arrow">→</span>
            </button>
          </div>
        </div>
        
        <div class="profile__card">
          <h3 class="profile__card-title">使用统计</h3>
          <div class="profile__card-content profile__stats">
            <div class="profile__stat-item">
              <span class="profile__stat-value">{{ stats.totalTasks }}</span>
              <span class="profile__stat-label">总任务数</span>
            </div>
            <div class="profile__stat-item">
              <span class="profile__stat-value">{{ stats.completedTasks }}</span>
              <span class="profile__stat-label">已完成</span>
            </div>
            <div class="profile__stat-item">
              <span class="profile__stat-value">{{ stats.totalResults }}</span>
              <span class="profile__stat-label">预测结果</span>
            </div>
            <div class="profile__stat-item">
              <span class="profile__stat-value">{{ stats.storageUsed }}</span>
              <span class="profile__stat-label">存储空间</span>
            </div>
          </div>
        </div>
        
        <div class="profile__card">
          <h3 class="profile__card-title">系统设置</h3>
          <div class="profile__card-content">
            <div class="profile__card-item profile__card-item--toggle">
              <div>
                <span class="profile__card-icon">🌙</span>
                <span class="profile__card-text">深色模式</span>
              </div>
              <input v-model="darkMode" type="checkbox" class="profile__toggle" />
            </div>
            <div class="profile__card-item profile__card-item--toggle">
              <div>
                <span class="profile__card-icon">🔔</span>
                <span class="profile__card-text">邮件通知</span>
              </div>
              <input v-model="notifications" type="checkbox" class="profile__toggle" />
            </div>
            <div class="profile__card-item profile__card-item--toggle">
              <div>
                <span class="profile__card-icon">📊</span>
                <span class="profile__card-text">数据追踪</span>
              </div>
              <input v-model="dataTracking" type="checkbox" class="profile__toggle" />
            </div>
          </div>
        </div>
        
        <div class="profile__card profile__card--danger">
          <button class="profile__danger-btn" @click="handleDeleteAccount">
            删除账户
          </button>
        </div>
      </section>
    </main>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { useAuthStore } from '@/stores/auth'
import { mockTasks, mockResults } from '@/data/mockResults'
import Sidebar from '@/components/Sidebar.vue'
import type { Task } from '@/types'

const authStore = useAuthStore()

const darkMode = ref(false)
const notifications = ref(true)
const dataTracking = ref(true)

const avatarText = computed(() => {
  if (!authStore.userNickname) return '👤'
  return authStore.userNickname.charAt(0).toUpperCase()
})

const stats = computed(() => ({
  totalTasks: mockTasks.length,
  completedTasks: mockTasks.filter((t: Task) => t.status === 'completed').length,
  totalResults: mockResults.length,
  storageUsed: '128 MB'
}))

const editProfile = () => {
  console.log('编辑资料')
}

const handleDeleteAccount = () => {
  console.log('删除账户')
}
</script>

<style lang="scss" scoped>
.profile {
  display: flex;
  min-height: 100vh;
  background: $bg-secondary;
}

.profile__content {
  flex: 1;
  margin-left: $sidebar-width;
  padding: $spacing-lg;
}

.profile__header {
  margin-bottom: $spacing-xl;
}

.profile__title {
  font-size: 24px;
  font-weight: 600;
  color: $text-primary;
  margin-bottom: $spacing-xs;
}

.profile__subtitle {
  font-size: $font-size-sm;
  color: $text-muted;
}

.profile__main {
  max-width: 600px;
  display: flex;
  flex-direction: column;
  gap: $spacing-lg;
}

.profile__card {
  background: $bg-primary;
  border-radius: $border-radius-lg;
  padding: $spacing-lg;
  border: 1px solid $border-light;
}

.profile__card--info {
  display: flex;
  align-items: center;
  gap: $spacing-lg;
}

.profile__card--danger {
  border-color: rgba($error-color, 0.2);
}

.profile__avatar {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  background: linear-gradient(135deg, $primary-color 0%, $accent-color 100%);
  display: flex;
  align-items: center;
  justify-content: center;
}

.profile__avatar-text {
  font-size: 32px;
  font-weight: 600;
  color: #ffffff;
}

.profile__user-info {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.profile__user-name {
  font-size: $font-size-xl;
  font-weight: 600;
  color: $text-primary;
}

.profile__user-email {
  font-size: $font-size-sm;
  color: $text-secondary;
}

.profile__user-role {
  font-size: $font-size-xs;
  color: $text-muted;
}

.profile__edit-btn {
  padding: $spacing-sm $spacing-lg;
  background: transparent;
  border: 1px solid $border-color;
  border-radius: $border-radius-md;
  font-size: $font-size-sm;
  color: $text-secondary;
  cursor: pointer;
  transition: all $transition-fast;
  
  &:hover {
    background: $bg-secondary;
  }
}

.profile__card-title {
  font-size: $font-size-lg;
  font-weight: 600;
  color: $text-primary;
  margin-bottom: $spacing-lg;
}

.profile__card-content {
  display: flex;
  flex-direction: column;
  gap: $spacing-xs;
}

.profile__card-item {
  display: flex;
  align-items: center;
  gap: $spacing-md;
  padding: $spacing-md;
  border-radius: $border-radius-md;
  cursor: pointer;
  transition: all $transition-fast;
  
  &:hover {
    background: $bg-secondary;
  }
  
  &--toggle {
    justify-content: space-between;
  }
}

.profile__card-icon {
  font-size: $font-size-lg;
}

.profile__card-text {
  flex: 1;
  font-size: $font-size-sm;
  color: $text-primary;
}

.profile__card-arrow {
  font-size: $font-size-lg;
  color: $text-muted;
}

.profile__stats {
  flex-direction: row;
  justify-content: space-between;
}

.profile__stat-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2px;
  padding: $spacing-md;
}

.profile__stat-value {
  font-size: 24px;
  font-weight: 700;
  color: $primary-color;
}

.profile__stat-label {
  font-size: $font-size-xs;
  color: $text-muted;
}

.profile__toggle {
  width: 40px;
  height: 24px;
  border-radius: 12px;
  background: $border-color;
  appearance: none;
  cursor: pointer;
  position: relative;
  transition: background $transition-fast;
  
  &:checked {
    background: $primary-color;
    
    &::after {
      left: 22px;
    }
  }
  
  &::after {
    content: '';
    position: absolute;
    width: 18px;
    height: 18px;
    background: #ffffff;
    border-radius: 50%;
    top: 3px;
    left: 3px;
    transition: left $transition-fast;
  }
}

.profile__danger-btn {
  width: 100%;
  padding: $spacing-md;
  background: transparent;
  border: 1px solid rgba($error-color, 0.3);
  border-radius: $border-radius-md;
  font-size: $font-size-sm;
  color: $error-color;
  cursor: pointer;
  transition: all $transition-fast;
  
  &:hover {
    background: rgba($error-color, 0.1);
  }
}
</style>