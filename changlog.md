# Changelog

## 1.92 (2026-11-22)

### 客户端优化与清理
- **移除检查升级**：停用 `AppUpdateChecker` 及启动时的 GitHub Releases 更新检查与弹窗。
- **停用后台在线人数上报**：停用 `Presence` 向 `api.bitchord.kushagrasingh.in/api/presence` 的定时统计上报，消除非必要外连。
- **一起听改造**：
  - 移除内置默认官方服务器地址（不再回退到 `bitchord-listen-together.onrender.com`）。
  - 「使用自己的服务器」输入框在未配置时默认预填 `http://`。
  - **同步机制优化**：`PartySync` 检查周期缩短至 500ms，新增 250ms–1200ms 区间平滑倍速追赶（1.04x / 0.96x 轻微调速对齐，避免生硬 Seek 卡顿）。
- **播放界面优化**：
  - 切换「随机播放」「列表循环」「单曲循环」「关闭循环」时弹出 Toast 文字提示。
  - 左下角歌词图标按钮改为直接显示「歌词」文字。
- **设置界面清理**：
  - 底部版本号更新为 `BitChord 1.92`（`versionCode = 40`），移除 GitHub / Developer / Discord / Website 外链及副标题。

### 服务端优化（`backend/`）
- 创建/接管默认常驻房间 `8888888` 时，默认开启 `HostOnlyControl = true`（仅房主可控制音乐）。
- 将默认起播预留时间 `JAM_PLAY_LEAD_MS` 从 350ms 提升至 700ms，减少切歌与恢复播放时的缓冲抢跑不同步。

---

## 1.9.1（前期精简与改造记录）
- **APK 体积精简**：仅保留 `arm64-v8a`，移除 Wear OS 套娃打包、Automix ONNX 模型与推理引擎、SF Pro 字体、CMake 原生库、SMB / Google Cast / Watch ADB 等周边重型依赖，Release 包体从 ~90 MB 降至 ~13.6 MB。
- **界面与功能精简**：
  - 播放界面收藏按钮旁新增「一起听」直达按钮；一起听精简为「创建」（接入常驻房间 `8888888` 当房主）与「加入」（直接加入房间 `8888888`）。
  - 播放歌曲菜单移除「转换为视频」与「开启电台」。
  - 账号与集成页面移除 Discord 与 Scrobbling（Last.fm / ListenBrainz）并停用后台相关服务。
  - `AndroidManifest.xml` 开启 `usesCleartextTraffic="true"` 以支持局域网自建 HTTP/WS 一起听服务端。
