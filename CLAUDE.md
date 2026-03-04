# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

这是一个标准的 Spring Boot 4.0.2 应用，使用 Java 17 开发。包含完整的用户管理功能。

## 业务功能

### 用户管理
- **用户实体字段**：ID、姓名、年龄、电话、邮箱
- **CRUD 操作**：增删查改
- **访问方式**：
  - Web UI 界面：http://localhost:8082
  - REST API：/api/users 端点

### REST API 接口
- `GET /api/users` - 获取所有用户
- `GET /api/users/{id}` - 获取单个用户
- `POST /api/users` - 创建用户
- `PUT /api/users/{id}` - 更新用户
- `DELETE /api/users/{id}` - 删除用户

## 常用命令

### 构建项目
```bash
./mvnw clean install
```
或在 Windows 上：
```cmd
mvnw.cmd clean install
```

### 运行应用
```bash
./mvnw spring-boot:run
```

### 运行测试
```bash
./mvnw test
```

### 运行单个测试
```bash
./mvnw test -Dtest=DemoApplicationTests
```

### 打包应用
```bash
./mvnw package
```

## 项目结构

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── entity/          # JPA 实体类（User.java）
│   │   ├── repository/      # JPA 仓储接口（UserRepository.java）
│   │   ├── service/        # 业务逻辑层（UserService.java）
│   │   └── controller/     # 控制器层（UserController.java）
│   └── resources/
│       ├── templates/       # Thymeleaf 模板（index.html, create-user.html, edit-user.html）
│       └── application.properties
└── test/                  # 测试代码
```

## 架构说明

- 主应用入口：`src/main/java/com/example/demo/DemoApplication.java`
- 使用 `@SpringBootApplication` 注解，自动配置 Spring Boot 组件
- 分层架构：Entity → Repository → Service → Controller
- 数据层：JPA + H2 内存数据库
- Web 层：Thymeleaf 模板引擎（UI）+ REST API
- 配置文件位于 `src/main/resources/application.properties`
- 默认端口：8082

## 技术栈

- Spring Boot 4.0.2
- Spring Data JPA
- H2 Database（内存数据库）
- Thymeleaf（模板引擎）
