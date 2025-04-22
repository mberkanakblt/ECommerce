import  { useEffect, useState } from 'react'
import ProductComponent from '../molecules/ProductComponent';
import IProductModel from '../../models/IProductModel';


function JustArrivedComponen() {
    
    const [productList, setProductList] = useState<IProductModel[]>([]);
    useEffect(()=>{
        fetch('http://localhost:9090/dev/v1/urun/get-all-urun')
        .then(res=> res.json())
        .then(response=> {
            setProductList(response.data);


        })
    },[]);
  return (
    <div className="container-fluid pt-5">
        <div className="text-center mb-4">
            <h2 className="section-title px-5"><span className="px-2">Just Arrived</span></h2>
        </div>
        <div className="row px-xl-5 pb-3">
            {
                productList.map((product,index)=>{
                    return <ProductComponent 
                            id={product.id}
                            key={index}
                            name={product.ad}
                            image={product.resim}
                            price={product.fiyat+' ₺'}
                            discount={product.fiyat*1.18+' ₺'}
                        />
                })
            }
        </div>
    </div>
  )
}

export default JustArrivedComponen