import { defineStore } from 'pinia'
import type { User, LoginCredentials, RegisterData, LoginResult, RegisterResult } from '@/types'

const STORAGE_KEY = {
  USER: 'auth_user',
  TOKEN: 'auth_token',
  IS_GUEST: 'auth_is_guest'
}

const generateId = (): string => {
  return 'user_' + Date.now() + '_' + Math.random().toString(36).substr(2, 9)
}

const MOCK_USERS: Array<{ email: string; password: string; user: User }> = [
  {
    email: 'demo@protein.com',
    password: 'demo123',
    user: {
      id: 'user_demo_001',
      email: 'demo@protein.com',
      nickname: '演示用户',
      createdAt: '2024-01-01T00:00:00Z'
    }
  }
]

export const useAuthStore = defineStore('auth', {
  state: () => ({
    user: null as User | null,
    token: null as string | null,
    isLoggedIn: false,
    isGuest: false
  }),

  getters: {
    currentUser: (state) => state.user,
    isAuthenticated: (state) => state.isLoggedIn,
    userNickname: (state) => state.user?.nickname || '未登录',
    isGuestUser: (state) => state.isGuest
  },

  actions: {
    init() {
      const storedUser = localStorage.getItem(STORAGE_KEY.USER)
      const storedToken = localStorage.getItem(STORAGE_KEY.TOKEN)
      const storedIsGuest = localStorage.getItem(STORAGE_KEY.IS_GUEST)
      
      if (storedUser && storedToken) {
        this.user = JSON.parse(storedUser)
        this.token = storedToken
        this.isLoggedIn = true
        this.isGuest = storedIsGuest === 'true' || false
      }
    },

    async login(credentials: LoginCredentials): Promise<LoginResult> {
      await new Promise(resolve => setTimeout(resolve, 800))

      const mockUser = MOCK_USERS.find(
        u => u.email === credentials.email && u.password === credentials.password
      )

      if (mockUser) {
        const token = 'mock_token_' + Date.now()
        this.user = mockUser.user
        this.token = token
        this.isLoggedIn = true
        this.isGuest = false

        localStorage.setItem(STORAGE_KEY.USER, JSON.stringify(mockUser.user))
        localStorage.setItem(STORAGE_KEY.TOKEN, token)
        localStorage.setItem(STORAGE_KEY.IS_GUEST, 'false')

        return {
          success: true,
          message: '登录成功',
          user: mockUser.user,
          token
        }
      }

      return {
        success: false,
        message: '邮箱或密码错误'
      }
    },

    async register(data: RegisterData): Promise<RegisterResult> {
      await new Promise(resolve => setTimeout(resolve, 800))

      const existingUser = MOCK_USERS.find(u => u.email === data.email)
      if (existingUser) {
        return {
          success: false,
          message: '该邮箱已被注册'
        }
      }

      if (data.password !== data.confirmPassword) {
        return {
          success: false,
          message: '两次输入的密码不一致'
        }
      }

      if (data.password.length < 6) {
        return {
          success: false,
          message: '密码长度至少为6位'
        }
      }

      const newUser: User = {
        id: generateId(),
        email: data.email,
        nickname: data.nickname || data.email.split('@')[0],
        createdAt: new Date().toISOString()
      }

      MOCK_USERS.push({
        email: data.email,
        password: data.password,
        user: newUser
      })

      return {
        success: true,
        message: '注册成功',
        user: newUser
      }
    },

    setGuestUser(user: User) {
      const token = 'guest_token_' + Date.now()
      this.user = user
      this.token = token
      this.isLoggedIn = true
      this.isGuest = true

      localStorage.setItem(STORAGE_KEY.USER, JSON.stringify(user))
      localStorage.setItem(STORAGE_KEY.TOKEN, token)
      localStorage.setItem(STORAGE_KEY.IS_GUEST, 'true')
    },

    logout() {
      this.user = null
      this.token = null
      this.isLoggedIn = false
      this.isGuest = false

      localStorage.removeItem(STORAGE_KEY.USER)
      localStorage.removeItem(STORAGE_KEY.TOKEN)
      localStorage.removeItem(STORAGE_KEY.IS_GUEST)
    },

    updateNickname(nickname: string) {
      if (this.user) {
        this.user.nickname = nickname
        localStorage.setItem(STORAGE_KEY.USER, JSON.stringify(this.user))
      }
    }
  }
})