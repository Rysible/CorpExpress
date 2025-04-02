import { Link } from "react-router-dom";
import "./Header.css"; // Ensure you have this CSS file

const Header = () => {
    return (
        <nav className="navbar">
            <div className="logo">
                <Link to="/">CorpExpress</Link>
            </div>
            <div className="nav-buttons">
                <Link to="/contacts" className="nav-btn">Contacts</Link>
                <Link to="/companies" className="nav-btn">Companies</Link>
                <Link to="/orders" className="nav-btn">Orders</Link>
                <Link to="/parts" className="nav-btn">Parts</Link>
                <Link to="/reports" className="nav-btn">Reports</Link>
            </div>
        </nav>
    );
};

export default Header;