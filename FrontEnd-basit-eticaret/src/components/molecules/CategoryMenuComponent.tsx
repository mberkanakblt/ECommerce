import  { useEffect, useState } from 'react'
import ICategoryModel from '../../models/ICategoryModel';

function CategoryMenuComponent() {
  const [categories, setCategories] = useState<ICategoryModel[]>([]);
  useEffect(()=>{
    fetch('http://localhost:9090/dev/v1/kategori/get-main-kategori')
    .then(res=> res.json())
    .then(response=> setCategories(response.data))
  },[]);
  return (
    <div className="col-lg-3 d-none d-lg-block">
    <a className="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style={{height: '65px', marginTop: '-1px', padding: '0 30px'}}>
        <h6 className="m-0">Categories</h6>
        <i className="fa fa-angle-down text-dark"></i>
    </a>
    <nav 
    style={{width: 'calc(100% - 30px)', zIndex: 1}}
    className="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical">
        <div className="navbar-nav w-100 overflow-hidden" style={{height:'410px'}}>
            {
                categories.map((category,index)=>{
                    return <a key={index} href="" className="nav-item nav-link">{category.ad}</a>
                })
            }   
        </div>
    </nav> 
</div>
  )
}

export default CategoryMenuComponent