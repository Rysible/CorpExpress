import "./Home.css";

const Home = () => {
    return (
        <div className="home-container">
            <div className="hero">
                <h1>Welcome to CorpExpress</h1>
                <p>Your trusted platform for managing orders, companies, and more.</p>
                <div className="cta-buttons">
                    <a href="/orders" className="cta-btn primary">View Orders</a>
                    <a href="/companies" className="cta-btn secondary">Explore Companies</a>
                </div>
            </div>

            <div className="features">
                <div className="feature-card">
                    <h2>Manage Contacts</h2>
                    <p>Keep track of all your important business contacts effortlessly.</p>
                </div>
                <div className="feature-card">
                    <h2>Track Orders</h2>
                    <p>Monitor the status and details of your business orders in real-time.</p>
                </div>
                <div className="feature-card">
                    <h2>Analyze Reports</h2>
                    <p>Gain insights with detailed reports and analytics.</p>
                </div>
            </div>
        </div>
    );
};

export default Home;