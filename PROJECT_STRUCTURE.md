﻿# SynPharm - 椤圭洰鏂囦欢缁撴瀯

> 鏈枃浠惰褰曢」鐩殑瀹屾暣鐩綍缁撴瀯

---

## 馃搧 椤圭洰鏍圭洰褰?
```
SynPharm-PC/
鈹溾攢鈹€ src/                        # 鍓嶇婧愮爜
鈹溾攢鈹€ backend/                    # 鍚庣婧愮爜
鈹溾攢鈹€ .env.example               # 鐜鍙橀噺妯℃澘
鈹溾攢鈹€ .gitignore                 # Git蹇界暐閰嶇疆
鈹溾攢鈹€ BACKEND_DEVELOPMENT_PROMPTS.md
鈹溾攢鈹€ BACKEND_IMPLEMENTATION.md
鈹溾攢鈹€ LICENSE                    # MIT璁稿彲璇?鈹溾攢鈹€ NAMING_CONVENTIONS.md      # 鍛藉悕瑙勮寖
鈹溾攢鈹€ PROJECT_STRUCTURE.md       # 椤圭洰缁撴瀯锛堟湰鏂囨。锛?鈹溾攢鈹€ README.md                  # 椤圭洰璇存槑
鈹溾攢鈹€ TECHNICAL_DOCUMENTATION.md # 瀹屾暣鎶€鏈枃妗?鈹溾攢鈹€ index.html                 # 鍓嶇鍏ュ彛HTML
鈹溾攢鈹€ package-lock.json          # NPM渚濊禆閿佸畾
鈹溾攢鈹€ package.json               # NPM渚濊禆閰嶇疆
鈹溾攢鈹€ tsconfig.json              # TypeScript閰嶇疆
鈹溾攢鈹€ tsconfig.node.json         # TypeScript Node閰嶇疆
鈹斺攢鈹€ vite.config.ts             # Vite鏋勫缓閰嶇疆
```

---

## 馃帹 鍓嶇缁撴瀯 (src/)

```
src/
鈹溾攢鈹€ components/               # 鍏叡缁勪欢
鈹?  鈹溾攢鈹€ ResultCard.vue        # 缁撴灉鍗＄墖缁勪欢
鈹?  鈹斺攢鈹€ Sidebar.vue           # 渚ц竟鏍忓鑸粍浠?鈹?鈹溾攢鈹€ data/                    # 鏁版嵁灞?鈹?  鈹斺攢鈹€ mockResults.ts        # Mock鏁版嵁
鈹?鈹溾攢鈹€ router/                  # 璺敱閰嶇疆
鈹?  鈹斺攢鈹€ index.ts             # 璺敱瀹氫箟涓庡畧鍗?鈹?鈹溾攢鈹€ stores/                  # 鐘舵€佺鐞?(Pinia)
鈹?  鈹斺攢鈹€ auth.ts              # 璁よ瘉鐘舵€佺鐞?鈹?鈹溾攢鈹€ styles/                  # 鏍峰紡鏂囦欢
鈹?  鈹斺攢鈹€ variables.scss       # SCSS鍏ㄥ眬鍙橀噺
鈹?鈹溾攢鈹€ types/                   # TypeScript绫诲瀷瀹氫箟
鈹?  鈹斺攢鈹€ index.ts             # 鍏ㄥ眬绫诲瀷澹版槑
鈹?鈹溾攢鈹€ utils/                   # 宸ュ叿鍑芥暟
鈹?  鈹斺攢鈹€ validators.ts        # 琛ㄥ崟楠岃瘉宸ュ叿
鈹?鈹溾攢鈹€ views/                   # 椤甸潰瑙嗗浘
鈹?  鈹溾攢鈹€ Dashboard.vue        # 浠〃鐩?鈹?  鈹溾攢鈹€ Home.vue             # 棣栭〉
鈹?  鈹溾攢鈹€ Login.vue            # 鐧诲綍椤?鈹?  鈹溾攢鈹€ Predict.vue          # 棰勬祴椤?鈹?  鈹溾攢鈹€ Profile.vue          # 涓汉涓績
鈹?  鈹溾攢鈹€ Register.vue         # 娉ㄥ唽椤?鈹?  鈹溾攢鈹€ Results.vue          # 缁撴灉鍒楄〃
鈹?  鈹溾攢鈹€ Targets.vue          # 闈剁偣绠＄悊
鈹?  鈹溾攢鈹€ Tasks.vue            # 浠诲姟鍒楄〃
鈹?  鈹斺攢鈹€ Visualization.vue    # 鍙鍖栭〉
鈹?鈹溾攢鈹€ App.vue                  # 鏍圭粍浠?鈹斺攢鈹€ main.ts                  # 搴旂敤鍏ュ彛
```

