import { useEffect, useState } from "react";
import "./Contacts.css";

const Contacts = () => {
    const [contacts, setContacts] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/contacts")
            .then(response => response.json())
            .then(data => setContacts(data))
            .catch(error => console.error("Error fetching contacts:", error));
    }, []);

    return (
        <div className="contacts-container">
            <h1>Contact List</h1>
            <table>
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
};

export default Contacts;