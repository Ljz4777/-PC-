﻿# SynPharm - 鍚庣妗嗘灦瀹炵幇鏂囨。

> 鏈枃妗ｈ褰?SynPharm 鍚庣妗嗘灦鐨勫疄闄呮枃浠剁粨鏋勫拰瀹炵幇缁嗚妭

---

## 宸插垱寤虹殑鍚庣鏂囦欢缁撴瀯

```
backend/
鈹溾攢鈹€ pom.xml
鈹斺攢鈹€ src/main/
    鈹溾攢鈹€ java/com/synpharm/
    鈹?  鈹溾攢鈹€ SynPharmApplication.java
    鈹?  鈹?    鈹?  鈹溾攢鈹€ api/                               # 鎺ュ彛灞?    鈹?  鈹?  鈹溾攢鈹€ AuthController.java
    鈹?  鈹?  鈹溾攢鈹€ UserController.java
    鈹?  鈹?  鈹溾攢鈹€ PredictController.java
    鈹?  鈹?  鈹溾攢鈹€ TaskController.java
    鈹?  鈹?  鈹斺攢鈹€ ResultController.java
    鈹?  鈹?    鈹?  鈹溾攢鈹€ service/                           # 涓氬姟閫昏緫灞?    鈹?  鈹?  鈹溾攢鈹€ AuthService.java
    鈹?  鈹?  鈹溾攢鈹€ UserService.java
    鈹?  鈹?  鈹溾攢鈹€ PredictService.java
    鈹?  鈹?  鈹溾攢鈹€ TaskService.java
    鈹?  鈹?  鈹溾攢鈹€ ResultService.java
    鈹?  鈹?  鈹斺攢鈹€ impl/
    鈹?  鈹?      鈹溾攢鈹€ AuthServiceImpl.java
    鈹?  鈹?      鈹溾攢鈹€ PredictServiceImpl.java
    鈹?  鈹?      鈹溾攢鈹€ ResultServiceImpl.java
    鈹?  鈹?      鈹斺攢鈹€ TaskServiceImpl.java
    鈹?  鈹?    鈹?  鈹溾攢鈹€ repository/                        # 鏁版嵁璁块棶灞?    鈹?  鈹?  鈹溾攢鈹€ SysUserRepository.java
    鈹?  鈹?  鈹溾攢鈹€ PredictTaskRepository.java
    鈹?  鈹?  鈹斺攢鈹€ PredictResultRepository.java
    鈹?  鈹?    鈹?  鈹溾攢鈹€ model/                             # 鏁版嵁妯″瀷
    鈹?  鈹?  鈹溾攢鈹€ entity/
    鈹?  鈹?  鈹?  鈹溾攢鈹€ SysUser.java
    鈹?  鈹?  鈹?  鈹溾攢鈹€ PredictTask.java
    鈹?  鈹?  鈹?  鈹斺攢鈹€ PredictResult.java
    鈹?  鈹?  鈹斺攢鈹€ enums/
    鈹?  鈹?      鈹溾攢鈹€ TaskStatus.java
    鈹?  鈹?      鈹溾攢鈹€ PredictType.java
    鈹?  鈹?      鈹斺攢鈹€ ConfidenceLevel.java
    鈹?  鈹?    鈹?  鈹溾攢鈹€ dto/                               # 鏁版嵁浼犺緭瀵硅薄
    鈹?  鈹?  鈹溾攢鈹€ request/
    鈹?  鈹?  鈹?  鈹溾攢鈹€ LoginRequest.java
    鈹?  鈹?  鈹?  鈹溾攢鈹€ RegisterRequest.java
    鈹?  鈹?  鈹?  鈹溾攢鈹€ DTIPredictRequest.java
    鈹?  鈹?  鈹?  鈹溾攢鈹€ DDIPredictRequest.java
    鈹?  鈹?  鈹?  鈹斺攢鈹€ PPIPredictRequest.java
    鈹?  鈹?  鈹斺攢鈹€ response/
    鈹?  鈹?      鈹溾攢鈹€ LoginResponse.java
    鈹?  鈹?      鈹溾攢鈹€ UserResponse.java
    鈹?  鈹?      鈹斺攢鈹€ PredictResultResponse.java
    鈹?  鈹?    鈹?  鈹溾攢鈹€ config/                            # 閰嶇疆灞?    鈹?  鈹?  鈹溾攢鈹€ CorsConfig.java
    鈹?  鈹?  鈹溾攢鈹€ JwtAuthenticationFilter.java
    鈹?  鈹?  鈹溾攢鈹€ Knife4jConfig.java
    鈹?  鈹?  鈹斺攢鈹€ MyBatisPlusMetaObjectHandler.java
    鈹?  鈹?    鈹?  鈹溾攢鈹€ exception/                          # 寮傚父澶勭悊
    鈹?  鈹?  鈹溾攢鈹€ BusinessException.java
    鈹?  鈹?  鈹溾攢鈹€ ErrorCode.java
    鈹?  鈹?  鈹斺攢鈹€ GlobalExceptionHandler.java
    鈹?  鈹?    鈹?  鈹斺攢鈹€ utils/                             # 宸ュ叿绫?    鈹?      鈹溾攢鈹€ JwtUtils.java
    鈹?      鈹溾攢鈹€ PasswordUtils.java
    鈹?      鈹斺攢鈹€ Result.java
    鈹?    鈹斺攢鈹€ resources/
        鈹溾攢鈹€ application.yml
        鈹斺攢鈹€ application-dev.yml
```

