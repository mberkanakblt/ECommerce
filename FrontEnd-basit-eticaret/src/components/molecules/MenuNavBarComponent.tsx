import  { useEffect, useState } from 'react'

function MenuNavBarComponent() {
    const [isLogin, setIsLogin] = useState(false);
    useEffect(()=>{
        let token = sessionStorage.getItem('token');
        if(token !== null) setIsLogin(true);
        else setIsLogin(false);
    },[])
  return (
    <nav className="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" className="text-decoration-none d-block d-lg-none">
                        <h1 className="m-0 display-5 font-weight-semi-bold"><span className="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" className="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div className="navbar-nav mr-auto py-0">
                            <a href="index.html" className="nav-item nav-link active">Home</a>
                            <a href="shop.html" className="nav-item nav-link">Shop</a>
                            <a href="detail.html" className="nav-item nav-link">Shop Detail</a>
                            <div className="nav-item dropdown">
                                <a href="#" className="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                                <div className="dropdown-menu rounded-0 m-0">
                                    <a href="cart.html" className="dropdown-item">Shopping Cart</a>
                                    <a href="checkout.html" className="dropdown-item">Checkout</a>
                                </div>
                            </div>
                            <a href="contact.html" className="nav-item nav-link">Contact</a>
                        </div>
                        {
                            isLogin ? null : 
                            <div className="navbar-nav ml-auto py-0">
                                <a href="/login" className="nav-item nav-link">Login</a>
                                <a href="/register" className="nav-item nav-link">Register</a>
                            </div>
                        
                        }
                       
                    </div>
                </nav>
  )
}

export default MenuNavBarComponent