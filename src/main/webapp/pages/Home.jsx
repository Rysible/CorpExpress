const Home = () => {
    return (
        <div className="home">
            <h1>Welcome to CorpExpress</h1>
            <p>Manage your orders, companies, contacts, and parts efficiently.</p>
            <div className="dashboard">
                <div className="dashboard-card">Total Orders: 120</div>
                <div className="dashboard-card">Total Companies: 50</div>
                <div className="dashboard-card">Total Contacts: 200</div>
                <div className="dashboard-card">Total Parts: 80</div>
            </div>
        </div>
    );
};

export default Home;