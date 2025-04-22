import  { useEffect, useState } from 'react'

function FooterSearchComponent() {
    const [userName, setUserName] = useState('');
    useEffect(()=>{
        let token = sessionStorage.getItem('token');
        if(token !== null)
            fetch('http://localhost:9090/dev/v1/kullanici/get-user-name/'+token)
            .then(res=>res.json())
            .then(response=>{
                if(response.code===200){
                    setUserName(response.data)
                }
            })
    },[]);
  return (
    <div className="row align-items-center py-3 px-xl-5">
    <div className="col-lg-3 d-none d-lg-block">
        <a href="" className="text-decoration-none">
            <h1 className="m-0 display-5 font-weight-semi-bold"><span className="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
        </a>
    </div>
    <div className="col-lg-6 col-6 text-left">
        <form action="">
            <div className="input-group">
                <input type="text" className="form-control" placeholder="Search for products" />
                <div className="input-group-append">
                    <span className="input-group-text bg-transparent text-primary">
                        <i className="fa fa-search"></i>
                    </span>
                </div>
            </div>
        </form>
    </div>
    <div className="col-lg-3 col-6 text-right">
        <a href="" className="btn border">
            <i className="fas fa-user text-primary"></i>
            <span className="badge">{userName}</span>
        </a>
        <a href="" className="btn border">
            <i className="fas fa-shopping-cart text-primary"></i>
            <span className="badge">0</span>
        </a>
    </div>
    </div>
  )
}

export default FooterSearchComponent