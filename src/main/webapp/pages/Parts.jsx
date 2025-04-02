import { useState, useEffect } from "react";
import "./Parts.css";

const Parts = () => {
    const [parts, setParts] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/parts")
            .then((response) => response.json())
            .then((data) => setParts(data))
            .catch((error) => console.error("Error fetching parts:", error));
    }, []);

    return (
        <div className="page-container">
            <h1>Parts</h1>
            <table className="parts-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cost</th>
                        <th>Supplier</th>
                    </tr>
                </thead>
                <tbody>
                    {parts.map((part) => (
                        <tr key={part.id}>
                            <td>{part.id}</td>
                            <td>${part.cost.toFixed(2)}</td>
                            <td>{part.supplier}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Parts;