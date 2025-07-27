import React, { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import { getContacts } from '../services/ApiService';
import './Contacts.css';

export default function Contacts() {
    const [contacts, setContacts] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const fetchedContacts = await getContacts();
                setContacts(fetchedContacts);
            } catch (error) {
                console.error('Error fetching contacts:', error);
            }
        }

        fetchData();
    }, []);

    return (
        <div className="contacts-container">
            <nav aria-label="breadcrumb">
                <ol className="breadcrumb">
                    <li className="breadcrumb-item">
                        <NavLink to="/">Home</NavLink>
                    </li>
                    <li className="breadcrumb-item active" aria-current="page">
                        Contacts
                    </li>
                </ol>
            </nav>

            <h1>Contact List</h1>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Title</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                </thead>
                <tbody>
                    {contacts.map(contact => (
                        <tr key={contact.contactPersonKey}>
                            <td>{contact.firstName} {contact.lastName}</td>
                            <td>{contact.title}</td>
                            <td>{contact.emailAddress}</td>
                            <td>{contact.phoneNumber}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}