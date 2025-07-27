import { useState } from "react";
import "./AddOrder.css";

const AddOrder = () => {
    const [formData, setFormData] = useState({
        contactFirstName: "",
        contactLastName: "",
        contactEmail: "",
        contactPhone: "",
        companyName: "",
        companyAddress: "",
        machineUsed: "",
        awardName: "",
        shippingCost: "",
        retailPrice: "",
        parts: [{ partSupplier: "", partCost: "" }],
    });

    const handleChange = (e, index = null) => {
        const { name, value } = e.target;

        if (index !== null) {
            const updatedParts = [...formData.parts];
            updatedParts[index][name] = value;
            setFormData({ ...formData, parts: updatedParts });
        } else {
            setFormData({ ...formData, [name]: value });
        }
    };

    const addPart = () => {
        setFormData({ ...formData, parts: [...formData.parts, { partSupplier: "", partCost: "" }] });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch("http://localhost:8080/api/orders/add", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                alert("Order added successfully!");
                setFormData({
                    contactFirstName: "",
                    contactLastName: "",
                    contactEmail: "",
                    contactPhone: "",
                    companyName: "",
                    companyAddress: "",
                    machineUsed: "",
                    awardName: "",
                    shippingCost: "",
                    retailPrice: "",
                    parts: [{ partSupplier: "", partCost: "" }],
                });
            } else {
                alert("Error adding order.");
            }
        } catch (error) {
            console.error("Error submitting form:", error);
        }
    };

    return (
        <div className="order-container">
            <h1 className="page-title">Add New Order</h1>
            <form onSubmit={handleSubmit} className="order-form">
                <h2>Contact Information</h2>
                <div className="form-group">
                    <input type="text" name="contactFirstName" placeholder="First Name" value={formData.contactFirstName} onChange={handleChange} required />
                    <input type="text" name="contactLastName" placeholder="Last Name" value={formData.contactLastName} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <input type="email" name="contactEmail" placeholder="Email" value={formData.contactEmail} onChange={handleChange} required />
                    <input type="text" name="contactPhone" placeholder="Phone Number" value={formData.contactPhone} onChange={handleChange} required />
                </div>

                <h2>Company Details</h2>
                <div className="form-group">
                    <input type="text" name="companyName" placeholder="Company Name" value={formData.companyName} onChange={handleChange} required />
                    <input type="text" name="companyAddress" placeholder="Company Address" value={formData.companyAddress} onChange={handleChange} required />
                </div>

                <h2>Order Details</h2>
                <div className="form-group">
                    <input type="text" name="machineUsed" placeholder="Machine Used" value={formData.machineUsed} onChange={handleChange} required />
                    <input type="text" name="awardName" placeholder="Award Name" value={formData.awardName} onChange={handleChange} required />
                </div>
                <div className="form-group">
                    <input type="number" name="shippingCost" placeholder="Shipping Cost" value={formData.shippingCost} onChange={handleChange} required />
                    <input type="number" name="retailPrice" placeholder="Retail Price" value={formData.retailPrice} onChange={handleChange} required />
                </div>

                <h2>Parts</h2>
                {formData.parts.map((part, index) => (
                    <div key={index} className="form-group">
                        <input type="text" name="partSupplier" placeholder="Part Supplier" value={part.partSupplier} onChange={(e) => handleChange(e, index)} required />
                        <input type="number" name="partCost" placeholder="Part Cost" value={part.partCost} onChange={(e) => handleChange(e, index)} required />
                    </div>
                ))}
                <button type="button" className="add-part-btn" onClick={addPart}>+ Add Another Part</button>

                <button type="submit" className="submit-btn">Submit Order</button>
            </form>
        </div>
    );
};

export default AddOrder;
