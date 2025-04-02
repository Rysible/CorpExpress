import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Home from "./pages/Home";
import Contacts from "./pages/Contacts";
import Reports from "./pages/Reports"; // Add this if you have a reports page
import Orders from "./pages/Orders"; // Add this if you have an orders page
import Companies from "./pages/Companies"; // Add this if you have a companies page
import Parts from "./pages/Parts"; // Add this if you have a parts page

const App = () => {
    return (
        <Router>
            <Header />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/contacts" element={<Contacts />} />
                <Route path="/reports" element={<Reports />} />
                <Route path="/orders" element={<Orders />} />
                <Route path="/companies" element={<Companies />} />
                <Route path="/parts" element={<Parts />} />
            </Routes>
        </Router>
    );
};

export default App;
