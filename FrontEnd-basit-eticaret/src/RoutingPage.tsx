import { Route, Routes } from 'react-router'
import { BrowserRouter } from 'react-router'
import HomePage from './pages/Home/HomePage'
import LoginPage from './pages/login/LoginPage'
import RegisterPage from './pages/register/RegisterPage'
import ProductDetail from './pages/detail/ProductDetail'
import AdminPanel from './pages/Admin/AdminPanel'
import CategoryPage from './pages/Admin/CategoryPage'
import ProductEditPage from './pages/Admin/ProductEditPage'
import CartPage from './pages/cart/CartPage'
function RoutingPage() {
  return (
    <BrowserRouter>
      <Routes>
      <Route path='/' element={<HomePage />}/>
      
          <Route path='/login' element={<LoginPage />}/>
          <Route path='/register' element={<RegisterPage />}/>
          <Route path='/product-detail/:urunId' element={<ProductDetail />}/>
          <Route path='/admin-panel' element={<AdminPanel />}/>
          <Route path='/category' element={<CategoryPage />}/>
          <Route path='/product-edit' element={<ProductEditPage />}/>
          <Route path='/cart' element={<CartPage/>}/>

      </Routes>


    </BrowserRouter>
  )
}

export default RoutingPage