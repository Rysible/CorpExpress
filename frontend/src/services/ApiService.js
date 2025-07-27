import axios from "axios";

const baseURL = process.env.REACT_APP_API_BASE_URL;

const apiUrl = `${baseURL}/api/products`;

export const getProducts = async () => {
  try {
    const response = await axios.get(apiUrl);
    return response.data;
  } catch (error) {
    throw error;
  }
}

export const createProduct = async (product) => {
  try {
    const response = await axios.post(apiUrl, product);
    return response.data;
  } catch (error) {
    throw error;
  }
}

export const getProductById = async (id) => {
  try {
    const response = await axios.get(`${apiUrl}/${id}`);
    return response.data;
  } catch (error) {
    throw error;
  }
}

export const updateProductById = async (id, product) => {
  try {
    const response = await axios.put(`${apiUrl}/${id}`, product);
    return response.data;
  } catch (error) {
    throw error;
  }
}

export const deleteProductById = async (id) => {
  try {
    const response = await axios.delete(`${apiUrl}/${id}`);
    return response.data;
  } catch (error) {
    throw error;
  }
}

export async function getOrders() {
  const response = await fetch('http://localhost:8080/api/orders');
  if (!response.ok) {
    throw new Error('Failed to fetch orders');
  }
  return await response.json();
}

export async function getContacts() {
  const response = await fetch('http://localhost:8080/api/contacts');
  if (!response.ok) {
    throw new Error('Failed to fetch contacts');
  }
  return await response.json();
}

export async function getCompanies() {
  const response = await fetch('http://localhost:8080/api/companies');
  if (!response.ok) {
    throw new Error('Failed to fetch companies');
  }
  return await response.json();
}

export async function getParts() {
  const response = await fetch('http://localhost:8080/api/parts');
  if (!response.ok) {
    throw new Error('Failed to fetch parts');
  }
  return await response.json();
}