---

## 鏍稿績鏂囦欢璇存槑

### 1. 鍚姩绫?**鏂囦欢**: `com/synpharm/SynPharmApplication.java`
- Spring Boot 鍚姩绫?- 閰嶇疆 MyBatis Plus 鎵弿璺緞

### 2. Controller 灞?| 鏂囦欢 | 鑱岃矗 |
|------|------|
| AuthController.java | 鐢ㄦ埛璁よ瘉锛堢櫥褰曘€佹敞鍐岋級 |
| UserController.java | 鐢ㄦ埛淇℃伅绠＄悊 |
| PredictController.java | 棰勬祴浠诲姟鍒涘缓涓庢墽琛?|
| TaskController.java | 浠诲姟鐘舵€佹煡璇笌绠＄悊 |
| ResultController.java | 棰勬祴缁撴灉鏌ヨ |

### 3. Service 灞?- **鎺ュ彛**: 瀹氫箟涓氬姟鏂规硶濂戠害
- **瀹炵幇**: `impl/` 鐩綍涓嬪寘鍚叿浣撲笟鍔￠€昏緫瀹炵幇

### 4. Repository 灞?- 缁ф壙 MyBatis Plus `BaseMapper`
- 鎻愪緵鍩虹 CRUD 鎿嶄綔
- 鏀寔鑷畾涔?SQL 鏌ヨ

### 5. DTO 缁撴瀯
- **request/**: 鎺ユ敹鍓嶇璇锋眰鍙傛暟
- **response/**: 杩斿洖鍓嶇鍝嶅簲鏁版嵁

### 6. 閰嶇疆绫?- **CorsConfig**: 璺ㄥ煙閰嶇疆
- **JwtAuthenticationFilter**: JWT 璁よ瘉杩囨护鍣?- **Knife4jConfig**: API 鏂囨。閰嶇疆
- **MyBatisPlusMetaObjectHandler**: 鑷姩濉厖鍒涘缓鏃堕棿/鏇存柊鏃堕棿

---

## 鏁版嵁搴撻厤缃?
鏁版嵁搴撳簱鍚嶏細`synpharm`

**鏁版嵁搴撹繛鎺ヤ俊鎭?*:
- 鏁版嵁搴撶被鍨? MySQL 8.0+
- 鏁版嵁搴撳悕绉? `synpharm`
- 鐢ㄦ埛鍚? `root`
- 瀵嗙爜: `password`

---

## 鍚姩鏂瑰紡

```bash
# 杩涘叆鍚庣鐩綍
cd backend

# 缂栬瘧椤圭洰
mvn clean compile

# 杩愯椤圭洰
mvn spring-boot:run

# 璁块棶 API 鏂囨。
# http://localhost:8080/doc.html
```

---

## 鎶€鏈爤

| 鍒嗙被 | 鎶€鏈?| 鐗堟湰 |
|------|------|------|
| 妗嗘灦 | Spring Boot | 3.2.x |
| 鏁版嵁搴?| MySQL | 8.0+ |
| ORM | MyBatis Plus | 3.5.x |
| 缂撳瓨 | Redis | 7.x |
| 瀹夊叏 | JWT | - |
| API鏂囨。 | Knife4j | 4.3.x |
