# AI药物发现平台 - PC端

基于 Vue 3 + Element Plus 构建的AI药物发现平台PC端界面。

## 技术栈

- **框架**: Vue 3
- **语言**: TypeScript
- **状态管理**: Pinia
- **路由**: Vue Router
- **UI组件**: Element Plus
- **图表**: ECharts
- **样式**: SCSS
- **构建工具**: Vite

## 快速开始

```bash
# 安装依赖
npm install

# 开发模式
npm run dev

# 生产构建
npm run build

# 预览构建结果
npm run preview
```

## 项目结构

```
src/
├── views/          # 页面视图
├── components/     # 公共组件
├── router/         # 路由配置
├── stores/         # 状态管理
├── types/          # 类型定义
├── data/           # Mock数据
├── utils/          # 工具函数
└── styles/         # 全局样式
```

## 核心功能

- **PPI预测**: 蛋白质-蛋白质相互作用预测
- **DTI预测**: 药物-靶点相互作用预测
- **DDI预测**: 药物-药物相互作用预测
- **3D可视化**: 分子结构3D展示
- **任务管理**: 预测任务追踪与管理
- **用户中心**: 个人中心与历史记录

## 部署

```bash
npm run build
```

构建产物在 `dist/` 目录，可部署到任意静态服务器。

## 许可证

MIT
