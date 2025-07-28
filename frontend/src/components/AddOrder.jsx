import React, { useRef, useState } from "react";
import "./AddOrder.css";
import { useNavigate } from "react-router-dom";
import { createCompany, createContact, createOrder } from "../services/ApiService";

const AddOrder = () => {
    const navigate = useNavigate();

    const contactFirstNameRef = useRef();
    const contactLastNameRef = useRef();
    const contactEmailRef = useRef();
    const contactPhoneRef = useRef();
    const companyNameRef = useRef();
    const companyAddressRef = useRef();
    const machineUsedRef = useRef();
    const awardNameRef = useRef();
    const shippingCostRef = useRef();
    const retailPriceRef = useRef();

    const [_, setForceUpdate] = useState(0);
    const partsRefs = useRef([
        { partSupplier: React.createRef(), partCost: React.createRef() }
    ]);

    const addPart = () => {
        partsRefs.current.push({
            partSupplier: React.createRef(),
            partCost: React.createRef()
        });
        setForceUpdate((n) => n + 1);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            // Create contact first
            const contact = {
                firstName: contactFirstNameRef.current.value,
                lastName: contactLastNameRef.current.value,
                email: contactEmailRef.current.value,
                phone: contactPhoneRef.current.value
            };
            const savedContact = await createContact(contact);

            // Create company
            const company = {
                name: companyNameRef.current.value,
                address: companyAddressRef.current.value
            };
            const savedCompany = await createCompany(company);

            // Collect parts
            const parts = partsRefs.current.map((refs) => ({
                partSupplier: refs.partSupplier.current.value,
                partCost: parseFloat(refs.partCost.current.value)
            }));

            // Create order using contact + company IDs
            const newOrder = {
                machineUsed: machineUsedRef.current.value,
                awardName: awardNameRef.current.value,
                shippingCost: parseFloat(shippingCostRef.current.value),
                retailPrice: parseFloat(retailPriceRef.current.value),
                contact: { id: savedContact.id },
                company: { id: savedCompany.id },
                parts
            };

            const response = await createOrder(newOrder);
            alert("Order added successfully!");
            navigate(`/orders/${response.id}`);
        } catch (error) {
            console.error("Error creating order:", error);
            alert("Error adding order.");
        }
    };

    return (
        <div className="order-container">
            <h1 className="page-title">Add New Order</h1>
            <form onSubmit={handleSubmit} className="order-form">
                <h2>Contact Information</h2>
                <div className="form-group">
                    <input ref={contactFirstNameRef} type="text" placeholder="First Name" required />
                    <input ref={contactLastNameRef} type="text" placeholder="Last Name" required />
                </div>
                <div className="form-group">
                    <input ref={contactEmailRef} type="email" placeholder="Email" required />
                    <input ref={contactPhoneRef} type="text" placeholder="Phone Number" required />
                </div>

                <h2>Company Details</h2>
                <div className="form-group">
                    <input ref={companyNameRef} type="text" placeholder="Company Name" required />
                    <input ref={companyAddressRef} type="text" placeholder="Company Address" required />
                </div>

                <h2>Order Details</h2>
                <div className="form-group">
                    <input ref={machineUsedRef} type="text" placeholder="Machine Used" required />
                    <input ref={awardNameRef} type="text" placeholder="Award Name" required />
                </div>
                <div className="form-group">
                    <input ref={shippingCostRef} type="number" placeholder="Shipping Cost" required />
                    <input ref={retailPriceRef} type="number" placeholder="Retail Price" required />
                </div>

                <h2>Parts</h2>
                {partsRefs.current.map((refPair, index) => (
                    <div key={index} className="form-group">
                        <input ref={refPair.partSupplier} type="text" placeholder="Part Supplier" required />
                        <input ref={refPair.partCost} type="number" placeholder="Part Cost" required />
                    </div>
                ))}
                <button type="button" className="add-part-btn" onClick={addPart}>+ Add Another Part</button>

                <button type="submit" className="submit-btn">Submit Order</button>
            </form>
        </div>
    );
};

export default AddOrder;
