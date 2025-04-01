import { Link } from "react-router-dom";

const Header = () => {
    return (
        <nav className="navbar">
            <div className="logo">
                <Link to="/">CorpExpress</Link>
            </div>
            <ul className="nav-links">
                <li><Link to="/contacts">Contacts</Link></li>
                <li><Link to="/companies">Companies</Link></li>
                <li><Link to="/orders">Orders</Link></li>
                <li><Link to="/parts">Parts</Link></li>
                <li><Link to="/reports">Reports</Link></li>
            </ul>
        </nav>
    );
};

export default Header;