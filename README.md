<div align="center">

```
██████╗ ███████╗██╗   ██╗██████╗  █████╗ ██████╗  ██████╗ ███████╗███████╗
██╔══██╗██╔════╝██║   ██║██╔══██╗██╔══██╗██╔══██╗██╔════╝ ██╔════╝██╔════╝
██║  ██║█████╗  ██║   ██║██████╔╝███████║██║  ██║██║  ███╗█████╗  ███████╗
██║  ██║██╔══╝  ╚██╗ ██╔╝██╔══██╗██╔══██║██║  ██║██║   ██║██╔══╝  ╚════██║
██████╔╝███████╗ ╚████╔╝ ██████╔╝██║  ██║██████╔╝╚██████╔╝███████╗███████║
╚═════╝ ╚══════╝  ╚═══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚══════╝╚══════╝
```

### ⚡ `TRACK` · `EARN` · `FLEX` ⚡

*The Developer Achievement System — Earn Badges. Level Up. Show Off on GitHub.*

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/W7W31XIH60)

---

![Made with Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![GitHub OAuth](https://img.shields.io/badge/GitHub%20OAuth-181717?style=for-the-badge&logo=github&logoColor=white)
![Java](https://img.shields.io/badge/Java%2021-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

---

> ![Status](https://img.shields.io/badge/STATUS-UNDER%20ACTIVE%20DEVELOPMENT-ff4d6d?style=for-the-badge&labelColor=0d0f18)
>
> ⚠️ **THIS PROJECT IS CURRENTLY IN BUILDING STAGE** ⚠️
>
> *Features may be incomplete. Deployment in progress. Come back soon.*

</div>

---

## ◈ WHAT IS DEVBADGES?

> **DevBadges** is a gamified developer achievement platform. Complete daily DSA and SQL challenges, earn XP, level up, and unlock badges that can be embedded directly into your **GitHub profile README** — just like a Spotify widget, but for your grind.

No more empty GitHub profiles. No more untracked progress. Every problem you solve, every streak you maintain, **becomes a badge the world can see.**

```markdown
<!-- Drop this in your GitHub README -->
![DevBadges](https://devbadges.app/api/card/your-username)
```

> **One line. Your entire dev journey — displayed on your profile.**

---

## ◈ THE GAME LOOP

```
┌─────────────────────────────────────────────────────────────────┐
│                                                                 │
│   LOGIN WITH GITHUB                                             │
│         │                                                       │
│         ▼                                                       │
│   DAILY MISSION BOARD  ──────────────────────────────────────┐ │
│   • Solve a DSA Problem       [DSA / Two Pointers]   +50 XP  │ │
│   • Complete SQL Challenge    [SQL / Joins]           +40 XP  │ │
│   • System Design Read        [Design / Basics]       +30 XP  │ │
│         │                                                    │ │
│         ▼                                                    │ │
│    XP EARNED ──► LEVEL UP ──► STREAK MAINTAINED ◄───────────┘ │
│         │                                                       │
│         ▼                                                       │
│    BADGE UNLOCKED  🏆                                           │
│         │                                                       │
│         ▼                                                       │
│    EMBED ON GITHUB  ──► FLEX ON THE WORLD  🌍                   │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

---

## ◈ BADGE SYSTEM

Badges are not handed out. They are **earned** through consistent effort.

| 🏆 Badge | Unlock Condition | Rarity |
|---------|-----------------|--------|
| 🔥 **Streak Warrior** | 7-day consecutive streak | Common |
| ⚔️ **Array Slayer** | Complete 10 Array problems | Common |
| 🌀 **DP Learner** | Complete 10 Dynamic Programming problems | Rare |
| 🧠 **Query Wizard** | Complete 15 SQL challenges | Rare |
| 💎 **Two Pointer Pro** | Master Two Pointer pattern | Epic |
| 🚀 **Level 5 Dev** | Reach Level 5 | Epic |
| 👑 **Elite Coder** | 30-day streak + Level 10 | Legendary |
| 🌟 **Full Stack Initiate** | Complete all task types | Legendary |

> Badges are **dynamic SVG cards** generated in real time. Every time someone visits your GitHub profile, your latest achievements are fetched live from the server.

---

## ◈ TECH STACK — THE ARSENAL

```
╔══════════════════╦═══════════════════════════════════════════════╗
║ LAYER            ║ TECHNOLOGY                                    ║
╠══════════════════╬═══════════════════════════════════════════════╣
║ Frontend         ║ React + Vite + CSS Variables                  ║
║ Backend          ║ Java 21 + Spring Boot 3.5                     ║
║ Database         ║ PostgreSQL 17                                 ║
║ ORM              ║ Spring Data JPA + Hibernate                   ║
║ Auth             ║ GitHub OAuth 2.0 + Spring Security            ║
║ Build Tool       ║ Gradle (Groovy)                               ║
║ Card Engine      ║ Dynamic SVG Generation                        ║
║ Deployment       ║ Render (Backend) + Vercel (Frontend)          ║
╚══════════════════╩═══════════════════════════════════════════════╝
```

---

## ◈ PROJECT ARCHITECTURE

```
Devbadges/                               ── Monorepo Root
│
├── 📁 backend/                          ── Spring Boot Application
│   └── 📁 src/main/java/com/devbadges/
│       ├── 📁 controller/               ── API endpoints (REST)
│       │   ├── AuthController           ── GitHub OAuth flow
│       │   ├── UserController           ── User profile endpoints
│       │   ├── TaskController           ── Task fetch + completion
│       │   └── BadgeController          ── Badge fetch endpoints
│       │
│       ├── 📁 service/                  ── Business logic layer
│       │   ├── UserService              ── User CRUD operations
│       │   ├── TaskService              ── Task completion + chain trigger
│       │   ├── ProgressService          ── XP, Level, Streak engine
│       │   └── BadgeService             ── Badge unlock conditions
│       │
│       ├── 📁 repository/               ── Database queries (Spring Data JPA)
│       │   ├── UserRepository
│       │   ├── TaskRepository
│       │   ├── TaskCompletionRepository
│       │   ├── BadgeRepository
│       │   └── UserBadgeRepository
│       │
│       ├── 📁 entity/                   ── Database table mappings (Hibernate)
│       │   ├── User
│       │   ├── Task
│       │   ├── TaskCompletion
│       │   ├── Badge
│       │   └── UserBadge
│       │
│       └── 📁 config/                   ── Spring Security + CORS config
│           └── SecurityConfig
│
└── 📁 frontend/                         ── React Application (Vite)
    └── 📁 src/
        ├── 📁 pages/                    ── Full page views
        │   ├── Login.jsx                ── GitHub OAuth login screen
        │   ├── Login.css                ── Login page styles
        │   ├── Dashboard.jsx            ── Daily missions + XP + stats HUD
        │   ├── Dashboard.css            ── Dashboard styles + stat cards
        │   ├── Badges.jsx               ── Earned badges + embed code
        │   └── Badges.css               ── Badge grid + embed panel styles
        │
        ├── 📁 components/               ── Reusable UI components
        │   ├── Navbar.jsx               ── Top nav: streak pill, XP pill,
        │   │                               level pill, avatar + dropdown
        │   └── Navbar.css               ── Navbar + dropdown styles
        │
        ├── App.jsx                      ── Route definitions (react-router-dom)
        ├── App.css                      ── Global CSS vars + grid background
        └── main.jsx                     ── React entry point
```

---

## ◈ FRONTEND DESIGN SYSTEM

The UI is built around a **Game HUD aesthetic** — dark cockpit, neon glows, developer war room.

```
╔══════════════════╦═══════════════════════════════════════════════╗
║ CSS TOKEN        ║ VALUE + USAGE                                 ║
╠══════════════════╬═══════════════════════════════════════════════╣
║ --bg             ║ #06070c  → page background                    ║
║ --panel          ║ #0d0f18  → card / component background        ║
║ --border         ║ #1c1f2e  → subtle borders                     ║
║ --green          ║ #00ff87  → XP, success, streak alive          ║
║ --blue           ║ #00cfff  → level, type labels, info           ║
║ --gold           ║ #ffd93d  → badges, achievements, XP bar       ║
║ --red            ║ #ff4d6d  → streak broken, danger states       ║
║ --purple         ║ #c77dff  → subtype labels, accents            ║
║ --font-display   ║ Orbitron → HUD numbers, headings, labels      ║
║ --font-body      ║ JetBrains Mono → body text, task descriptions ║
╚══════════════════╩═══════════════════════════════════════════════╝
```

**Pages at a glance —**

```
┌─────────────────────────────────────────────────────────────┐
│  LOGIN PAGE                                                 │
│  · Centered glowing card                                    │
│  · ASCII-style DEVBADGES logo                               │
│  · GitHub OAuth CTA button (neon green)                     │
│  · Stats: ∞ Tasks · 50+ Badges · 100% Free                 │
├─────────────────────────────────────────────────────────────┤
│  DASHBOARD                                                  │
│  · Sticky navbar → streak 🔥 / XP ⚡ / level / avatar      │
│  · Welcome header + XP progress bar                         │
│  · 4 stat cards → Total XP / Level / Streak / Done Today    │
│  · Mission table → task / type / subtype / XP reward        │
│  · Click task → completes it → XP updates live             │
├─────────────────────────────────────────────────────────────┤
│  BADGES PAGE                                                │
│  · Earned badge grid with glow effects                      │
│  · Each badge → name / description / requirements           │
│  · Embed code panel → one-click copy for GitHub README      │
└─────────────────────────────────────────────────────────────┘
```

---

## ◈ DATABASE SCHEMA

```
┌─────────────┐     ┌──────────────────┐     ┌──────────────┐
│   USERS     │     │ TASK_COMPLETION  │     │    TASKS     │
├─────────────┤     ├──────────────────┤     ├──────────────┤
│ user_id  PK │◄────│ user_id      FK  │     │ task_id   PK │
│ github_id   │     │ task_id      FK  │────►│ description  │
│ username    │     │ completion_id PK │     │ type         │
│ avatar_url  │     │ completed_on     │     │ subtype      │
│ xp          │     └──────────────────┘     │ xp_reward    │
│ level       │                              └──────────────┘
│ streak      │     ┌──────────────────┐
│ last_active │     │  USER_BADGES     │     ┌──────────────┐
│ has_starred │     ├──────────────────┤     │    BADGES    │
└─────────────┘     │ user_badge_id PK │     ├──────────────┤
       │            │ user_id      FK  │────►│ badge_id  PK │
       └────────────│ badge_id     FK  │     │ name         │
                    │ earned_on        │     │ description  │
                    └──────────────────┘     │ req_level    │
                                             │ req_streak   │
                                             │ req_type     │
                                             │ req_subtype  │
                                             │ req_count    │
                                             └──────────────┘
```

---

## ◈ BUSINESS LOGIC CHAIN

When a user completes a task, this chain fires automatically —

```
TaskService.completeTask()
      │
      ├── Saves TaskCompletion record to DB
      │
      └── ProgressService.updateProgress()
                │
                ├── addXP()           → user.xp += task.xp_reward
                ├── calculateLevel()  → user.level = xp / 100
                ├── updateStreak()    → compare completedOn vs lastActivityDate
                │
                └── BadgeService.checkAndAwardBadges()
                          │
                          ├── Fetch all badge definitions
                          ├── Check level threshold
                          ├── Check streak threshold
                          ├── Count task completions by subtype (JOIN query)
                          └── Save UserBadge if all conditions met
```

---

## ◈ HOW THE EMBED WORKS

```
  Your GitHub README
  ┌──────────────────────────────────────────┐
  │ ![DevBadges](https://devbadges.app/      │
  │              api/card/venomyzer)         │
  └──────────────────────────────────────────┘
              │
              │  GitHub sees an <img> tag
              │  Makes HTTP request to our server
              ▼
  ┌──────────────────────────────────────────┐
  │         SPRING BOOT SERVER               │
  │                                          │
  │  1. Receives GET /api/card/venomyzer     │
  │  2. Fetches user from PostgreSQL         │
  │  3. Fetches user's earned badges         │
  │  4. Generates SVG card dynamically       │
  │  5. Returns SVG with Content-Type        │
  └──────────────────────────────────────────┘
              │
              │  Returns a beautiful SVG image
              ▼
  ┌──────────────────────────────────────────┐
  │      VISITOR SEES ON GITHUB PROFILE      │
  │  ┌────────────────────────────────────┐  │
  │  │  venomyzer  ·  LVL 5  ·  🔥 12d   │  │
  │  │  ⚡ 1250 XP                         │  │
  │  │  🏆 DP Learner  ⚔️ Array Slayer    │  │
  │  └────────────────────────────────────┘  │
  └──────────────────────────────────────────┘
```

---

## ◈ API ENDPOINTS

```
METHOD   ENDPOINT                          DESCRIPTION
──────   ────────────────────────────────  ──────────────────────────────
GET      /auth/success                     GitHub OAuth callback
GET      /api/users/{id}                   Get user profile
POST     /api/users                        Create user
GET      /api/tasks                        Get all daily tasks
POST     /api/tasks?taskId=&userId=&date=  Complete a task
GET      /api/badges/{userId}              Get user's earned badges
GET      /api/card/{username}              Generate GitHub embed SVG card
```

---

## ◈ LOCAL SETUP — START YOUR QUEST

### Prerequisites

```bash
☑ Java 21+
☑ PostgreSQL 17+
☑ Node.js 18+
☑ GitHub OAuth App credentials
```

### GitHub OAuth App Setup

```
Homepage URL  → http://localhost:5173
Callback URL  → http://localhost:8080/login/oauth2/code/github
```

### Backend

```bash
# Clone the repo
git clone https://github.com/venomyzer/devbadges.git
cd devbadges/backend

# Create src/main/resources/application-local.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/devbadges
spring.datasource.username=YOUR_PG_USERNAME
spring.datasource.password=YOUR_PG_PASSWORD
spring.security.oauth2.client.registration.github.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_CLIENT_SECRET
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Run the server
./gradlew bootRun --args='--spring.profiles.active=local'
# Server starts at http://localhost:8080
```

### Frontend

```bash
cd ../frontend
npm install
npm run dev
# App starts at http://localhost:5173
```

### Database

```bash
psql postgres
CREATE DATABASE devbadges;
# Tables are auto-created by Hibernate on first run
```

---

## ◈ FUTURE SCOPE — UPCOMING UPDATES

```
▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░  VERSION 1.0  [CURRENT]
```

| Version | Feature | Status |
|---------|---------|--------|
| **v1.1** | 🎨 Custom SVG Card Builder — choose your card layout & theme | 🔜 Planned |
| **v1.1** | 📅 Additional Task Types — system design, projects, open source | 🔜 Planned |
| **v1.2** | 🏅 Small Milestone Badges — per task type achievements | 🔜 Planned |
| **v1.2** | ⭐ Star-to-Unlock System — star the repo to unlock dashboard | 🔜 Planned |
| **v1.3** | 🌐 Public Leaderboard — top devs by XP, streak, badges | 💡 Idea |
| **v1.3** | 👥 Developer Profiles — public profile pages per user | 💡 Idea |
| **v2.0** | 🔗 LeetCode Integration — auto-detect solved problems | 💡 Idea |
| **v2.0** | 🔗 GitHub Commits Integration — earn XP for daily commits | 💡 Idea |
| **v2.1** | 🤝 SkillSwap Platform — barter dev skills with other devs | 🚀 Next Project |
| **v2.2** | 📱 Mobile App — track progress on the go | 🔮 Future |
| **v3.0** | 🤖 AI Task Recommendations — personalized learning paths | 🔮 Future |

---

## ◈ CONTRIBUTING

```
FORK → CLONE → BRANCH → CODE → PUSH → PULL REQUEST
```

All contributions welcome. If you have an idea for a new badge type, task category, or feature — open an issue. Let's build this together.

---

## ◈ THE DEVELOPER

<div align="center">

Built from scratch in **3 days** by a developer learning Spring Boot for the first time.

*This project was built while learning — the backend, the database design,*
*the OAuth flow, the SVG generation — all of it, built for the first time.*

**That's the whole point of DevBadges.**

*Track the grind. Show the proof.*

---

```
[ GAME OVER? NAH. THIS IS JUST THE TUTORIAL LEVEL. ]
```

⭐ **Star this repo if it helped you. Every star unlocks motivation.** ⭐

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/W7W31XIH60)

</div>

---

<div align="center">

`MIT License` · Built with ☕ Java and 🔥 consistency · © 2026 DevBadges

</div>