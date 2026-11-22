# Changelog

## 1.92 (2026-11-22)

### 客户端优化与清理
- **移除蓝牙音频追踪与输出切换 UI**：移除 `BluetoothAudioTracker`、`BLUETOOTH_CONNECT`/`BLUETOOTH` 权限及播放页底部输出切换胶囊，蓝牙设备直接走系统自带路由。
- **一起听同步全面增强**：
  - **就绪屏障（Ready Barrier）**：多端切歌时客户端进入 `STATE_READY` 后向服务端上报 `ready`，全员就绪（或 2.5s 超时）后统一起播，大幅减少冷启动缓冲差异导致的开头不同步。
  - **分段平滑倍速追赶**：偏差 250–600ms 使用 `1.02x / 0.98x`，600–1200ms 使用 `1.05x / 0.95x` 平滑拉齐。
  - **本地音频延迟微调（-500ms ~ +500ms）** 与 **一键立即重新对齐**：可在一起听房间页按设备外放/耳机延迟微调并随时重新校准时钟。
  - **成员同步状态可视化**：成员列表实时展示各设备的同步偏差（如「已同步」「快 Xms」「慢 Xms」）。
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
- 新增 **就绪屏障（Ready Barrier）** 协议（`ready` 帧 + 2.5s 超时兜底），多端切歌全员缓冲就绪后再统一锚定起播。
- 新增 **歌尾自动推进兜底**：曲目播完超 3 秒未收到切歌指令时，服务端自动推进至队列下一首。
- 成员列表下发实时 `driftMs` 同步偏差，并将 `JAM_PLAY_LEAD_MS` 提升至 700ms。

---

## 1.9.1（前期精简与改造记录）
- **APK 体积精简**：仅保留 `arm64-v8a`，移除 Wear OS 套娃打包、Automix ONNX 模型与推理引擎、SF Pro 字体、CMake 原生库、SMB / Google Cast / Watch ADB 等周边重型依赖，Release 包体从 ~90 MB 降至 ~13.6 MB。
- **界面与功能精简**：
  - 播放界面收藏按钮旁新增「一起听」直达按钮；一起听精简为「创建」（接入常驻房间 `8888888` 当房主）与「加入」（直接加入房间 `8888888`）。
  - 播放歌曲菜单移除「转换为视频」与「开启电台」。
  - 账号与集成页面移除 Discord 与 Scrobbling（Last.fm / ListenBrainz）并停用后台相关服务。
  - `AndroidManifest.xml` 开启 `usesCleartextTraffic="true"` 以支持局域网自建 HTTP/WS 一起听服务端。
