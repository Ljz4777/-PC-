# SynPharm - 鍛藉悕瑙勮寖

> 鏈枃妗ｈ褰曢」鐩殑鍛藉悕瑙勮寖鍜岀粺涓€鏍囧噯

---

## 1. 椤圭洰鍛藉悕

| 绫诲瀷 | 涓枃鍚?| 鑻辨枃鍚?| 鍖呭悕/鍛藉悕绌洪棿 |
|------|--------|--------|--------------|
| 椤圭洰鍚嶇О | SynPharm | SynPharm | com.synpharm |
| 鍓嶇椤圭洰 | SynPharm PC | synpharm-pc | - |
| 鍚庣椤圭洰 | SynPharm 鍚庣 | synpharm-backend | com.synpharm |

---

## 2. 浠ｇ爜鍛藉悕瑙勮寖

### 2.1 Java 鍚庣

#### 鍖呭懡鍚?- 鍏ㄩ儴灏忓啓锛屼娇鐢ㄧ偣鍙峰垎闅?- 鏍煎紡锛歚com.synpharm.{妯″潡}`
- 绀轰緥锛?  - `com.synpharm.api`
  - `com.synpharm.service`
  - `com.synpharm.repository`

#### 绫诲懡鍚?- **Controller**: `{涓氬姟鍚峿Controller`
  - `AuthController`, `UserController`, `PredictController`
- **Service**: `{涓氬姟鍚峿Service` / `{涓氬姟鍚峿ServiceImpl`
  - `AuthService`, `AuthServiceImpl`
- **Repository**: `{瀹炰綋鍚峿Repository`
  - `SysUserRepository`, `PredictTaskRepository`
- **Entity**: 瀹炰綋鍚嶇О
  - `SysUser`, `PredictTask`, `PredictResult`
