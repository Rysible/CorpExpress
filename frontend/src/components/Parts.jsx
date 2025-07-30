import React, { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import { getParts } from '../services/ApiService';
import './Parts.css';

export default function Parts() {
    const [parts, setParts] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const fetchedParts = await getParts();
                setParts(fetchedParts);
            } catch (error) {
                console.error('Error fetching parts:', error);
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
                        Parts
                    </li>
                </ol>
            </nav>

            <h1>Parts</h1>
            <table className="table table-striped parts-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cost</th>
                        <th>Supplier</th>
                    </tr>
                </thead>
                <tbody>
                    {parts.map(part => (
                        <tr key={part.id}>
                            <td>{part.id}</td>
                            <td>${part.cost.toFixed(2)}</td>
                            <td>{part.company}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
