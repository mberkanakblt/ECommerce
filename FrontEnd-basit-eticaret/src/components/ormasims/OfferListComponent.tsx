
import OfferComponent from '../molecules/OfferComponent'

function OfferListComponent() {
  return (
    <div className="container-fluid offer pt-5">
    <div className="row px-xl-5">
        <OfferComponent position="LEFT" offer="20% off your first order" title="Spring Collection" image="img/offer-1.png" />
        <OfferComponent position="RIGHT" offer="Free Shipping on Orders Over $99" title="Summer Collection" image="img/offer-2.png" />
        
    </div>
</div>
  )
}

export default OfferListComponent