import React, { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import { getCompanies } from '../services/ApiService';
import './Companies.css';

export default function Companies() {
    const [companies, setCompanies] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const fetchedCompanies = await getCompanies();
                setCompanies(fetchedCompanies);
            } catch (error) {
                console.error('Error fetching companies:', error);
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
                        Companies
                    </li>
                </ol>
            </nav>

            <h1>Companies</h1>
            <table className="table table-striped companies-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Company Name</th>
                        <th>Address</th>
                    </tr>
                </thead>
                <tbody>
                    {companies.map(company => (
                        <tr key={company.id}>
                            <td>{company.id}</td>
                            <td>{company.name}</td>
                            <td>{company.address}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
