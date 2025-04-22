
import { useNavigate } from 'react-router';
interface IProductComponentProps{
    id: number,
    image: string,
    name: string,
    price: string,
    discount: string
}
function ProductComponent(props: IProductComponentProps) {
  const {image, name, price, discount, id} = props;  
  const navigate = useNavigate();
  const goTodetail = ()=>{
    navigate('/product-detail/'+id);
  }
  const addToCart = ()=>{
    fetch("http://localhost:9090/dev/v1/sepet/add-sepet")
    

  }

  return (
    <div className="col-lg-3 col-md-6 col-sm-12 pb-1">
    <div className="card product-item border-0 mb-4">
        <div className="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
            <img className="img-fluid w-100" src={image} alt="product" />
        </div>
        <div className="card-body border-left border-right text-center p-0 pt-4 pb-3">
            <h6 className="text-truncate mb-3">{name}</h6>
            <div className="d-flex justify-content-center">
                <h6>{price}</h6><h6 className="text-muted ml-2"><del>{discount}</del></h6>
            </div>
        </div>
        <div className="card-footer d-flex justify-content-between bg-light border">
            <a href="" onClick={goTodetail} className="btn btn-sm text-dark p-0"><i className="fas fa-eye text-primary mr-1"></i>View Detail</a>
            <a href="" onClick={addToCart}   className="btn btn-sm text-dark p-0"><i className="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
        </div>
    </div>
</div>
  )
}

export default ProductComponent