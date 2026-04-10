import { useState, useEffect } from 'react'
import axios from 'axios'
import Navbar from '../components/Navbar'
import './Badges.css'

const API = 'http://localhost:8080'
const USER_ID = 1

const BADGE_ICONS = {
    'DSA': '⚔️', 'SQL': '🗄️', 'System Design': '🏗️',
    'default': '🏆'
}

export default function Badges() {
    const [user, setUser] = useState(null)
    const [badges, setBadges] = useState([])
    const [copied, setCopied] = useState(false)

    useEffect(() => {
        Promise.all([
            axios.get(`${API}/api/users/${USER_ID}`),
            axios.get(`${API}/api/badges/${USER_ID}`)
        ]).then(([userRes, badgesRes]) => {
            setUser(userRes.data)
            setBadges(badgesRes.data)
        })
    }, [])

    const embedCode = `![DevBadges](http://localhost:8080/api/card/${user?.username})`

    const copyEmbed = () => {
        navigator.clipboard.writeText(embedCode)
        setCopied(true)
        setTimeout(() => setCopied(false), 2000)
    }

    return (
        <div className="badges-page">
            <Navbar user={user} />

            <div className="badges-body">
                <div className="badges-header">
                    <h1 className="badges-title">ACHIEVEMENTS</h1>
                    <p className="badges-sub">{badges.length} badge{badges.length !== 1 ? 's' : ''} earned</p>
                </div>

                {/* Embed Section */}
                <div className="embed-panel">
                    <div className="embed-panel-header">
                        <span className="embed-title">📋 GITHUB README EMBED</span>
                        <span className="embed-hint">Paste this in your GitHub profile README</span>
                    </div>
                    <div className="embed-code-wrap">
                        <code className="embed-code">{embedCode}</code>
                        <button className={`copy-btn ${copied ? 'copied' : ''}`} onClick={copyEmbed}>
                            {copied ? '✓ Copied!' : 'Copy'}
                        </button>
                    </div>
                </div>

                {/* Badges Grid */}
                {badges.length === 0 ? (
                    <div className="empty-badges">
                        <div className="empty-icon">🔒</div>
                        <div className="empty-title">No badges yet</div>
                        <div className="empty-sub">Complete tasks and maintain streaks to unlock achievements</div>
                    </div>
                ) : (
                    <div className="badges-grid">
                        {badges.map((ub) => (
                            <div key={ub.user_badge_id} className="badge-card">
                                <div className="badge-glow" />
                                <div className="badge-icon">
                                    {BADGE_ICONS[ub.badge?.required_task_type] ?? BADGE_ICONS.default}
                                </div>
                                <div className="badge-name">{ub.badge?.name}</div>
                                <div className="badge-desc">{ub.badge?.description}</div>
                                <div className="badge-earned">
                                    Earned {new Date(ub.earned_on).toLocaleDateString('en-US', {
                                    month: 'short', day: 'numeric', year: 'numeric'
                                })}
                                </div>
                                <div className="badge-requirements">
                                    {ub.badge?.required_level > 0 && <span>LVL {ub.badge.required_level}</span>}
                                    {ub.badge?.required_streak > 0 && <span>🔥 {ub.badge.required_streak}d</span>}
                                    {ub.badge?.required_task_count > 0 && <span>{ub.badge.required_task_count} tasks</span>}
                                </div>
                            </div>
                        ))}
                    </div>
                )}
            </div>
        </div>
    )
}