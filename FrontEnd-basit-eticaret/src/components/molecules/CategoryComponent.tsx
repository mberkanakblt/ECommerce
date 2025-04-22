import React from 'react'
interface CategoryComponentProps {
    productCount: number;
    imageUrl: string;
    title : string;

    }

function CategoryComponent(props: CategoryComponentProps) {
  return (
    <div className="col-lg-4 col-md-6 pb-1">
                <div className="cat-item d-flex flex-column border mb-4" style={{padding: '30px'}}>
                    <p className="text-right">{props.productCount}</p>
                    <a href="" className="cat-img position-relative overflow-hidden mb-3">
                        <img className="img-fluid" src={props.imageUrl} alt="cat" />
                    </a>
                    <h5 className="font-weight-semi-bold m-0">{props.title}</h5>
                </div>
            </div>
  )
}

export default React.memo(CategoryComponent);