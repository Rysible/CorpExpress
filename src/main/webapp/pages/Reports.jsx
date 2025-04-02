import "./Reports.css";

const Reports = () => {
    return (
        <div className="reports-container">
            <h1>Business Reports</h1>

            {/* Overview Section */}
            <div className="report-cards">
                <div className="card">
                    <h2>Total Orders</h2>
                    <p>1,245</p>
                </div>
                <div className="card">
                    <h2>Total Revenue</h2>
                    <p>$325,000</p>
                </div>
                <div className="card">
                    <h2>Total Shipping Cost</h2>
                    <p>$12,450</p>
                </div>
            </div>

            {/* Orders Table */}
            <div className="report-section">
                <h2>Recent Orders</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Company</th>
                            <th>Date</th>
                            <th>Total Cost</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1001</td>
                            <td>Acme Corp</td>
                            <td>2024-03-15</td>
                            <td>$1,200</td>
                        </tr>
                        <tr>
                            <td>1002</td>
                            <td>BlueTech</td>
                            <td>2024-03-16</td>
                            <td>$980</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Reports;