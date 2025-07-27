import React, { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import { getOrders } from '../services/ApiService';
import './Orders.css';

export default function Orders() {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const fetchedOrders = await getOrders();
                setOrders(fetchedOrders);
            } catch (error) {
                console.error('Error fetching orders:', error);
            }
        }

        fetchData();
    }, []);

    return (
        <div className="page-container">
            <nav aria-label="breadcrumb">
                <ol className="breadcrumb">
                    <li className="breadcrumb-item">
                        <NavLink to="/">Home</NavLink>
                    </li>
                    <li className="breadcrumb-item active" aria-current="page">
                        Orders
                    </li>
                </ol>
            </nav>

            <h1>Orders</h1>
            <table className="table table-striped orders-table">
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
                    {orders.map(order => (
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
}