import { useNavigate } from "react-router-dom";
import "./Home.css";

const Home = () => {
    const navigate = useNavigate();
    const signUpHandler = () => {
        navigate('/register');
    }
    const loginHandler = () => {
        navigate('/login');
    }

    return (
        <div className="body">
            <h1>Welcome to NITConf!</h1>
            <div className="container">
                <div className="prompt">
                    <p>Are you a new user?</p>
                    <button className="button signup" onClick={signUpHandler}>
                        Sign up
                    </button>
                </div>
                <div className="prompt">
                    <p>Already have an account?</p>
                    <button className="button login" onClick={loginHandler}>
                        Log in
                    </button>
                </div>
            </div>
        </div>
    )
}

export default Home;
