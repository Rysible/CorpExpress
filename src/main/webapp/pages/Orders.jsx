import { useState, useEffect } from "react";
import "./Orders.css";

const Orders = () => {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/orders")
            .then((response) => response.json())
            .then((data) => setOrders(data))
            .catch((error) => console.error("Error fetching orders:", error));
    }, []);

    return (
        <div className="page-container">
            <h1>Orders</h1>
            <table className="orders-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Date</th>
                        <th>Previous File</th>
                        <th>Machine Used</th>
                        <th>Award Name</th>
                        <th>Shipping Cost</th>
                        <th>Retail Price</th>
                    </tr>
                </thead>
                <tbody>
                    {orders.map((order) => (
                        <tr key={order.id}>
                            <td>{order.id}</td>
                            <td>{new Date(order.dateOfOrder).toLocaleDateString()}</td>
                            <td>{order.previousFileName}</td>
                            <td>{order.machineUsed}</td>
                            <td>{order.awardName}</td>
                            <td>${order.shippingCost.toFixed(2)}</td>
                            <td>${order.retailPrice.toFixed(2)}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Orders;