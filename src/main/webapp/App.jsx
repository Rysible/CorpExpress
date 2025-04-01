import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Home from "./pages/Home";

const App = () => {
    return (
        <Router>
            <Header />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/contacts" element={<h1>Contacts Page</h1>} />
                <Route path="/companies" element={<h1>Companies Page</h1>} />
                <Route path="/orders" element={<h1>Orders Page</h1>} />
                <Route path="/parts" element={<h1>Parts Page</h1>} />
                <Route path="/reports" element={<h1>Reports Page</h1>} />
            </Routes>
        </Router>
    );
};

export default App;
