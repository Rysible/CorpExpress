import axios from "axios";

const baseURL = process.env.REACT_APP_API_BASE_URL;

const apiUrl = `${baseURL}/api/products`;

const ordersUrl = `${baseURL}/api/orders`;
const contactsUrl = `${baseURL}/api/contacts`;
const companiesUrl = `${baseURL}/api/companies`;


export const getProducts = async () => {
  try {
    const response = await axios.get(apiUrl);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const createProduct = async (product) => {
  try {
    const response = await axios.post(apiUrl, product);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const getProductById = async (id) => {
  try {
    const response = await axios.get(`${apiUrl}/${id}`);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const updateProductById = async (id, product) => {
  try {
    const response = await axios.put(`${apiUrl}/${id}`, product);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const deleteProductById = async (id) => {
  try {
    const response = await axios.delete(`${apiUrl}/${id}`);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export async function getOrders() {
  const response = await fetch(`${ordersUrl}`);
  if (!response.ok) {
    throw new Error("Failed to fetch orders");
  }
  return await response.json();
}

export async function getContacts() {
  const response = await fetch(`${baseURL}/api/contacts`);
  if (!response.ok) {
    throw new Error("Failed to fetch contacts");
  }
  return await response.json();
}

export async function getCompanies() {
  const response = await fetch(`${baseURL}/api/companies`);
  if (!response.ok) {
    throw new Error("Failed to fetch companies");
  }
  return await response.json();
}

export async function getParts() {
  const response = await fetch(`${baseURL}/api/parts`);
  if (!response.ok) {
    throw new Error("Failed to fetch parts");
  }
  return await response.json();
}


export const createOrder = async (order) => {
  const response = await fetch(`${ordersUrl}/add`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(order),
  });
  if (!response.ok) throw new Error("Failed to create order");
  return await response.json();
};

export const createContact = async (contact) => {
  const response = await fetch(contactsUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(contact),
  });
  if (!response.ok) throw new Error("Failed to create contact");
  return await response.json();
};

export const createCompany = async (company) => {
  const response = await fetch(companiesUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(company),
  });
  if (!response.ok) throw new Error("Failed to create company");
  return await response.json();
};