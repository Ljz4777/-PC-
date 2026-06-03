# SynPharm - AI药物发现平台

基于 Vue 3 + Spring Boot 构建的 AI 药物发现平台。

## 项目结构

```
├── frontend/          # 前端项目（Vue 3 + Element Plus）
├── backend/           # 后端项目（Spring Boot 3.2 + Java 21）
│   ├── src/main/java/ # Java 源代码
│   ├── src/main/resources/ # 配置文件
│   └── pom.xml        # Maven 依赖配置
└── README.md          # 项目说明文档
```

## 技术栈

### 前端
| 技术 | 版本 | 说明 |
| :--- | :--- | :--- |
| Vue | 3.4+ | 前端框架 |
| TypeScript | 5.x | 类型安全 |
| Pinia | 2.x | 状态管理 |
| Vue Router | 4.x | 路由管理 |
| Element Plus | 2.x | UI组件库 |
| ECharts | 5.x | 图表库 |
| Vite | 5.x | 构建工具 |

### 后端
| 技术 | 版本 | 说明 |
| :--- | :--- | :--- |
| Spring Boot | 3.2.x | 后端框架 |
| Java | 21 | 编程语言 |
| MyBatis Plus | 3.5.x | ORM框架 |
| MySQL | 8.0+ | 数据库 |
| Spring Security | 6.2.x | 安全框架 |
| JWT | - | 身份认证 |
| Knife4j | 4.4.x | API文档 |

## 快速开始

### 前端开发

```bash
cd frontend
npm install
npm run dev
```

### 后端开发

```bash
cd backend
mvn spring-boot:run
```

### 数据库配置

创建数据库：
```sql
CREATE DATABASE synpharm_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

## 核心功能

- 用户认证：注册、登录、JWT令牌管理
- DTI预测：药物-靶点相互作用预测
- PPI预测：蛋白质-蛋白质相互作用预测
- DDI预测：药物-药物相互作用预测
- 3D可视化：分子结构3D展示
- 任务管理：预测任务追踪与管理
- 用户中心：个人中心与历史记录

## API文档

- Swagger UI: http://localhost:8080/swagger-ui.html
- Knife4j: http://localhost:8080/doc.html

## 技术文档

后端技术设计文档：`backend/技术设计文档.md`

## 许可证

MIT License