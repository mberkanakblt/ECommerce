
interface OfferComponentProps {
    position: 'LEFT' | 'RIGHT'
    offer: string,
    title: string,
    image: string
}

function OfferComponent(props: OfferComponentProps) {
  return (
    <div className="col-md-6 pb-4">
                <div className={"position-relative bg-secondary text-center text-md-"+ props.position +"text-white mb-2 py-5 px-5"}>
                    <img src={props.image} alt="offer" />
                    <div className="position-relative" style={{zIndex: 1}}>
                        <h5 className="text-uppercase text-primary mb-3">{props.offer}</h5>
                        <h1 className="mb-4 font-weight-semi-bold">{props.title}</h1>
                        <a href="" className="btn btn-outline-primary py-md-2 px-md-3">Shop Now</a>
                    </div>
                </div>
            </div>
  )
}

export default OfferComponent