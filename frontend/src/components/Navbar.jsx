import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import './Navbar.css'

export default function Navbar({ user }) {
    const [open, setOpen] = useState(false)
    const navigate = useNavigate()

    return (
        <nav className="navbar">
            <div className="nav-logo">DEV<span>BADGES</span></div>

            <div className="nav-right">
                <div className="streak-pill">
                    🔥 <span>{user?.streak ?? 0}</span>
                </div>

                <div className="xp-pill">
                    ⚡ <span>{user?.xp ?? 0} XP</span>
                </div>

                <div className="level-pill">
                    LVL <span>{user?.level ?? 0}</span>
                </div>

                <div className="profile-wrap">
                    <div className="avatar" onClick={() => setOpen(!open)}>
                        <img src={user?.avatar_url} alt="avatar" onError={(e) => e.target.style.display='none'} />
                        <div className="level-ring">{user?.level ?? 0}</div>
                    </div>

                    {open && (
                        <div className="dropdown">
                            <div className="dropdown-user">
                                <span className="dropdown-name">{user?.username ?? 'Developer'}</span>
                                <span className="dropdown-tag">Level {user?.level ?? 0} Dev</span>
                            </div>
                            <div className="dropdown-divider" />
                            <button className="dropdown-item" onClick={() => { navigate('/badges'); setOpen(false) }}>
                                🏆 My Badges
                            </button>
                            <button className="dropdown-item" onClick={() => { navigate('/dashboard'); setOpen(false) }}>
                                ⚔️ Dashboard
                            </button>
                            <div className="dropdown-divider" />
                            <button className="dropdown-item danger" onClick={() => navigate('/')}>
                                ↩ Logout
                            </button>
                        </div>
                    )}
                </div>
            </div>
        </nav>
    )
}