import 'bootstrap/dist/css/bootstrap.min.css';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import './App.css';
import AddOrder from "./components/AddOrder";
import Companies from "./components/Companies"; 
import Contacts from "./components/Contacts";
import CreateProductForm from './components/CreateProductForm';
import Header from "./components/Header";
import Home from "./components/Home";
import NavBar from "./components/NavBar";
import Orders from "./components/Orders"; 
import Parts from "./components/Parts"; 
import ProductDetail from "./components/ProductDetail";
import Reports from "./components/Reports"; 
import UpdateProductForm from './components/UpdateProductForm';
import { ProductListProvider } from "./context/ProductContext";

function App() {
  return (
    <Router>
      <ProductListProvider>
        <div className="container">
          <NavBar />
          <hr />
          <Header />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/new" element={<CreateProductForm />} />
            <Route path="/:id" element={<ProductDetail />} />
            <Route path="/:id/edit" element={<UpdateProductForm />} />

            <Route path="/contacts" element={<Contacts />} />
            <Route path="/reports" element={<Reports />} />
            <Route path="/orders" element={<Orders />} />
            <Route path="/companies" element={<Companies />} />
            <Route path="/parts" element={<Parts />} />
            <Route path="/addorder" element={<AddOrder />} />
          </Routes>
        </div>
      </ProductListProvider>
    </Router >
  );
}

export default App;