---

## 馃敡 鍚庣缁撴瀯 (backend/)

```
backend/
鈹溾攢鈹€ sql/                     # 鏁版嵁搴撹剼鏈?鈹?  鈹斺攢鈹€ init.sql             # 寤鸿〃鑴氭湰
鈹?鈹溾攢鈹€ src/main/
鈹?  鈹溾攢鈹€ java/com/synpharm/
鈹?  鈹?  鈹溾攢鈹€ api/             # 鎺ュ彛灞?(Controller)
鈹?  鈹?  鈹?  鈹溾攢鈹€ AuthController.java      # 璁よ瘉鎺ュ彛
鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictController.java   # 棰勬祴鎺ュ彛
鈹?  鈹?  鈹?  鈹溾攢鈹€ ResultController.java    # 缁撴灉鎺ュ彛
鈹?  鈹?  鈹?  鈹溾攢鈹€ TaskController.java      # 浠诲姟鎺ュ彛
鈹?  鈹?  鈹?  鈹斺攢鈹€ UserController.java      # 鐢ㄦ埛鎺ュ彛
鈹?  鈹?  鈹?鈹?  鈹?  鈹溾攢鈹€ config/          # 閰嶇疆灞?鈹?  鈹?  鈹?  鈹溾攢鈹€ CorsConfig.java                  # 璺ㄥ煙閰嶇疆
鈹?  鈹?  鈹?  鈹溾攢鈹€ JwtAuthenticationFilter.java    # JWT杩囨护鍣?鈹?  鈹?  鈹?  鈹溾攢鈹€ Knife4jConfig.java              # API鏂囨。閰嶇疆
鈹?  鈹?  鈹?  鈹斺攢鈹€ MyBatisPlusMetaObjectHandler.java # 鑷姩濉厖
鈹?  鈹?  鈹?鈹?  鈹?  鈹溾攢鈹€ dto/             # 鏁版嵁浼犺緭瀵硅薄
鈹?  鈹?  鈹?  鈹溾攢鈹€ request/     # 璇锋眰DTO
鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ DDIPredictRequest.java
鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ DTIPredictRequest.java
鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ LoginRequest.java
鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ PPIPredictRequest.java
鈹?  鈹?  鈹?  鈹?  鈹斺攢鈹€ RegisterRequest.java
鈹?  鈹?  鈹?  鈹斺攢鈹€ response/    # 鍝嶅簲DTO
鈹?  鈹?  鈹?      鈹溾攢鈹€ LoginResponse.java
鈹?  鈹?  鈹?      鈹溾攢鈹€ PredictResultResponse.java
鈹?  鈹?  鈹?      鈹斺攢鈹€ UserResponse.java
鈹?  鈹?  鈹?鈹?  鈹?  鈹溾攢鈹€ exception/       # 寮傚父澶勭悊
鈹?  鈹?  鈹?  鈹溾攢鈹€ BusinessException.java         # 涓氬姟寮傚父
鈹?  鈹?  鈹?  鈹溾攢鈹€ ErrorCode.java                 # 閿欒鐮佹灇涓?鈹?  鈹?  鈹?  鈹斺攢鈹€ GlobalExceptionHandler.java    # 鍏ㄥ眬寮傚父澶勭悊
鈹?  鈹?  鈹?鈹?  鈹?  鈹溾攢鈹€ model/           # 鏁版嵁妯″瀷
鈹?  鈹?  鈹?  鈹溾攢鈹€ entity/      # 瀹炰綋绫?鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictResult.java
鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictTask.java
鈹?  鈹?  鈹?  鈹?  鈹斺攢鈹€ SysUser.java
鈹?  鈹?  鈹?  鈹斺攢鈹€ enums/       # 鏋氫妇绫?鈹?  鈹?  鈹?      鈹溾攢鈹€ ConfidenceLevel.java
鈹?  鈹?  鈹?      鈹溾攢鈹€ PredictType.java
鈹?  鈹?  鈹?      鈹斺攢鈹€ TaskStatus.java
鈹?  鈹?  鈹?鈹?  鈹?  鈹溾攢鈹€ repository/      # 鏁版嵁璁块棶灞?(Mapper)
鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictResultRepository.java
鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictTaskRepository.java
鈹?  鈹?  鈹?  鈹斺攢鈹€ SysUserRepository.java
鈹?  鈹?  鈹?鈹?  鈹?  鈹溾攢鈹€ service/         # 涓氬姟閫昏緫灞?鈹?  鈹?  鈹?  鈹溾攢鈹€ impl/        # 瀹炵幇绫?鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ AuthServiceImpl.java
鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictServiceImpl.java
鈹?  鈹?  鈹?  鈹?  鈹溾攢鈹€ ResultServiceImpl.java
鈹?  鈹?  鈹?  鈹?  鈹斺攢鈹€ TaskServiceImpl.java
鈹?  鈹?  鈹?  鈹溾攢鈹€ AuthService.java
鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictService.java
鈹?  鈹?  鈹?  鈹溾攢鈹€ ResultService.java
鈹?  鈹?  鈹?  鈹斺攢鈹€ TaskService.java
鈹?  鈹?  鈹?鈹?  鈹?  鈹溾攢鈹€ utils/           # 宸ュ叿绫?鈹?  鈹?  鈹?  鈹溾攢鈹€ JwtUtils.java         # JWT宸ュ叿
鈹?  鈹?  鈹?  鈹溾攢鈹€ PasswordUtils.java    # 瀵嗙爜宸ュ叿
鈹?  鈹?  鈹?  鈹斺攢鈹€ Result.java           # 缁熶竴鍝嶅簲
鈹?  鈹?  鈹?鈹?  鈹?  鈹斺攢鈹€ SynPharmApplication.java  # 鍚姩绫?鈹?  鈹?鈹?  鈹斺攢鈹€ resources/           # 璧勬簮鏂囦欢
鈹?      鈹溾攢鈹€ application.yml       # 涓婚厤缃?鈹?      鈹斺攢鈹€ application-dev.yml   # 寮€鍙戠幆澧冮厤缃?鈹?鈹斺攢鈹€ pom.xml                  # Maven渚濊禆閰嶇疆
```

---

## 馃搳 鏂囦欢缁熻

| 绫诲瀷 | 鏁伴噺 | 璇存槑 |
|------|------|------|
| 鍓嶇椤甸潰 | 10 | views/*.vue |
| 鍓嶇缁勪欢 | 2 | components/*.vue |
| 鍚庣Controller | 5 | api/*.java |
| 鍚庣Service | 8 | service/*.java + impl/*.java |
| 鍚庣Repository | 3 | repository/*.java |
| 瀹炰綋绫?| 3 | model/entity/*.java |
| 鏋氫妇绫?| 3 | model/enums/*.java |
| DTO | 8 | dto/request/*.java + dto/response/*.java |
| 閰嶇疆绫?| 4 | config/*.java |
| 宸ュ叿绫?| 3 | utils/*.java |
| 寮傚父澶勭悊 | 3 | exception/*.java |
| 鏁版嵁搴撹剼鏈?| 1 | sql/init.sql |
| 鏂囨。 | 6 | *.md |

---

*鐢熸垚鏃堕棿锛?024骞?