- **DTO**: 
  - 璇锋眰锛歚{涓氬姟鍚峿Request`
  - 鍝嶅簲锛歚{涓氬姟鍚峿Response`
- **Enum**: 涓氬姟鍚箟 + Level/Type/Status
  - `PredictType`, `TaskStatus`, `ConfidenceLevel`
- **Exception**: 
  - `BusinessException`, `GlobalExceptionHandler`
- **Utils**: 宸ュ叿鍔熻兘 + Utils
  - `JwtUtils`, `PasswordUtils`

#### 鏂规硶鍛藉悕
- **Getter/Setter**: `getXXX()`, `setXXX()`
- **鏌ヨ**: `findXXX()`, `getXXX()`, `queryXXX()`
- **鏂板**: `createXXX()`, `saveXXX()`, `addXXX()`
- **鏇存柊**: `updateXXX()`, `modifyXXX()`
- **鍒犻櫎**: `deleteXXX()`, `removeXXX()`
- **鍒ゆ柇**: `isXXX()`, `hasXXX()`, `checkXXX()`

#### 鍙橀噺鍛藉悕
- **灞€閮ㄥ彉閲?*: 椹煎嘲鍛藉悕
  - `userId`, `taskNo`, `predictType`
- **甯搁噺**: 鍏ㄥぇ鍐欙紝涓嬪垝绾垮垎闅?  - `DEFAULT_PAGE_SIZE`, `JWT_EXPIRATION`
- **甯冨皵鍊?*: 浣跨敤 is/has/can 鍓嶇紑
  - `isActive`, `hasPermission`, `canEdit`

### 2.2 鍓嶇 Vue/TypeScript

#### 缁勪欢鍛藉悕
- **鏂囦欢鍚?*: PascalCase锛堝ぇ椹煎嘲锛?  - `ResultCard.vue`, `Sidebar.vue`
- **缁勪欢鍚?*: 涓庢枃浠跺悕涓€鑷?  ```typescript
  export default {
    name: 'ResultCard'
  }
  ```

#### 鍙橀噺鍛藉悕
- **鍝嶅簲寮忔暟鎹?*: 椹煎嘲鍛藉悕
  - `const userName = ref('')`
- **璁＄畻灞炴€?*: 椹煎嘲鍛藉悕
  - `const formattedDate = computed(() => ...)`
- **鍑芥暟**: 椹煎嘲鍛藉悕
  - `handleLogin()`, `fetchUserData()`

#### 绫诲瀷鍛藉悕
- **鎺ュ彛**: PascalCase
  - `interface User`, `interface PredictResult`
- **绫诲瀷鍒悕**: PascalCase
  - `type PredictType = 'DTI' | 'PPI' | 'DDI'`

---

## 3. 鏁版嵁搴撳懡鍚?
### 3.1 琛ㄥ懡鍚?
- **鏍煎紡**: `{涓氬姟鍓嶇紑}_{琛ㄥ悕}`
- **鍓嶇紑瑙勮寖**:
  - `sys_`: 绯荤粺鐩稿叧锛堢敤鎴枫€佽鑹层€佹潈闄愶級
  - `predict_`: 棰勬祴鐩稿叧锛堜换鍔°€佺粨鏋滐級
  - `user_`: 鐢ㄦ埛涓汉鏁版嵁锛堟敹钘忋€佽缃級

- **绀轰緥**:
  - `sys_user` - 绯荤粺鐢ㄦ埛琛?  - `predict_task` - 棰勬祴浠诲姟琛?  - `predict_result` - 棰勬祴缁撴灉琛?  - `user_favorite` - 鐢ㄦ埛鏀惰棌琛?
### 3.2 瀛楁鍛藉悕

- **涓婚敭**: `id`
- **澶栭敭**: `{鍏宠仈琛▆_id`
  - `user_id`, `task_id`, `result_id`
- **鏃堕棿瀛楁**: `{鍚箟}_at`
  - `created_at`, `updated_at`, `deleted_at`
- **鐘舵€佸瓧娈?*: `status`, `type`
- **甯冨皵瀛楁**: `is_{鍚箟}`
  - `is_active`, `is_verified`

### 3.3 绱㈠紩鍛藉悕

- **鏅€氱储寮?*: `idx_{瀛楁鍚峿`
  - `idx_email`, `idx_status`
- **鍞竴绱㈠紩**: `uk_{瀛楁鍚峿`
  - `uk_email`
- **澶栭敭绱㈠紩**: `fk_{鍏宠仈琛▆`
  - `fk_user_id`

---

## 4. API 鎺ュ彛鍛藉悕

### 4.1 RESTful 椋庢牸

```
GET    /api/{璧勬簮}          # 鑾峰彇璧勬簮鍒楄〃
GET    /api/{璧勬簮}/{id}     # 鑾峰彇鍗曚釜璧勬簮
POST   /api/{璧勬簮}          # 鍒涘缓璧勬簮
PUT    /api/{璧勬簮}/{id}     # 鏇存柊璧勬簮
DELETE /api/{璧勬簮}/{id}     # 鍒犻櫎璧勬簮
```

### 4.2 鎺ュ彛璺緞

- **璁よ瘉妯″潡**: `/api/auth/*`
  - `POST /api/auth/login`
  - `POST /api/auth/register`
  - `POST /api/auth/logout`

- **鐢ㄦ埛妯″潡**: `/api/user/*`
  - `GET /api/user/info`
  - `PUT /api/user/nickname`
  - `PUT /api/user/avatar`

- **棰勬祴妯″潡**: `/api/predict/*`
  - `POST /api/predict/dti`
  - `POST /api/predict/ppi`
  - `POST /api/predict/ddi`

- **浠诲姟妯″潡**: `/api/tasks/*`
  - `GET /api/tasks`
  - `GET /api/tasks/{taskNo}`
  - `POST /api/tasks/{taskNo}/cancel`

- **缁撴灉妯″潡**: `/api/results/*`
  - `GET /api/results`
  - `GET /api/results/{resultNo}`

---

## 5. 鏂囦欢鍛藉悕

### 5.1 閰嶇疆鏂囦欢

- **鍓嶇**: 
  - `.env.example` - 鐜鍙橀噺妯℃澘
  - `vite.config.ts` - Vite 閰嶇疆
  - `tsconfig.json` - TypeScript 閰嶇疆

- **鍚庣**:
  - `pom.xml` - Maven 閰嶇疆
  - `application.yml` - 涓婚厤缃?  - `application-dev.yml` - 寮€鍙戠幆澧冮厤缃?  - `application-prod.yml` - 鐢熶骇鐜閰嶇疆

### 5.2 鏂囨。鏂囦欢

- `README.md` - 椤圭洰璇存槑
- `TECHNICAL_DOCUMENTATION.md` - 鎶€鏈枃妗?- `PROJECT_STATUS.md` - 椤圭洰鐘舵€?- `PROJECT_STRUCTURE.md` - 鏂囦欢缁撴瀯
- `NAMING_CONVENTIONS.md` - 鍛藉悕瑙勮寖锛堟湰鏂囨。锛?
---

## 6. Git 鎻愪氦瑙勮寖

### 6.1 鎻愪氦鏍煎紡

```
<type>(<scope>): <subject>
```

### 6.2 Type 绫诲瀷

- `feat`: 鏂板姛鑳?- `fix`: Bug 淇
- `docs`: 鏂囨。鏇存柊
- `style`: 浠ｇ爜鏍煎紡璋冩暣
- `refactor`: 閲嶆瀯
- `test`: 娴嬭瘯鐩稿叧
- `chore`: 鏋勫缓/宸ュ叿/閰嶇疆

### 6.3 绀轰緥

```
feat(auth): 娣诲姞鐢ㄦ埛鐧诲綍鍔熻兘
fix(api): 淇棰勬祴鎺ュ彛鍙傛暟楠岃瘉
docs(readme): 鏇存柊蹇€熷紑濮嬫寚鍗?refactor(service): 閲嶆瀯棰勬祴鏈嶅姟閫昏緫
```

---

## 7. 鐗堟湰鍛藉悕

### 7.1 璇箟鍖栫増鏈?
鏍煎紡锛歚MAJOR.MINOR.PATCH`

- **MAJOR**: 涓嶅吋瀹圭殑 API 鍙樻洿
- **MINOR**: 鍚戝悗鍏煎鐨勫姛鑳芥柊澧?- **PATCH**: 鍚戝悗鍏煎鐨勯棶棰樹慨澶?
### 7.2 褰撳墠鐗堟湰

- 鍓嶇锛歚1.0.0`
- 鍚庣锛歚1.0.0`

---

*鏂囨。鐗堟湰锛?.0*
*鏈€鍚庢洿鏂帮細2024 骞?
