import { useState, useEffect } from 'react'
import axios from 'axios'
import Navbar from '../components/Navbar'
import './Dashboard.css'

const API = 'http://localhost:8080'


const params = new URLSearchParams(window.location.search)
const USER_ID = params.get('userId') ?? 1

export default function Dashboard() {
    const [user, setUser] = useState(null)
    const [tasks, setTasks] = useState([])
    const [completed, setCompleted] = useState(new Set())
    const [loading, setLoading] = useState(true)
    const [completing, setCompleting] = useState(null)

    useEffect(() => {
        Promise.all([
            axios.get(`${API}/api/users/${USER_ID}`),
            axios.get(`${API}/api/tasks`)
        ]).then(([userRes, tasksRes]) => {
            setUser(userRes.data)
            setTasks(tasksRes.data)
            setLoading(false)
        }).catch(() => setLoading(false))
    }, [])

    const handleComplete = async (task) => {
        if (completed.has(task.task_id) || completing === task.task_id) return

        setCompleting(task.task_id)
        const today = new Date().toISOString().split('T')[0]

        try {
            await axios.post(`${API}/api/tasks?taskId=${task.task_id}&userId=${USER_ID}&completedOn=${today}`)
            setCompleted(prev => new Set([...prev, task.task_id]))

            // refresh user data
            const userRes = await axios.get(`${API}/api/users/${USER_ID}`)
            setUser(userRes.data)
        } catch (e) {
            console.error(e)
        } finally {
            setCompleting(null)
        }
    }

    const xpToNext = ((user?.level ?? 0) + 1) * 100
    const xpProgress = user ? Math.min((user.xp % 100) / 100 * 100, 100) : 0

    if (loading) return (
        <div className="loading-screen">
            <div className="loading-text">INITIALIZING<span className="blink">_</span></div>
        </div>
    )

    return (
        <div className="dashboard">
            <Navbar user={user} />

            <div className="dashboard-body">
                {/* Welcome + XP Bar */}
                <div className="welcome-section">
                    <div>
                        <h1 className="welcome-title">
                            Welcome back, <span>{user?.username ?? 'Developer'}</span>
                        </h1>
                        <p className="welcome-sub">Complete today's missions. Earn XP. Level up.</p>
                    </div>

                    <div className="xp-section">
                        <div className="xp-bar-labels">
                            <span>{user?.xp ?? 0} XP</span>
                            <span>Next level: {xpToNext} XP</span>
                        </div>
                        <div className="xp-bar-bg">
                            <div className="xp-bar-fill" style={{ width: `${xpProgress}%` }} />
                        </div>
                    </div>
                </div>

                {/* Stats Row */}
                <div className="stats-row">
                    <div className="stat-card green">
                        <div className="stat-card-icon">⚡</div>
                        <div className="stat-card-val">{user?.xp ?? 0}</div>
                        <div className="stat-card-label">Total XP</div>
                    </div>
                    <div className="stat-card blue">
                        <div className="stat-card-icon">🎯</div>
                        <div className="stat-card-val">{user?.level ?? 0}</div>
                        <div className="stat-card-label">Level</div>
                    </div>
                    <div className="stat-card red">
                        <div className="stat-card-icon">🔥</div>
                        <div className="stat-card-val">{user?.streak ?? 0}</div>
                        <div className="stat-card-label">Day Streak</div>
                    </div>
                    <div className="stat-card gold">
                        <div className="stat-card-icon">✅</div>
                        <div className="stat-card-val">{completed.size}</div>
                        <div className="stat-card-label">Done Today</div>
                    </div>
                </div>

                {/* Task Table */}
                <div className="task-panel">
                    <div className="task-panel-header">
                        <span className="task-panel-title">DAILY MISSIONS</span>
                        <span className="task-panel-count">{completed.size}/{tasks.length} completed</span>
                    </div>

                    <div className="task-table">
                        <div className="task-table-head">
                            <span></span>
                            <span>Task</span>
                            <span>Type</span>
                            <span>Subtype</span>
                            <span>XP</span>
                        </div>

                        {tasks.map((task) => {
                            const isDone = completed.has(task.task_id)
                            const isLoading = completing === task.task_id
                            return (
                                <div
                                    key={task.task_id}
                                    className={`task-row ${isDone ? 'done' : ''}`}
                                    onClick={() => handleComplete(task)}
                                >
                                    <div className={`task-check ${isDone ? 'checked' : ''}`}>
                                        {isDone ? '✓' : isLoading ? '⟳' : ''}
                                    </div>
                                    <span className="task-desc">{task.description}</span>
                                    <span className="task-type">{task.type}</span>
                                    <span className="task-subtype">{task.subtype}</span>
                                    <span className="task-xp">+{task.xp_reward}</span>
                                </div>
                            )
                        })}
                    </div>
                </div>
            </div>
        </div>
    )
}